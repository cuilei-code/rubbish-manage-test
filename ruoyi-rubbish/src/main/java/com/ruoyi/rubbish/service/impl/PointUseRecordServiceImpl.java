package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.rubbish.domain.PointUseRecordDetail;
import com.ruoyi.rubbish.mapper.PointUseRecordMapper;
import com.ruoyi.rubbish.domain.PointUseRecord;
import com.ruoyi.rubbish.service.IPointUseRecordService;

/**
 * 积分使用记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class PointUseRecordServiceImpl implements IPointUseRecordService 
{
    @Autowired
    private PointUseRecordMapper pointUseRecordMapper;

    /**
     * 查询积分使用记录
     * 
     * @param id 积分使用记录主键
     * @return 积分使用记录
     */
    @Override
    public PointUseRecord selectPointUseRecordById(Long id)
    {
        return pointUseRecordMapper.selectPointUseRecordById(id);
    }

    /**
     * 查询积分使用记录列表
     * 
     * @param pointUseRecord 积分使用记录
     * @return 积分使用记录
     */
    @Override
    public List<PointUseRecord> selectPointUseRecordList(PointUseRecord pointUseRecord)
    {
        return pointUseRecordMapper.selectPointUseRecordList(pointUseRecord);
    }

    /**
     * 新增积分使用记录
     * 
     * @param pointUseRecord 积分使用记录
     * @return 结果
     */
    @Transactional
    @Override
    public int insertPointUseRecord(PointUseRecord pointUseRecord)
    {
        pointUseRecord.setCreateTime(DateUtils.getNowDate());
        int rows = pointUseRecordMapper.insertPointUseRecord(pointUseRecord);
        insertPointUseRecordDetail(pointUseRecord);
        return rows;
    }

    /**
     * 修改积分使用记录
     * 
     * @param pointUseRecord 积分使用记录
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePointUseRecord(PointUseRecord pointUseRecord)
    {
        pointUseRecord.setUpdateTime(DateUtils.getNowDate());
        pointUseRecordMapper.deletePointUseRecordDetailByUseRecordId(pointUseRecord.getId());
        insertPointUseRecordDetail(pointUseRecord);
        return pointUseRecordMapper.updatePointUseRecord(pointUseRecord);
    }

    /**
     * 批量删除积分使用记录
     * 
     * @param ids 需要删除的积分使用记录主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePointUseRecordByIds(Long[] ids)
    {
        pointUseRecordMapper.deletePointUseRecordDetailByUseRecordIds(ids);
        return pointUseRecordMapper.deletePointUseRecordByIds(ids);
    }

    /**
     * 删除积分使用记录信息
     * 
     * @param id 积分使用记录主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePointUseRecordById(Long id)
    {
        pointUseRecordMapper.deletePointUseRecordDetailByUseRecordId(id);
        return pointUseRecordMapper.deletePointUseRecordById(id);
    }

    /**
     * 新增积分核销记录明细信息
     * 
     * @param pointUseRecord 积分使用记录对象
     */
    public void insertPointUseRecordDetail(PointUseRecord pointUseRecord)
    {
        List<PointUseRecordDetail> pointUseRecordDetailList = pointUseRecord.getPointUseRecordDetailList();
        Long id = pointUseRecord.getId();
        if (StringUtils.isNotNull(pointUseRecordDetailList))
        {
            List<PointUseRecordDetail> list = new ArrayList<PointUseRecordDetail>();
            for (PointUseRecordDetail pointUseRecordDetail : pointUseRecordDetailList)
            {
                pointUseRecordDetail.setUseRecordId(id);
                list.add(pointUseRecordDetail);
            }
            if (list.size() > 0)
            {
                pointUseRecordMapper.batchPointUseRecordDetail(list);
            }
        }
    }
}
