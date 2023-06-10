package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.RubbishLocation;

/**
 * 地图区位Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IRubbishLocationService 
{
    /**
     * 查询地图区位
     * 
     * @param id 地图区位主键
     * @return 地图区位
     */
    public RubbishLocation selectRubbishLocationById(Long id);

    /**
     * 查询地图区位列表
     * 
     * @param rubbishLocation 地图区位
     * @return 地图区位集合
     */
    public List<RubbishLocation> selectRubbishLocationList(RubbishLocation rubbishLocation);

    /**
     * 新增地图区位
     * 
     * @param rubbishLocation 地图区位
     * @return 结果
     */
    public int insertRubbishLocation(RubbishLocation rubbishLocation);

    /**
     * 修改地图区位
     * 
     * @param rubbishLocation 地图区位
     * @return 结果
     */
    public int updateRubbishLocation(RubbishLocation rubbishLocation);

    /**
     * 批量删除地图区位
     * 
     * @param ids 需要删除的地图区位主键集合
     * @return 结果
     */
    public int deleteRubbishLocationByIds(Long[] ids);

    /**
     * 删除地图区位信息
     * 
     * @param id 地图区位主键
     * @return 结果
     */
    public int deleteRubbishLocationById(Long id);
}
