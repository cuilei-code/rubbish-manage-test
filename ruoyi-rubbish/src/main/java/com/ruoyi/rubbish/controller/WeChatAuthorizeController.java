package com.ruoyi.rubbish.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.enums.OperatorType;
import com.ruoyi.rubbish.service.WeChatService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p></p>
 *
 * @author lichanghao
 * @version 1.0
 * @date 2023/6/10 下午 2:07
 */
@RestController
@RequestMapping("/wechat/")
public class WeChatAuthorizeController {
    private final WeChatService service;

    public WeChatAuthorizeController(WeChatService service) {
        this.service = service;
    }

    @PostMapping("/login")
    @Log(title = "微信登录",businessType = BusinessType.OTHER,operatorType = OperatorType.OTHER)
    public AjaxResult login(@RequestBody Map param){
        return service.wxLogin(param);
    }
}
