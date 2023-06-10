package com.ruoyi.rubbish.service;

import java.util.List;
import com.ruoyi.rubbish.domain.WithdrawalRecordMain;

/**
 * 提现记录Service接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface IWithdrawalRecordMainService 
{
    /**
     * 查询提现记录
     * 
     * @param id 提现记录主键
     * @return 提现记录
     */
    public WithdrawalRecordMain selectWithdrawalRecordMainById(Long id);

    /**
     * 查询提现记录列表
     * 
     * @param withdrawalRecordMain 提现记录
     * @return 提现记录集合
     */
    public List<WithdrawalRecordMain> selectWithdrawalRecordMainList(WithdrawalRecordMain withdrawalRecordMain);

    /**
     * 新增提现记录
     * 
     * @param withdrawalRecordMain 提现记录
     * @return 结果
     */
    public int insertWithdrawalRecordMain(WithdrawalRecordMain withdrawalRecordMain);

    /**
     * 修改提现记录
     * 
     * @param withdrawalRecordMain 提现记录
     * @return 结果
     */
    public int updateWithdrawalRecordMain(WithdrawalRecordMain withdrawalRecordMain);

    /**
     * 批量删除提现记录
     * 
     * @param ids 需要删除的提现记录主键集合
     * @return 结果
     */
    public int deleteWithdrawalRecordMainByIds(Long[] ids);

    /**
     * 删除提现记录信息
     * 
     * @param id 提现记录主键
     * @return 结果
     */
    public int deleteWithdrawalRecordMainById(Long id);
}
