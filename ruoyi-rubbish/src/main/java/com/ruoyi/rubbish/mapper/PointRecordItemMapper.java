package com.ruoyi.rubbish.mapper;

import java.util.List;
import com.ruoyi.rubbish.domain.PointRecordItem;

/**
 * 积分类目明细Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface PointRecordItemMapper 
{
    /**
     * 查询积分类目明细
     * 
     * @param id 积分类目明细主键
     * @return 积分类目明细
     */
    public PointRecordItem selectPointRecordItemById(Long id);

    /**
     * 查询积分类目明细列表
     * 
     * @param pointRecordItem 积分类目明细
     * @return 积分类目明细集合
     */
    public List<PointRecordItem> selectPointRecordItemList(PointRecordItem pointRecordItem);

    /**
     * 新增积分类目明细
     * 
     * @param pointRecordItem 积分类目明细
     * @return 结果
     */
    public int insertPointRecordItem(PointRecordItem pointRecordItem);

    /**
     * 修改积分类目明细
     * 
     * @param pointRecordItem 积分类目明细
     * @return 结果
     */
    public int updatePointRecordItem(PointRecordItem pointRecordItem);

    /**
     * 删除积分类目明细
     * 
     * @param id 积分类目明细主键
     * @return 结果
     */
    public int deletePointRecordItemById(Long id);

    /**
     * 批量删除积分类目明细
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePointRecordItemByIds(Long[] ids);
}
