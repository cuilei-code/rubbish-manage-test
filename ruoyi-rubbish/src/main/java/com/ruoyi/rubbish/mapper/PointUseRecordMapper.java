package com.ruoyi.rubbish.mapper;

import java.util.List;
import com.ruoyi.rubbish.domain.PointUseRecord;
import com.ruoyi.rubbish.domain.PointUseRecordDetail;

/**
 * 积分使用记录Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface PointUseRecordMapper 
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
     * 删除积分使用记录
     * 
     * @param id 积分使用记录主键
     * @return 结果
     */
    public int deletePointUseRecordById(Long id);

    /**
     * 批量删除积分使用记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePointUseRecordByIds(Long[] ids);

    /**
     * 批量删除积分核销记录明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePointUseRecordDetailByUseRecordIds(Long[] ids);
    
    /**
     * 批量新增积分核销记录明细
     * 
     * @param pointUseRecordDetailList 积分核销记录明细列表
     * @return 结果
     */
    public int batchPointUseRecordDetail(List<PointUseRecordDetail> pointUseRecordDetailList);
    

    /**
     * 通过积分使用记录主键删除积分核销记录明细信息
     * 
     * @param id 积分使用记录ID
     * @return 结果
     */
    public int deletePointUseRecordDetailByUseRecordId(Long id);
}
