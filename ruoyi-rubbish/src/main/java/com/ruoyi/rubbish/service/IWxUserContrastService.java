package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.WxUserContrast;

/**
 * 新人拉新记录Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IWxUserContrastService 
{
    /**
     * 查询新人拉新记录
     * 
     * @param id 新人拉新记录主键
     * @return 新人拉新记录
     */
    public WxUserContrast selectWxUserContrastById(Long id);

    /**
     * 查询新人拉新记录列表
     * 
     * @param wxUserContrast 新人拉新记录
     * @return 新人拉新记录集合
     */
    public List<WxUserContrast> selectWxUserContrastList(WxUserContrast wxUserContrast);

    /**
     * 新增新人拉新记录
     * 
     * @param wxUserContrast 新人拉新记录
     * @return 结果
     */
    public int insertWxUserContrast(WxUserContrast wxUserContrast);

    /**
     * 修改新人拉新记录
     * 
     * @param wxUserContrast 新人拉新记录
     * @return 结果
     */
    public int updateWxUserContrast(WxUserContrast wxUserContrast);

    /**
     * 批量删除新人拉新记录
     * 
     * @param ids 需要删除的新人拉新记录主键集合
     * @return 结果
     */
    public int deleteWxUserContrastByIds(Long[] ids);

    /**
     * 删除新人拉新记录信息
     * 
     * @param id 新人拉新记录主键
     * @return 结果
     */
    public int deleteWxUserContrastById(Long id);
}
