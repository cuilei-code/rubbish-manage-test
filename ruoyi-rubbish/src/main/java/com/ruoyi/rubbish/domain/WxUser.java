package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客户端普通用户对象 wx_user
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class WxUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 微信昵称 */
    @Excel(name = "微信昵称")
    private String nickName;

    /** 姓名 */
    @Excel(name = "姓名")
    private String userName;

    /** 性别  0男   1女 */
    @Excel(name = "性别  0男   1女")
    private String gender;

    /** 微信openid */
    @Excel(name = "微信openid")
    private String openid;

    /** 微信uid */
    @Excel(name = "微信uid")
    private String wxUid;

    /** 手机号 */
    @Excel(name = "手机号")
    private String telephone;

    /** 头像 */
    @Excel(name = "头像")
    private String avator;

    /** 省 */
    @Excel(name = "省")
    private String userProvice;

    /** 市 */
    @Excel(name = "市")
    private String userCity;

    /** 国家 */
    @Excel(name = "国家")
    private String userCountry;

    /** 个人微信二维码 */
    @Excel(name = "个人微信二维码")
    private String wxQrcode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setGender(String gender) 
    {
        this.gender = gender;
    }

    public String getGender() 
    {
        return gender;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setWxUid(String wxUid) 
    {
        this.wxUid = wxUid;
    }

    public String getWxUid() 
    {
        return wxUid;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setAvator(String avator) 
    {
        this.avator = avator;
    }

    public String getAvator() 
    {
        return avator;
    }
    public void setUserProvice(String userProvice) 
    {
        this.userProvice = userProvice;
    }

    public String getUserProvice() 
    {
        return userProvice;
    }
    public void setUserCity(String userCity) 
    {
        this.userCity = userCity;
    }

    public String getUserCity() 
    {
        return userCity;
    }
    public void setUserCountry(String userCountry) 
    {
        this.userCountry = userCountry;
    }

    public String getUserCountry() 
    {
        return userCountry;
    }
    public void setWxQrcode(String wxQrcode) 
    {
        this.wxQrcode = wxQrcode;
    }

    public String getWxQrcode() 
    {
        return wxQrcode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickName", getNickName())
            .append("userName", getUserName())
            .append("gender", getGender())
            .append("openid", getOpenid())
            .append("wxUid", getWxUid())
            .append("telephone", getTelephone())
            .append("avator", getAvator())
            .append("userProvice", getUserProvice())
            .append("userCity", getUserCity())
            .append("userCountry", getUserCountry())
            .append("wxQrcode", getWxQrcode())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
