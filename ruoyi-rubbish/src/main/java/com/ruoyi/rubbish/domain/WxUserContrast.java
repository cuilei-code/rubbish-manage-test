package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 新人拉新记录对象 wx_user_contrast
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class WxUserContrast extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 新人的微信uid */
    @Excel(name = "新人的微信uid")
    private String newPersonWxuid;

    /** 拉新用户的微信uid，推荐人 */
    @Excel(name = "拉新用户的微信uid，推荐人")
    private String recommendedWxuid;

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
    public void setNewPersonWxuid(String newPersonWxuid) 
    {
        this.newPersonWxuid = newPersonWxuid;
    }

    public String getNewPersonWxuid() 
    {
        return newPersonWxuid;
    }
    public void setRecommendedWxuid(String recommendedWxuid) 
    {
        this.recommendedWxuid = recommendedWxuid;
    }

    public String getRecommendedWxuid() 
    {
        return recommendedWxuid;
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
            .append("newPersonWxuid", getNewPersonWxuid())
            .append("recommendedWxuid", getRecommendedWxuid())
            .append("isDeleted", getIsDeleted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
