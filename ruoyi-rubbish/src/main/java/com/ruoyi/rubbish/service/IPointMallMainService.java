package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.PointMallMain;

/**
 * 积分商城管理Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IPointMallMainService 
{
    /**
     * 查询积分商城管理
     * 
     * @param id 积分商城管理主键
     * @return 积分商城管理
     */
    public PointMallMain selectPointMallMainById(Long id);

    /**
     * 查询积分商城管理列表
     * 
     * @param pointMallMain 积分商城管理
     * @return 积分商城管理集合
     */
    public List<PointMallMain> selectPointMallMainList(PointMallMain pointMallMain);

    /**
     * 新增积分商城管理
     * 
     * @param pointMallMain 积分商城管理
     * @return 结果
     */
    public int insertPointMallMain(PointMallMain pointMallMain);

    /**
     * 修改积分商城管理
     * 
     * @param pointMallMain 积分商城管理
     * @return 结果
     */
    public int updatePointMallMain(PointMallMain pointMallMain);

    /**
     * 批量删除积分商城管理
     * 
     * @param ids 需要删除的积分商城管理主键集合
     * @return 结果
     */
    public int deletePointMallMainByIds(Long[] ids);

    /**
     * 删除积分商城管理信息
     * 
     * @param id 积分商城管理主键
     * @return 结果
     */
    public int deletePointMallMainById(Long id);
}
