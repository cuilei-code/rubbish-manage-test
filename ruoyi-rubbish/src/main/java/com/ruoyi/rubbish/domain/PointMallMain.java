package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分商城管理对象 point_mall_main
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class PointMallMain extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 商品分类id */
    @Excel(name = "商品分类id")
    private Long typeMainId;

    /** 产品编号 */
    @Excel(name = "产品编号")
    private String productCode;

    /** 产品名称 */
    @Excel(name = "产品名称")
    private String productName;

    /** 产品状态 */
    @Excel(name = "产品状态")
    private String productStatus;

    /** 已售 */
    @Excel(name = "已售")
    private Long saleVolume;

    /** 需要多少积分可兑换 */
    @Excel(name = "需要多少积分可兑换")
    private Long usePoint;

    /** 产品标签 */
    @Excel(name = "产品标签")
    private String tag;

    /** 库存 */
    @Excel(name = "库存")
    private Long inventory;

    /** 产品描述 */
    @Excel(name = "产品描述")
    private String description;

    /** 产品说明 */
    @Excel(name = "产品说明")
    private String productRemark;

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
    public void setTypeMainId(Long typeMainId) 
    {
        this.typeMainId = typeMainId;
    }

    public Long getTypeMainId() 
    {
        return typeMainId;
    }
    public void setProductCode(String productCode) 
    {
        this.productCode = productCode;
    }

    public String getProductCode() 
    {
        return productCode;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setProductStatus(String productStatus) 
    {
        this.productStatus = productStatus;
    }

    public String getProductStatus() 
    {
        return productStatus;
    }
    public void setSaleVolume(Long saleVolume) 
    {
        this.saleVolume = saleVolume;
    }

    public Long getSaleVolume() 
    {
        return saleVolume;
    }
    public void setUsePoint(Long usePoint) 
    {
        this.usePoint = usePoint;
    }

    public Long getUsePoint() 
    {
        return usePoint;
    }
    public void setTag(String tag) 
    {
        this.tag = tag;
    }

    public String getTag() 
    {
        return tag;
    }
    public void setInventory(Long inventory) 
    {
        this.inventory = inventory;
    }

    public Long getInventory() 
    {
        return inventory;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }
    public void setProductRemark(String productRemark) 
    {
        this.productRemark = productRemark;
    }

    public String getProductRemark() 
    {
        return productRemark;
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
            .append("typeMainId", getTypeMainId())
            .append("productCode", getProductCode())
            .append("productName", getProductName())
            .append("productStatus", getProductStatus())
            .append("saleVolume", getSaleVolume())
            .append("usePoint", getUsePoint())
            .append("tag", getTag())
            .append("inventory", getInventory())
            .append("description", getDescription())
            .append("productRemark", getProductRemark())
            .append("isDeleted", getIsDeleted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
