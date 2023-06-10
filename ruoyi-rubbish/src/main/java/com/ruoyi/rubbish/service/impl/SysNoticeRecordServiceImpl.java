package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.SysNoticeRecordMapper;
import com.ruoyi.rubbish.domain.SysNoticeRecord;
import com.ruoyi.rubbish.service.ISysNoticeRecordService;

/**
 * 消息发送记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class SysNoticeRecordServiceImpl implements ISysNoticeRecordService 
{
    @Autowired
    private SysNoticeRecordMapper sysNoticeRecordMapper;

    /**
     * 查询消息发送记录
     * 
     * @param id 消息发送记录主键
     * @return 消息发送记录
     */
    @Override
    public SysNoticeRecord selectSysNoticeRecordById(Long id)
    {
        return sysNoticeRecordMapper.selectSysNoticeRecordById(id);
    }

    /**
     * 查询消息发送记录列表
     * 
     * @param sysNoticeRecord 消息发送记录
     * @return 消息发送记录
     */
    @Override
    public List<SysNoticeRecord> selectSysNoticeRecordList(SysNoticeRecord sysNoticeRecord)
    {
        return sysNoticeRecordMapper.selectSysNoticeRecordList(sysNoticeRecord);
    }

    /**
     * 新增消息发送记录
     * 
     * @param sysNoticeRecord 消息发送记录
     * @return 结果
     */
    @Override
    public int insertSysNoticeRecord(SysNoticeRecord sysNoticeRecord)
    {
        sysNoticeRecord.setCreateTime(DateUtils.getNowDate());
        return sysNoticeRecordMapper.insertSysNoticeRecord(sysNoticeRecord);
    }

    /**
     * 修改消息发送记录
     * 
     * @param sysNoticeRecord 消息发送记录
     * @return 结果
     */
    @Override
    public int updateSysNoticeRecord(SysNoticeRecord sysNoticeRecord)
    {
        sysNoticeRecord.setUpdateTime(DateUtils.getNowDate());
        return sysNoticeRecordMapper.updateSysNoticeRecord(sysNoticeRecord);
    }

    /**
     * 批量删除消息发送记录
     * 
     * @param ids 需要删除的消息发送记录主键
     * @return 结果
     */
    @Override
    public int deleteSysNoticeRecordByIds(Long[] ids)
    {
        return sysNoticeRecordMapper.deleteSysNoticeRecordByIds(ids);
    }

    /**
     * 删除消息发送记录信息
     * 
     * @param id 消息发送记录主键
     * @return 结果
     */
    @Override
    public int deleteSysNoticeRecordById(Long id)
    {
        return sysNoticeRecordMapper.deleteSysNoticeRecordById(id);
    }
}
