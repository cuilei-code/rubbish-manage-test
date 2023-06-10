package com.ruoyi.rubbish.mapper;

import java.util.List;
import com.ruoyi.rubbish.domain.PointRecordMain;
import com.ruoyi.rubbish.domain.PointRecordItem;

/**
 * 积分类目Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface PointRecordMainMapper 
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
     * 删除积分类目
     * 
     * @param id 积分类目主键
     * @return 结果
     */
    public int deletePointRecordMainById(Long id);

    /**
     * 批量删除积分类目
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePointRecordMainByIds(String[] ids);

    /**
     * 批量删除积分类目明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePointRecordItemByRecordMainIds(String[] ids);
    
    /**
     * 批量新增积分类目明细
     * 
     * @param pointRecordItemList 积分类目明细列表
     * @return 结果
     */
    public int batchPointRecordItem(List<PointRecordItem> pointRecordItemList);
    

    /**
     * 通过积分类目主键删除积分类目明细信息
     * 
     * @param id 积分类目ID
     * @return 结果
     */
    public int deletePointRecordItemByRecordMainId(Long id);
}
