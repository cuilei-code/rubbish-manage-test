package com.ruoyi.rubbish.mapper;

import java.util.List;
import com.ruoyi.rubbish.domain.PointMallFileItem;

/**
 * 积分商城文件Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface PointMallFileItemMapper 
{
    /**
     * 查询积分商城文件
     * 
     * @param id 积分商城文件主键
     * @return 积分商城文件
     */
    public PointMallFileItem selectPointMallFileItemById(Long id);

    /**
     * 查询积分商城文件列表
     * 
     * @param pointMallFileItem 积分商城文件
     * @return 积分商城文件集合
     */
    public List<PointMallFileItem> selectPointMallFileItemList(PointMallFileItem pointMallFileItem);

    /**
     * 新增积分商城文件
     * 
     * @param pointMallFileItem 积分商城文件
     * @return 结果
     */
    public int insertPointMallFileItem(PointMallFileItem pointMallFileItem);

    /**
     * 修改积分商城文件
     * 
     * @param pointMallFileItem 积分商城文件
     * @return 结果
     */
    public int updatePointMallFileItem(PointMallFileItem pointMallFileItem);

    /**
     * 删除积分商城文件
     * 
     * @param id 积分商城文件主键
     * @return 结果
     */
    public int deletePointMallFileItemById(Long id);

    /**
     * 批量删除积分商城文件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePointMallFileItemByIds(Long[] ids);
}
