package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分核销记录明细对象 point_use_record_detail
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class PointUseRecordDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 使用记录主表id */
    @Excel(name = "使用记录主表id")
    private Long useRecordId;

    /** 本次使用数量 */
    @Excel(name = "本次使用数量")
    private Long useCount;

    /** 使用说明 */
    @Excel(name = "使用说明")
    private String useRemark;

    /** 券码 */
    @Excel(name = "券码")
    private String ticketCode;

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
    public void setUseRecordId(Long useRecordId) 
    {
        this.useRecordId = useRecordId;
    }

    public Long getUseRecordId() 
    {
        return useRecordId;
    }
    public void setUseCount(Long useCount) 
    {
        this.useCount = useCount;
    }

    public Long getUseCount() 
    {
        return useCount;
    }
    public void setUseRemark(String useRemark) 
    {
        this.useRemark = useRemark;
    }

    public String getUseRemark() 
    {
        return useRemark;
    }
    public void setTicketCode(String ticketCode) 
    {
        this.ticketCode = ticketCode;
    }

    public String getTicketCode() 
    {
        return ticketCode;
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
            .append("useRecordId", getUseRecordId())
            .append("useCount", getUseCount())
            .append("useRemark", getUseRemark())
            .append("ticketCode", getTicketCode())
            .append("isDeleted", getIsDeleted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
