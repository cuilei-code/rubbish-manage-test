package com.ruoyi.rubbish.service;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.ruoyi.common.constant.Constants;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.MessageUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.common.utils.uuid.UUID;
import com.ruoyi.framework.manager.AsyncManager;
import com.ruoyi.framework.manager.factory.AsyncFactory;
import com.ruoyi.rubbish.config.RubbishConfig;
import com.ruoyi.rubbish.domain.WxUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ThreadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p></p>
 *
 * @author lichanghao
 * @version 1.0
 * @date 2023/6/10 上午 11:09
 */
@Slf4j
@Component
public class WeChatService {
    private final static String tokenApi = "https://api.weixin.qq.com/cgi-bin/token";
    private final static String Token_Key = "wechat:token";

    @Autowired
    private RedisCache cache;
    @Autowired
    private RubbishConfig config;
    @Autowired
    private IWxUserService wxUserService;
    private final Lock lock = new ReentrantLock();

    /**
     * 登录时获取的 code（微信官方提供的临时凭证）
     * @param object
     * @return AjaxResult
     */
    public AjaxResult wxLogin(Map object){
        //微信官方提供的微信小程序登录授权时使用的URL地址
        String url  = "https://api.weixin.qq.com/sns/jscode2session";
        //System.out.println(object);
        /**
         * 拼接需要的参数
         * js_code =  wx.login()获取的
         * grant_type=authorization_code = code 微信官方提供的临时凭证
         */
        String params = StringUtils.format("appid={}&secret={}&js_code={}&grant_type=authorization_code", config.getAppId(), config.getAppSecret(), object.get("code"));
        //开始发起网络请求,若依管理系统自带网络请求工具，直接使用即可
        log.info("前端登录入参：{}",object);
        log.info(params);
        String res = HttpUtils.sendGet(url,params);
        log.info("输出请求到的结果：{}",res);
        JSONObject jsonObject = JSON.parseObject(res);
        String session_key = jsonObject.getString("session_key");
        String openid = jsonObject.getString("openid");
        if (StringUtils.isEmpty(openid)) {
            return AjaxResult.error("未获取到openid");
        }
        String token = UUID.randomUUID().toString();
        Map<String, Object> data = new HashMap<>();
        data.put("token", token);
        data.put("session_key", session_key);
        data.put("openid", openid);
        data.put("state",true);
        data.put("nickName",object.get("nickName"));
        data.put("avatarUrl",object.get("avatarUrl"));

        /*先通过openid来查询是否存在*/
        WxUser user = wxUserService.selectWxUserByOpenId(openid);

        if (user == null) {
            /**如果不存在就插入到数据库里*/
            WxUser wxuser = new WxUser();
            wxuser.setNickName((String) object.get("nickName"));
            wxuser.setGender((String) object.get("gender"));
            wxuser.setAvator((String) object.get("avatarUrl"));
            wxuser.setOpenid(openid);
            wxuser.setWxUid(jsonObject.getString("unionid"));
            wxuser.setUserProvice((String) object.get("province"));
            wxuser.setUserCountry((String) object.get("country"));
            wxuser.setUserCity((String) object.get("city"));
            wxuser.setCreateTime(DateUtils.getNowDate());
            wxuser.setCreateBy("admin");
            wxuser.setTelephone(getPhoneNumber((String) object.get("p_code")));
            wxUserService.insertWxUser(wxuser);
        }else {
            /**如果存在就更新数据库里原有的数据*/
            user.setNickName((String) object.get("nickName"));
            user.setGender((String) object.get("gender"));
            user.setAvator((String) object.get("avatarUrl"));
            user.setUpdateTime(DateUtils.getNowDate());
            user.setUpdateBy("admin");
            user.setUserProvice((String) object.get("province"));
            user.setUserCountry((String) object.get("country"));
            user.setUserCity((String) object.get("city"));
            user.setTelephone(getPhoneNumber((String) object.get("p_code")));
            wxUserService.updateWxUser(user);
        }
        //记录登录成功
        AsyncManager.me().execute(AsyncFactory.recordLogininfor((String) object.get("nickName"), Constants.LOGIN_SUCCESS, MessageUtils.message("user.login.success")));
        /*返回结果集到前段*/
        return AjaxResult.success(data);
    }
    public Map<String,String> getToken(){
        Map<String,String> map = new HashMap<>();
        if (cache.hasKey(Token_Key)) {
            map.put("token",(String) cache.redisTemplate.opsForValue().get(Token_Key));
            return map;
        }

        String param = "?grant_type=client_credential&appid={}&secret={}";
        if (lock.tryLock()) {
            try {
                if (!cache.hasKey(Token_Key)) {
                    param = StringUtils.format(param,config.getAppId(),config.getAppSecret());
                    String res = HttpUtils.sendGet(tokenApi, param);
                    JSONObject parse = JSON.parseObject(res);
                    if (parse.containsKey("access_token")){
                        cache.redisTemplate.opsForValue().setIfAbsent(Token_Key,parse.getString("access_token"));
                    }else if (parse.containsKey("errmsg")){
                        map.put("errmsg", parse.getString("errmsg"));
                    }
                }
            } finally {
                lock.unlock();
            }
        }
        map.put("token",(String) cache.redisTemplate.opsForValue().get(Token_Key));
        return map;
    }
    static String phoneApi = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=";
    public String getPhoneNumber(String code) {
        Map<String, String> token = getToken();
        if (token.containsKey("errmsg")){
            return "";
        }
        String t = token.get("token");
        String url = phoneApi + t;
        JSONObject j = null;
        for (int i = 0;i < 3;i++) {
            String res = HttpUtils.sendPost(url, String.format("{\"code\":%s}", code));
            JSONObject jsonObject = JSON.parseObject(res);
            int status = jsonObject.getIntValue("errcode");
            j = jsonObject;
            if (status != -1) {
                break;
            }
            try {
                ThreadUtils.sleep(Duration.of(1, ChronoUnit.SECONDS));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if (j.getIntValue("errcode") != 0) return "";
        JSONObject phoneInfo = j.getJSONObject("phone_info");
        return phoneInfo.getString("purePhoneNumber");
    }
}
