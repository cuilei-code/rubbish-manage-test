package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 提现记录对象 Withdrawal_Record_Main
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class WithdrawalRecordMain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 微信uid */
    @Excel(name = "微信uid")
    private String wxUid;

    /** 微信昵称 */
    @Excel(name = "微信昵称")
    private String wxNickname;

    /** 提现金额 */
    @Excel(name = "提现金额")
    private Long withdrawAmount;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String isDeleted;

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
    public void setWxNickname(String wxNickname) 
    {
        this.wxNickname = wxNickname;
    }

    public String getWxNickname() 
    {
        return wxNickname;
    }
    public void setWithdrawAmount(Long withdrawAmount) 
    {
        this.withdrawAmount = withdrawAmount;
    }

    public Long getWithdrawAmount() 
    {
        return withdrawAmount;
    }
    public void setIsDeleted(String isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public String getIsDeleted() 
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wxUid", getWxUid())
            .append("wxNickname", getWxNickname())
            .append("withdrawAmount", getWithdrawAmount())
            .append("remark", getRemark())
            .append("isDeleted", getIsDeleted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
