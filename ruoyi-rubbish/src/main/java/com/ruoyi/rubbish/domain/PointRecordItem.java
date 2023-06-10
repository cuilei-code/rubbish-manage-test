package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分类目明细对象 point_record_item
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class PointRecordItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 积分类目主表id */
    @Excel(name = "积分类目主表id")
    private Long recordMainId;

    /** 有效积分(真积分) */
    @Excel(name = "有效积分(真积分)")
    private Long effectivePoint;

    /** 虚拟积分(假积分) */
    @Excel(name = "虚拟积分(假积分)")
    private Long virtualPoint;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setRecordMainId(Long recordMainId) 
    {
        this.recordMainId = recordMainId;
    }

    public Long getRecordMainId() 
    {
        return recordMainId;
    }
    public void setEffectivePoint(Long effectivePoint) 
    {
        this.effectivePoint = effectivePoint;
    }

    public Long getEffectivePoint() 
    {
        return effectivePoint;
    }
    public void setVirtualPoint(Long virtualPoint) 
    {
        this.virtualPoint = virtualPoint;
    }

    public Long getVirtualPoint() 
    {
        return virtualPoint;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("recordMainId", getRecordMainId())
            .append("effectivePoint", getEffectivePoint())
            .append("virtualPoint", getVirtualPoint())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
