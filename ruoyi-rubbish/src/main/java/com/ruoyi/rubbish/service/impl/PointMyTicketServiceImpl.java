package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.PointMyTicketMapper;
import com.ruoyi.rubbish.domain.PointMyTicket;
import com.ruoyi.rubbish.service.IPointMyTicketService;

/**
 * 兑换券管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class PointMyTicketServiceImpl implements IPointMyTicketService 
{
    @Autowired
    private PointMyTicketMapper pointMyTicketMapper;

    /**
     * 查询兑换券管理
     * 
     * @param id 兑换券管理主键
     * @return 兑换券管理
     */
    @Override
    public PointMyTicket selectPointMyTicketById(Long id)
    {
        return pointMyTicketMapper.selectPointMyTicketById(id);
    }

    /**
     * 查询兑换券管理列表
     * 
     * @param pointMyTicket 兑换券管理
     * @return 兑换券管理
     */
    @Override
    public List<PointMyTicket> selectPointMyTicketList(PointMyTicket pointMyTicket)
    {
        return pointMyTicketMapper.selectPointMyTicketList(pointMyTicket);
    }

    /**
     * 新增兑换券管理
     * 
     * @param pointMyTicket 兑换券管理
     * @return 结果
     */
    @Override
    public int insertPointMyTicket(PointMyTicket pointMyTicket)
    {
        pointMyTicket.setCreateTime(DateUtils.getNowDate());
        return pointMyTicketMapper.insertPointMyTicket(pointMyTicket);
    }

    /**
     * 修改兑换券管理
     * 
     * @param pointMyTicket 兑换券管理
     * @return 结果
     */
    @Override
    public int updatePointMyTicket(PointMyTicket pointMyTicket)
    {
        pointMyTicket.setUpdateTime(DateUtils.getNowDate());
        return pointMyTicketMapper.updatePointMyTicket(pointMyTicket);
    }

    /**
     * 批量删除兑换券管理
     * 
     * @param ids 需要删除的兑换券管理主键
     * @return 结果
     */
    @Override
    public int deletePointMyTicketByIds(Long[] ids)
    {
        return pointMyTicketMapper.deletePointMyTicketByIds(ids);
    }

    /**
     * 删除兑换券管理信息
     * 
     * @param id 兑换券管理主键
     * @return 结果
     */
    @Override
    public int deletePointMyTicketById(Long id)
    {
        return pointMyTicketMapper.deletePointMyTicketById(id);
    }
}
