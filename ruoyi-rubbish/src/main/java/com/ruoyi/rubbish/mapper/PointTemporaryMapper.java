package com.ruoyi.rubbish.mapper;

import java.util.List;
import com.ruoyi.rubbish.domain.PointTemporary;

/**
 * 临时积分Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface PointTemporaryMapper 
{
    /**
     * 查询临时积分
     * 
     * @param id 临时积分主键
     * @return 临时积分
     */
    public PointTemporary selectPointTemporaryById(Long id);

    /**
     * 查询临时积分列表
     * 
     * @param pointTemporary 临时积分
     * @return 临时积分集合
     */
    public List<PointTemporary> selectPointTemporaryList(PointTemporary pointTemporary);

    /**
     * 新增临时积分
     * 
     * @param pointTemporary 临时积分
     * @return 结果
     */
    public int insertPointTemporary(PointTemporary pointTemporary);

    /**
     * 修改临时积分
     * 
     * @param pointTemporary 临时积分
     * @return 结果
     */
    public int updatePointTemporary(PointTemporary pointTemporary);

    /**
     * 删除临时积分
     * 
     * @param id 临时积分主键
     * @return 结果
     */
    public int deletePointTemporaryById(Long id);

    /**
     * 批量删除临时积分
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePointTemporaryByIds(Long[] ids);
}
