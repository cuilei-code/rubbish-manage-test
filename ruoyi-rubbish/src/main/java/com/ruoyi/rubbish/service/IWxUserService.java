package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.WxUser;

/**
 * 客户端普通用户Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IWxUserService 
{
    /**
     * 查询客户端普通用户
     * 
     * @param id 客户端普通用户主键
     * @return 客户端普通用户
     */
    public WxUser selectWxUserById(Long id);

    /**
     * 查询客户端普通用户列表
     * 
     * @param wxUser 客户端普通用户
     * @return 客户端普通用户集合
     */
    public List<WxUser> selectWxUserList(WxUser wxUser);

    /**
     * 新增客户端普通用户
     * 
     * @param wxUser 客户端普通用户
     * @return 结果
     */
    public int insertWxUser(WxUser wxUser);

    /**
     * 修改客户端普通用户
     * 
     * @param wxUser 客户端普通用户
     * @return 结果
     */
    public int updateWxUser(WxUser wxUser);

    /**
     * 批量删除客户端普通用户
     * 
     * @param ids 需要删除的客户端普通用户主键集合
     * @return 结果
     */
    public int deleteWxUserByIds(Long[] ids);

    /**
     * 删除客户端普通用户信息
     * 
     * @param id 客户端普通用户主键
     * @return 结果
     */
    public int deleteWxUserById(Long id);
}
