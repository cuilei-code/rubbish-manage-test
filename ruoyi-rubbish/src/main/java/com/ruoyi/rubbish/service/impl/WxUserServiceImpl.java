package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.WxUserMapper;
import com.ruoyi.rubbish.domain.WxUser;
import com.ruoyi.rubbish.service.IWxUserService;

/**
 * 客户端普通用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class WxUserServiceImpl implements IWxUserService 
{
    @Autowired
    private WxUserMapper wxUserMapper;

    /**
     * 查询客户端普通用户
     * 
     * @param id 客户端普通用户主键
     * @return 客户端普通用户
     */
    @Override
    public WxUser selectWxUserById(Long id)
    {
        return wxUserMapper.selectWxUserById(id);
    }

    /**
     * 查询客户端普通用户列表
     * 
     * @param wxUser 客户端普通用户
     * @return 客户端普通用户
     */
    @Override
    public List<WxUser> selectWxUserList(WxUser wxUser)
    {
        return wxUserMapper.selectWxUserList(wxUser);
    }

    @Override
    public WxUser selectWxUserByOpenId(String openId) {
        return wxUserMapper.selectWxUserByOpenId(openId);
    }

    /**
     * 新增客户端普通用户
     * 
     * @param wxUser 客户端普通用户
     * @return 结果
     */
    @Override
    public int insertWxUser(WxUser wxUser)
    {
        wxUser.setCreateTime(DateUtils.getNowDate());
        return wxUserMapper.insertWxUser(wxUser);
    }

    /**
     * 修改客户端普通用户
     * 
     * @param wxUser 客户端普通用户
     * @return 结果
     */
    @Override
    public int updateWxUser(WxUser wxUser)
    {
        wxUser.setUpdateTime(DateUtils.getNowDate());
        return wxUserMapper.updateWxUser(wxUser);
    }

    /**
     * 批量删除客户端普通用户
     * 
     * @param ids 需要删除的客户端普通用户主键
     * @return 结果
     */
    @Override
    public int deleteWxUserByIds(Long[] ids)
    {
        return wxUserMapper.deleteWxUserByIds(ids);
    }

    /**
     * 删除客户端普通用户信息
     * 
     * @param id 客户端普通用户主键
     * @return 结果
     */
    @Override
    public int deleteWxUserById(Long id)
    {
        return wxUserMapper.deleteWxUserById(id);
    }
}
