package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.WorkUser;

/**
 * 工作端用户信息Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IWorkUserService 
{
    /**
     * 查询工作端用户信息
     * 
     * @param id 工作端用户信息主键
     * @return 工作端用户信息
     */
    public WorkUser selectWorkUserById(Long id);

    /**
     * 查询工作端用户信息列表
     * 
     * @param workUser 工作端用户信息
     * @return 工作端用户信息集合
     */
    public List<WorkUser> selectWorkUserList(WorkUser workUser);

    /**
     * 新增工作端用户信息
     * 
     * @param workUser 工作端用户信息
     * @return 结果
     */
    public int insertWorkUser(WorkUser workUser);

    /**
     * 修改工作端用户信息
     * 
     * @param workUser 工作端用户信息
     * @return 结果
     */
    public int updateWorkUser(WorkUser workUser);

    /**
     * 批量删除工作端用户信息
     * 
     * @param ids 需要删除的工作端用户信息主键集合
     * @return 结果
     */
    public int deleteWorkUserByIds(Long[] ids);

    /**
     * 删除工作端用户信息信息
     * 
     * @param id 工作端用户信息主键
     * @return 结果
     */
    public int deleteWorkUserById(Long id);
}
