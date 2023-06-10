package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.PointUseRecord;

/**
 * 积分使用记录Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IPointUseRecordService 
{
    /**
     * 查询积分使用记录
     * 
     * @param id 积分使用记录主键
     * @return 积分使用记录
     */
    public PointUseRecord selectPointUseRecordById(Long id);

    /**
     * 查询积分使用记录列表
     * 
     * @param pointUseRecord 积分使用记录
     * @return 积分使用记录集合
     */
    public List<PointUseRecord> selectPointUseRecordList(PointUseRecord pointUseRecord);

    /**
     * 新增积分使用记录
     * 
     * @param pointUseRecord 积分使用记录
     * @return 结果
     */
    public int insertPointUseRecord(PointUseRecord pointUseRecord);

    /**
     * 修改积分使用记录
     * 
     * @param pointUseRecord 积分使用记录
     * @return 结果
     */
    public int updatePointUseRecord(PointUseRecord pointUseRecord);

    /**
     * 批量删除积分使用记录
     * 
     * @param ids 需要删除的积分使用记录主键集合
     * @return 结果
     */
    public int deletePointUseRecordByIds(Long[] ids);

    /**
     * 删除积分使用记录信息
     * 
     * @param id 积分使用记录主键
     * @return 结果
     */
    public int deletePointUseRecordById(Long id);
}
