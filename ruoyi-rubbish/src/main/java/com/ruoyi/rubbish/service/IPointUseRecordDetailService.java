package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.PointUseRecordDetail;

/**
 * 积分核销记录明细Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IPointUseRecordDetailService 
{
    /**
     * 查询积分核销记录明细
     * 
     * @param id 积分核销记录明细主键
     * @return 积分核销记录明细
     */
    public PointUseRecordDetail selectPointUseRecordDetailById(Long id);

    /**
     * 查询积分核销记录明细列表
     * 
     * @param pointUseRecordDetail 积分核销记录明细
     * @return 积分核销记录明细集合
     */
    public List<PointUseRecordDetail> selectPointUseRecordDetailList(PointUseRecordDetail pointUseRecordDetail);

    /**
     * 新增积分核销记录明细
     * 
     * @param pointUseRecordDetail 积分核销记录明细
     * @return 结果
     */
    public int insertPointUseRecordDetail(PointUseRecordDetail pointUseRecordDetail);

    /**
     * 修改积分核销记录明细
     * 
     * @param pointUseRecordDetail 积分核销记录明细
     * @return 结果
     */
    public int updatePointUseRecordDetail(PointUseRecordDetail pointUseRecordDetail);

    /**
     * 批量删除积分核销记录明细
     * 
     * @param ids 需要删除的积分核销记录明细主键集合
     * @return 结果
     */
    public int deletePointUseRecordDetailByIds(Long[] ids);

    /**
     * 删除积分核销记录明细信息
     * 
     * @param id 积分核销记录明细主键
     * @return 结果
     */
    public int deletePointUseRecordDetailById(Long id);
}
