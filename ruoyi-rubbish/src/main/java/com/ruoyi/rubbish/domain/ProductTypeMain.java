package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.TreeEntity;

/**
 * 商品分类对象 product_type_main
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class ProductTypeMain extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 父级id */
    @Excel(name = "父级id")
    private Long pid;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String name;

    /** 分类编号 */
    @Excel(name = "分类编号")
    private String code;

    /** 排序 */
    @Excel(name = "排序")
    private String sort;

    /** 是否末级节点    0否   1是 */
    @Excel(name = "是否末级节点    0否   1是")
    private String isDetailNode;

    /** 是否停用 0正常   1停用 */
    @Excel(name = "是否停用 0正常   1停用")
    private String status;

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
    public void setPid(Long pid) 
    {
        this.pid = pid;
    }

    public Long getPid() 
    {
        return pid;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setSort(String sort) 
    {
        this.sort = sort;
    }

    public String getSort() 
    {
        return sort;
    }
    public void setIsDetailNode(String isDetailNode) 
    {
        this.isDetailNode = isDetailNode;
    }

    public String getIsDetailNode() 
    {
        return isDetailNode;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("pid", getPid())
            .append("name", getName())
            .append("code", getCode())
            .append("sort", getSort())
            .append("remark", getRemark())
            .append("isDetailNode", getIsDetailNode())
            .append("status", getStatus())
            .append("isDeleted", getIsDeleted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
