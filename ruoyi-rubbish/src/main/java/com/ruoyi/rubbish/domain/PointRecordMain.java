package com.ruoyi.rubbish.domain;

import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 积分类目对象 point_record_main
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class PointRecordMain extends BaseEntity
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

    /** 所属社区 */
    @Excel(name = "所属社区")
    private String attributePlot;

    /** 积分来源 */
    @Excel(name = "积分来源")
    private String pointSource;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private String isDeleted;

    /** 积分类目明细信息 */
    private List<PointRecordItem> pointRecordItemList;

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
    public void setAttributePlot(String attributePlot) 
    {
        this.attributePlot = attributePlot;
    }

    public String getAttributePlot() 
    {
        return attributePlot;
    }
    public void setPointSource(String pointSource) 
    {
        this.pointSource = pointSource;
    }

    public String getPointSource() 
    {
        return pointSource;
    }
    public void setIsDeleted(String isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public String getIsDeleted() 
    {
        return isDeleted;
    }

    public List<PointRecordItem> getPointRecordItemList()
    {
        return pointRecordItemList;
    }

    public void setPointRecordItemList(List<PointRecordItem> pointRecordItemList)
    {
        this.pointRecordItemList = pointRecordItemList;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("wxUid", getWxUid())
            .append("wxNickname", getWxNickname())
            .append("attributePlot", getAttributePlot())
            .append("pointSource", getPointSource())
            .append("isDeleted", getIsDeleted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("pointRecordItemList", getPointRecordItemList())
            .toString();
    }
}
