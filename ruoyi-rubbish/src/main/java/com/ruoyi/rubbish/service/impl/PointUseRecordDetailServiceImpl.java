package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.PointUseRecordDetailMapper;
import com.ruoyi.rubbish.domain.PointUseRecordDetail;
import com.ruoyi.rubbish.service.IPointUseRecordDetailService;

/**
 * 积分核销记录明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class PointUseRecordDetailServiceImpl implements IPointUseRecordDetailService 
{
    @Autowired
    private PointUseRecordDetailMapper pointUseRecordDetailMapper;

    /**
     * 查询积分核销记录明细
     * 
     * @param id 积分核销记录明细主键
     * @return 积分核销记录明细
     */
    @Override
    public PointUseRecordDetail selectPointUseRecordDetailById(Long id)
    {
        return pointUseRecordDetailMapper.selectPointUseRecordDetailById(id);
    }

    /**
     * 查询积分核销记录明细列表
     * 
     * @param pointUseRecordDetail 积分核销记录明细
     * @return 积分核销记录明细
     */
    @Override
    public List<PointUseRecordDetail> selectPointUseRecordDetailList(PointUseRecordDetail pointUseRecordDetail)
    {
        return pointUseRecordDetailMapper.selectPointUseRecordDetailList(pointUseRecordDetail);
    }

    /**
     * 新增积分核销记录明细
     * 
     * @param pointUseRecordDetail 积分核销记录明细
     * @return 结果
     */
    @Override
    public int insertPointUseRecordDetail(PointUseRecordDetail pointUseRecordDetail)
    {
        pointUseRecordDetail.setCreateTime(DateUtils.getNowDate());
        return pointUseRecordDetailMapper.insertPointUseRecordDetail(pointUseRecordDetail);
    }

    /**
     * 修改积分核销记录明细
     * 
     * @param pointUseRecordDetail 积分核销记录明细
     * @return 结果
     */
    @Override
    public int updatePointUseRecordDetail(PointUseRecordDetail pointUseRecordDetail)
    {
        pointUseRecordDetail.setUpdateTime(DateUtils.getNowDate());
        return pointUseRecordDetailMapper.updatePointUseRecordDetail(pointUseRecordDetail);
    }

    /**
     * 批量删除积分核销记录明细
     * 
     * @param ids 需要删除的积分核销记录明细主键
     * @return 结果
     */
    @Override
    public int deletePointUseRecordDetailByIds(Long[] ids)
    {
        return pointUseRecordDetailMapper.deletePointUseRecordDetailByIds(ids);
    }

    /**
     * 删除积分核销记录明细信息
     * 
     * @param id 积分核销记录明细主键
     * @return 结果
     */
    @Override
    public int deletePointUseRecordDetailById(Long id)
    {
        return pointUseRecordDetailMapper.deletePointUseRecordDetailById(id);
    }
}
