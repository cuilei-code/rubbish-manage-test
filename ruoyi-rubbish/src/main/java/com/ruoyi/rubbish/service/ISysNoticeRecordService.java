package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.SysNoticeRecord;

/**
 * 消息发送记录Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface ISysNoticeRecordService 
{
    /**
     * 查询消息发送记录
     * 
     * @param id 消息发送记录主键
     * @return 消息发送记录
     */
    public SysNoticeRecord selectSysNoticeRecordById(Long id);

    /**
     * 查询消息发送记录列表
     * 
     * @param sysNoticeRecord 消息发送记录
     * @return 消息发送记录集合
     */
    public List<SysNoticeRecord> selectSysNoticeRecordList(SysNoticeRecord sysNoticeRecord);

    /**
     * 新增消息发送记录
     * 
     * @param sysNoticeRecord 消息发送记录
     * @return 结果
     */
    public int insertSysNoticeRecord(SysNoticeRecord sysNoticeRecord);

    /**
     * 修改消息发送记录
     * 
     * @param sysNoticeRecord 消息发送记录
     * @return 结果
     */
    public int updateSysNoticeRecord(SysNoticeRecord sysNoticeRecord);

    /**
     * 批量删除消息发送记录
     * 
     * @param ids 需要删除的消息发送记录主键集合
     * @return 结果
     */
    public int deleteSysNoticeRecordByIds(Long[] ids);

    /**
     * 删除消息发送记录信息
     * 
     * @param id 消息发送记录主键
     * @return 结果
     */
    public int deleteSysNoticeRecordById(Long id);
}
