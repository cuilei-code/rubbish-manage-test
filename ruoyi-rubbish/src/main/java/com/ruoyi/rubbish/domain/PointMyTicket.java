package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 兑换券管理对象 point_my_ticket
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class PointMyTicket extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 券码 */
    @Excel(name = "券码")
    private String ticketCode;

    /** 是否已核销    0未核销    1已核销 */
    @Excel(name = "是否已核销    0未核销    1已核销")
    private String isUse;

    /** 券的图片链接 */
    @Excel(name = "券的图片链接")
    private String ticketUrl;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTicketCode(String ticketCode) 
    {
        this.ticketCode = ticketCode;
    }

    public String getTicketCode() 
    {
        return ticketCode;
    }
    public void setIsUse(String isUse) 
    {
        this.isUse = isUse;
    }

    public String getIsUse() 
    {
        return isUse;
    }
    public void setTicketUrl(String ticketUrl) 
    {
        this.ticketUrl = ticketUrl;
    }

    public String getTicketUrl() 
    {
        return ticketUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("ticketCode", getTicketCode())
            .append("isUse", getIsUse())
            .append("ticketUrl", getTicketUrl())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
