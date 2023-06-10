package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.RubbishLocationMapper;
import com.ruoyi.rubbish.domain.RubbishLocation;
import com.ruoyi.rubbish.service.IRubbishLocationService;

/**
 * 地图区位Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class RubbishLocationServiceImpl implements IRubbishLocationService 
{
    @Autowired
    private RubbishLocationMapper rubbishLocationMapper;

    /**
     * 查询地图区位
     * 
     * @param id 地图区位主键
     * @return 地图区位
     */
    @Override
    public RubbishLocation selectRubbishLocationById(Long id)
    {
        return rubbishLocationMapper.selectRubbishLocationById(id);
    }

    /**
     * 查询地图区位列表
     * 
     * @param rubbishLocation 地图区位
     * @return 地图区位
     */
    @Override
    public List<RubbishLocation> selectRubbishLocationList(RubbishLocation rubbishLocation)
    {
        return rubbishLocationMapper.selectRubbishLocationList(rubbishLocation);
    }

    /**
     * 新增地图区位
     * 
     * @param rubbishLocation 地图区位
     * @return 结果
     */
    @Override
    public int insertRubbishLocation(RubbishLocation rubbishLocation)
    {
        rubbishLocation.setCreateTime(DateUtils.getNowDate());
        return rubbishLocationMapper.insertRubbishLocation(rubbishLocation);
    }

    /**
     * 修改地图区位
     * 
     * @param rubbishLocation 地图区位
     * @return 结果
     */
    @Override
    public int updateRubbishLocation(RubbishLocation rubbishLocation)
    {
        rubbishLocation.setUpdateTime(DateUtils.getNowDate());
        return rubbishLocationMapper.updateRubbishLocation(rubbishLocation);
    }

    /**
     * 批量删除地图区位
     * 
     * @param ids 需要删除的地图区位主键
     * @return 结果
     */
    @Override
    public int deleteRubbishLocationByIds(Long[] ids)
    {
        return rubbishLocationMapper.deleteRubbishLocationByIds(ids);
    }

    /**
     * 删除地图区位信息
     * 
     * @param id 地图区位主键
     * @return 结果
     */
    @Override
    public int deleteRubbishLocationById(Long id)
    {
        return rubbishLocationMapper.deleteRubbishLocationById(id);
    }
}
