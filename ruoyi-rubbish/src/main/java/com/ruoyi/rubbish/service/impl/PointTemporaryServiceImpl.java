package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.PointTemporaryMapper;
import com.ruoyi.rubbish.domain.PointTemporary;
import com.ruoyi.rubbish.service.IPointTemporaryService;

/**
 * 临时积分Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class PointTemporaryServiceImpl implements IPointTemporaryService 
{
    @Autowired
    private PointTemporaryMapper pointTemporaryMapper;

    /**
     * 查询临时积分
     * 
     * @param id 临时积分主键
     * @return 临时积分
     */
    @Override
    public PointTemporary selectPointTemporaryById(Long id)
    {
        return pointTemporaryMapper.selectPointTemporaryById(id);
    }

    /**
     * 查询临时积分列表
     * 
     * @param pointTemporary 临时积分
     * @return 临时积分
     */
    @Override
    public List<PointTemporary> selectPointTemporaryList(PointTemporary pointTemporary)
    {
        return pointTemporaryMapper.selectPointTemporaryList(pointTemporary);
    }

    /**
     * 新增临时积分
     * 
     * @param pointTemporary 临时积分
     * @return 结果
     */
    @Override
    public int insertPointTemporary(PointTemporary pointTemporary)
    {
        pointTemporary.setCreateTime(DateUtils.getNowDate());
        return pointTemporaryMapper.insertPointTemporary(pointTemporary);
    }

    /**
     * 修改临时积分
     * 
     * @param pointTemporary 临时积分
     * @return 结果
     */
    @Override
    public int updatePointTemporary(PointTemporary pointTemporary)
    {
        pointTemporary.setUpdateTime(DateUtils.getNowDate());
        return pointTemporaryMapper.updatePointTemporary(pointTemporary);
    }

    /**
     * 批量删除临时积分
     * 
     * @param ids 需要删除的临时积分主键
     * @return 结果
     */
    @Override
    public int deletePointTemporaryByIds(Long[] ids)
    {
        return pointTemporaryMapper.deletePointTemporaryByIds(ids);
    }

    /**
     * 删除临时积分信息
     * 
     * @param id 临时积分主键
     * @return 结果
     */
    @Override
    public int deletePointTemporaryById(Long id)
    {
        return pointTemporaryMapper.deletePointTemporaryById(id);
    }
}
