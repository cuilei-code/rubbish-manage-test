package com.ruoyi.rubbish.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分使用记录对象 point_use_record
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class PointUseRecord extends BaseEntity
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

    /** 使用渠道    0微信提现    1积分兑换 */
    @Excel(name = "使用渠道    0微信提现    1积分兑换")
    private String useChannel;

    /** 积分商城主表id */
    @Excel(name = "积分商城主表id")
    private Long mallMainId;

    /** 兑换数量 */
    @Excel(name = "兑换数量")
    private Long exchangeCount;

    /** 已使用数量，核销后回写该字段 */
    @Excel(name = "已使用数量，核销后回写该字段")
    private Long useCount;

    /** 使用状态   0核销   1部分核销  2全部核销 */
    @Excel(name = "使用状态   0核销   1部分核销  2全部核销")
    private String useStatus;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String isDeleted;

    /** 积分核销记录明细信息 */
    private List<PointUseRecordDetail> pointUseRecordDetailList;

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
    public void setUseChannel(String useChannel) 
    {
        this.useChannel = useChannel;
    }

    public String getUseChannel() 
    {
        return useChannel;
    }
    public void setMallMainId(Long mallMainId) 
    {
        this.mallMainId = mallMainId;
    }

    public Long getMallMainId() 
    {
        return mallMainId;
    }
    public void setExchangeCount(Long exchangeCount) 
    {
        this.exchangeCount = exchangeCount;
    }

    public Long getExchangeCount() 
    {
        return exchangeCount;
    }
    public void setUseCount(Long useCount) 
    {
        this.useCount = useCount;
    }

    public Long getUseCount() 
    {
        return useCount;
    }
    public void setUseStatus(String useStatus) 
    {
        this.useStatus = useStatus;
    }

    public String getUseStatus() 
    {
        return useStatus;
    }
    public void setIsDeleted(String isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public String getIsDeleted() 
    {
        return isDeleted;
    }

    public List<PointUseRecordDetail> getPointUseRecordDetailList()
    {
        return pointUseRecordDetailList;
    }

    public void setPointUseRecordDetailList(List<PointUseRecordDetail> pointUseRecordDetailList)
    {
        this.pointUseRecordDetailList = pointUseRecordDetailList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wxUid", getWxUid())
            .append("wxNickname", getWxNickname())
            .append("useChannel", getUseChannel())
            .append("mallMainId", getMallMainId())
            .append("exchangeCount", getExchangeCount())
            .append("useCount", getUseCount())
            .append("useStatus", getUseStatus())
            .append("isDeleted", getIsDeleted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("pointUseRecordDetailList", getPointUseRecordDetailList())
            .toString();
    }
}
