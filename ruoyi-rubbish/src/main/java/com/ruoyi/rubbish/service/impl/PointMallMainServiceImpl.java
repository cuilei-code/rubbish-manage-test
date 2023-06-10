package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.PointMallMainMapper;
import com.ruoyi.rubbish.domain.PointMallMain;
import com.ruoyi.rubbish.service.IPointMallMainService;

/**
 * 积分商城管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class PointMallMainServiceImpl implements IPointMallMainService 
{
    @Autowired
    private PointMallMainMapper pointMallMainMapper;

    /**
     * 查询积分商城管理
     * 
     * @param id 积分商城管理主键
     * @return 积分商城管理
     */
    @Override
    public PointMallMain selectPointMallMainById(Long id)
    {
        return pointMallMainMapper.selectPointMallMainById(id);
    }

    /**
     * 查询积分商城管理列表
     * 
     * @param pointMallMain 积分商城管理
     * @return 积分商城管理
     */
    @Override
    public List<PointMallMain> selectPointMallMainList(PointMallMain pointMallMain)
    {
        return pointMallMainMapper.selectPointMallMainList(pointMallMain);
    }

    /**
     * 新增积分商城管理
     * 
     * @param pointMallMain 积分商城管理
     * @return 结果
     */
    @Override
    public int insertPointMallMain(PointMallMain pointMallMain)
    {
        pointMallMain.setCreateTime(DateUtils.getNowDate());
        return pointMallMainMapper.insertPointMallMain(pointMallMain);
    }

    /**
     * 修改积分商城管理
     * 
     * @param pointMallMain 积分商城管理
     * @return 结果
     */
    @Override
    public int updatePointMallMain(PointMallMain pointMallMain)
    {
        pointMallMain.setUpdateTime(DateUtils.getNowDate());
        return pointMallMainMapper.updatePointMallMain(pointMallMain);
    }

    /**
     * 批量删除积分商城管理
     * 
     * @param ids 需要删除的积分商城管理主键
     * @return 结果
     */
    @Override
    public int deletePointMallMainByIds(Long[] ids)
    {
        return pointMallMainMapper.deletePointMallMainByIds(ids);
    }

    /**
     * 删除积分商城管理信息
     * 
     * @param id 积分商城管理主键
     * @return 结果
     */
    @Override
    public int deletePointMallMainById(Long id)
    {
        return pointMallMainMapper.deletePointMallMainById(id);
    }
}
