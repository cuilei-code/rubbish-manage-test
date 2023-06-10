package com.ruoyi.rubbish.mapper;

import java.util.List;
import com.ruoyi.rubbish.domain.PointMyTicket;

/**
 * 兑换券管理Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface PointMyTicketMapper 
{
    /**
     * 查询兑换券管理
     * 
     * @param id 兑换券管理主键
     * @return 兑换券管理
     */
    public PointMyTicket selectPointMyTicketById(Long id);

    /**
     * 查询兑换券管理列表
     * 
     * @param pointMyTicket 兑换券管理
     * @return 兑换券管理集合
     */
    public List<PointMyTicket> selectPointMyTicketList(PointMyTicket pointMyTicket);

    /**
     * 新增兑换券管理
     * 
     * @param pointMyTicket 兑换券管理
     * @return 结果
     */
    public int insertPointMyTicket(PointMyTicket pointMyTicket);

    /**
     * 修改兑换券管理
     * 
     * @param pointMyTicket 兑换券管理
     * @return 结果
     */
    public int updatePointMyTicket(PointMyTicket pointMyTicket);

    /**
     * 删除兑换券管理
     * 
     * @param id 兑换券管理主键
     * @return 结果
     */
    public int deletePointMyTicketById(Long id);

    /**
     * 批量删除兑换券管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePointMyTicketByIds(Long[] ids);
}
