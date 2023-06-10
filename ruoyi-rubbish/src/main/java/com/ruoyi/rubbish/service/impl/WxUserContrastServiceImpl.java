package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.WxUserContrastMapper;
import com.ruoyi.rubbish.domain.WxUserContrast;
import com.ruoyi.rubbish.service.IWxUserContrastService;

/**
 * 新人拉新记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class WxUserContrastServiceImpl implements IWxUserContrastService 
{
    @Autowired
    private WxUserContrastMapper wxUserContrastMapper;

    /**
     * 查询新人拉新记录
     * 
     * @param id 新人拉新记录主键
     * @return 新人拉新记录
     */
    @Override
    public WxUserContrast selectWxUserContrastById(Long id)
    {
        return wxUserContrastMapper.selectWxUserContrastById(id);
    }

    /**
     * 查询新人拉新记录列表
     * 
     * @param wxUserContrast 新人拉新记录
     * @return 新人拉新记录
     */
    @Override
    public List<WxUserContrast> selectWxUserContrastList(WxUserContrast wxUserContrast)
    {
        return wxUserContrastMapper.selectWxUserContrastList(wxUserContrast);
    }

    /**
     * 新增新人拉新记录
     * 
     * @param wxUserContrast 新人拉新记录
     * @return 结果
     */
    @Override
    public int insertWxUserContrast(WxUserContrast wxUserContrast)
    {
        wxUserContrast.setCreateTime(DateUtils.getNowDate());
        return wxUserContrastMapper.insertWxUserContrast(wxUserContrast);
    }

    /**
     * 修改新人拉新记录
     * 
     * @param wxUserContrast 新人拉新记录
     * @return 结果
     */
    @Override
    public int updateWxUserContrast(WxUserContrast wxUserContrast)
    {
        wxUserContrast.setUpdateTime(DateUtils.getNowDate());
        return wxUserContrastMapper.updateWxUserContrast(wxUserContrast);
    }

    /**
     * 批量删除新人拉新记录
     * 
     * @param ids 需要删除的新人拉新记录主键
     * @return 结果
     */
    @Override
    public int deleteWxUserContrastByIds(Long[] ids)
    {
        return wxUserContrastMapper.deleteWxUserContrastByIds(ids);
    }

    /**
     * 删除新人拉新记录信息
     * 
     * @param id 新人拉新记录主键
     * @return 结果
     */
    @Override
    public int deleteWxUserContrastById(Long id)
    {
        return wxUserContrastMapper.deleteWxUserContrastById(id);
    }
}
