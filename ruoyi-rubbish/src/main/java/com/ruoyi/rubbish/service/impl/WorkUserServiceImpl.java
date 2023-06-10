package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.WorkUserMapper;
import com.ruoyi.rubbish.domain.WorkUser;
import com.ruoyi.rubbish.service.IWorkUserService;

/**
 * 工作端用户信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class WorkUserServiceImpl implements IWorkUserService 
{
    @Autowired
    private WorkUserMapper workUserMapper;

    /**
     * 查询工作端用户信息
     * 
     * @param id 工作端用户信息主键
     * @return 工作端用户信息
     */
    @Override
    public WorkUser selectWorkUserById(Long id)
    {
        return workUserMapper.selectWorkUserById(id);
    }

    /**
     * 查询工作端用户信息列表
     * 
     * @param workUser 工作端用户信息
     * @return 工作端用户信息
     */
    @Override
    public List<WorkUser> selectWorkUserList(WorkUser workUser)
    {
        return workUserMapper.selectWorkUserList(workUser);
    }

    /**
     * 新增工作端用户信息
     * 
     * @param workUser 工作端用户信息
     * @return 结果
     */
    @Override
    public int insertWorkUser(WorkUser workUser)
    {
        workUser.setCreateTime(DateUtils.getNowDate());
        return workUserMapper.insertWorkUser(workUser);
    }

    /**
     * 修改工作端用户信息
     * 
     * @param workUser 工作端用户信息
     * @return 结果
     */
    @Override
    public int updateWorkUser(WorkUser workUser)
    {
        workUser.setUpdateTime(DateUtils.getNowDate());
        return workUserMapper.updateWorkUser(workUser);
    }

    /**
     * 批量删除工作端用户信息
     * 
     * @param ids 需要删除的工作端用户信息主键
     * @return 结果
     */
    @Override
    public int deleteWorkUserByIds(Long[] ids)
    {
        return workUserMapper.deleteWorkUserByIds(ids);
    }

    /**
     * 删除工作端用户信息信息
     * 
     * @param id 工作端用户信息主键
     * @return 结果
     */
    @Override
    public int deleteWorkUserById(Long id)
    {
        return workUserMapper.deleteWorkUserById(id);
    }
}
