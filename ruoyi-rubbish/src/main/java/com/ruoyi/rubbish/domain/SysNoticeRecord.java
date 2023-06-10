package com.ruoyi.rubbish.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 消息发送记录对象 sys_Notice_Record
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public class SysNoticeRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 系统通知主表id */
    @Excel(name = "系统通知主表id")
    private Long noticeId;

    /** 发送人 */
    @Excel(name = "发送人")
    private Long sendUser;

    /** 接收人 */
    @Excel(name = "接收人")
    private Long toUser;

    /** 已读未读   0未读   1未读 */
    @Excel(name = "已读未读   0未读   1未读")
    private String readStatus;

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
    public void setNoticeId(Long noticeId) 
    {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() 
    {
        return noticeId;
    }
    public void setSendUser(Long sendUser) 
    {
        this.sendUser = sendUser;
    }

    public Long getSendUser() 
    {
        return sendUser;
    }
    public void setToUser(Long toUser) 
    {
        this.toUser = toUser;
    }

    public Long getToUser() 
    {
        return toUser;
    }
    public void setReadStatus(String readStatus) 
    {
        this.readStatus = readStatus;
    }

    public String getReadStatus() 
    {
        return readStatus;
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
            .append("noticeId", getNoticeId())
            .append("sendUser", getSendUser())
            .append("toUser", getToUser())
            .append("readStatus", getReadStatus())
            .append("isDeleted", getIsDeleted())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
