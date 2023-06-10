package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.PointRecordItemMapper;
import com.ruoyi.rubbish.domain.PointRecordItem;
import com.ruoyi.rubbish.service.IPointRecordItemService;

/**
 * 积分类目明细Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class PointRecordItemServiceImpl implements IPointRecordItemService 
{
    @Autowired
    private PointRecordItemMapper pointRecordItemMapper;

    /**
     * 查询积分类目明细
     * 
     * @param id 积分类目明细主键
     * @return 积分类目明细
     */
    @Override
    public PointRecordItem selectPointRecordItemById(Long id)
    {
        return pointRecordItemMapper.selectPointRecordItemById(id);
    }

    /**
     * 查询积分类目明细列表
     * 
     * @param pointRecordItem 积分类目明细
     * @return 积分类目明细
     */
    @Override
    public List<PointRecordItem> selectPointRecordItemList(PointRecordItem pointRecordItem)
    {
        return pointRecordItemMapper.selectPointRecordItemList(pointRecordItem);
    }

    /**
     * 新增积分类目明细
     * 
     * @param pointRecordItem 积分类目明细
     * @return 结果
     */
    @Override
    public int insertPointRecordItem(PointRecordItem pointRecordItem)
    {
        pointRecordItem.setCreateTime(DateUtils.getNowDate());
        return pointRecordItemMapper.insertPointRecordItem(pointRecordItem);
    }

    /**
     * 修改积分类目明细
     * 
     * @param pointRecordItem 积分类目明细
     * @return 结果
     */
    @Override
    public int updatePointRecordItem(PointRecordItem pointRecordItem)
    {
        pointRecordItem.setUpdateTime(DateUtils.getNowDate());
        return pointRecordItemMapper.updatePointRecordItem(pointRecordItem);
    }

    /**
     * 批量删除积分类目明细
     * 
     * @param ids 需要删除的积分类目明细主键
     * @return 结果
     */
    @Override
    public int deletePointRecordItemByIds(Long[] ids)
    {
        return pointRecordItemMapper.deletePointRecordItemByIds(ids);
    }

    /**
     * 删除积分类目明细信息
     * 
     * @param id 积分类目明细主键
     * @return 结果
     */
    @Override
    public int deletePointRecordItemById(Long id)
    {
        return pointRecordItemMapper.deletePointRecordItemById(id);
    }
}
