package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 临时积分对象 point_temporary
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class PointTemporary extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 微信uid */
    @Excel(name = "微信uid")
    private String wxUid;

    /** 积分数量，记录的是拉新用户的那个人，赠送的临时积分。待被拉的新人使用小程序后，该积分3天后实际充值到推荐人的账户中 */
    @Excel(name = "积分数量，记录的是拉新用户的那个人，赠送的临时积分。待被拉的新人使用小程序后，该积分3天后实际充值到推荐人的账户中")
    private Long pointNum;

    /** 积分状态  0未到账   1已到账 */
    @Excel(name = "积分状态  0未到账   1已到账")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setWxUid(String wxUid) 
    {
        this.wxUid = wxUid;
    }

    public String getWxUid() 
    {
        return wxUid;
    }
    public void setPointNum(Long pointNum) 
    {
        this.pointNum = pointNum;
    }

    public Long getPointNum() 
    {
        return pointNum;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wxUid", getWxUid())
            .append("pointNum", getPointNum())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
