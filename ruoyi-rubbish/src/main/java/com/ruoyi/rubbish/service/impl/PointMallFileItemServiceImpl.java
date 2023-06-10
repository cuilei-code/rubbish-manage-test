package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.PointMallFileItemMapper;
import com.ruoyi.rubbish.domain.PointMallFileItem;
import com.ruoyi.rubbish.service.IPointMallFileItemService;

/**
 * 积分商城文件Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class PointMallFileItemServiceImpl implements IPointMallFileItemService 
{
    @Autowired
    private PointMallFileItemMapper pointMallFileItemMapper;

    /**
     * 查询积分商城文件
     * 
     * @param id 积分商城文件主键
     * @return 积分商城文件
     */
    @Override
    public PointMallFileItem selectPointMallFileItemById(Long id)
    {
        return pointMallFileItemMapper.selectPointMallFileItemById(id);
    }

    /**
     * 查询积分商城文件列表
     * 
     * @param pointMallFileItem 积分商城文件
     * @return 积分商城文件
     */
    @Override
    public List<PointMallFileItem> selectPointMallFileItemList(PointMallFileItem pointMallFileItem)
    {
        return pointMallFileItemMapper.selectPointMallFileItemList(pointMallFileItem);
    }

    /**
     * 新增积分商城文件
     * 
     * @param pointMallFileItem 积分商城文件
     * @return 结果
     */
    @Override
    public int insertPointMallFileItem(PointMallFileItem pointMallFileItem)
    {
        pointMallFileItem.setCreateTime(DateUtils.getNowDate());
        return pointMallFileItemMapper.insertPointMallFileItem(pointMallFileItem);
    }

    /**
     * 修改积分商城文件
     * 
     * @param pointMallFileItem 积分商城文件
     * @return 结果
     */
    @Override
    public int updatePointMallFileItem(PointMallFileItem pointMallFileItem)
    {
        pointMallFileItem.setUpdateTime(DateUtils.getNowDate());
        return pointMallFileItemMapper.updatePointMallFileItem(pointMallFileItem);
    }

    /**
     * 批量删除积分商城文件
     * 
     * @param ids 需要删除的积分商城文件主键
     * @return 结果
     */
    @Override
    public int deletePointMallFileItemByIds(Long[] ids)
    {
        return pointMallFileItemMapper.deletePointMallFileItemByIds(ids);
    }

    /**
     * 删除积分商城文件信息
     * 
     * @param id 积分商城文件主键
     * @return 结果
     */
    @Override
    public int deletePointMallFileItemById(Long id)
    {
        return pointMallFileItemMapper.deletePointMallFileItemById(id);
    }
}
