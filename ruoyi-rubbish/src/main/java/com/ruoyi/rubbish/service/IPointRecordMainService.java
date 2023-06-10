package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.PointRecordMain;

/**
 * 积分类目Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IPointRecordMainService 
{
    /**
     * 查询积分类目
     * 
     * @param id 积分类目主键
     * @return 积分类目
     */
    public PointRecordMain selectPointRecordMainById(String id);

    /**
     * 查询积分类目列表
     * 
     * @param pointRecordMain 积分类目
     * @return 积分类目集合
     */
    public List<PointRecordMain> selectPointRecordMainList(PointRecordMain pointRecordMain);

    /**
     * 新增积分类目
     * 
     * @param pointRecordMain 积分类目
     * @return 结果
     */
    public int insertPointRecordMain(PointRecordMain pointRecordMain);

    /**
     * 修改积分类目
     * 
     * @param pointRecordMain 积分类目
     * @return 结果
     */
    public int updatePointRecordMain(PointRecordMain pointRecordMain);

    /**
     * 批量删除积分类目
     * 
     * @param ids 需要删除的积分类目主键集合
     * @return 结果
     */
    public int deletePointRecordMainByIds(String[] ids);

    /**
     * 删除积分类目信息
     * 
     * @param id 积分类目主键
     * @return 结果
     */
    public int deletePointRecordMainById(Long id);
}
