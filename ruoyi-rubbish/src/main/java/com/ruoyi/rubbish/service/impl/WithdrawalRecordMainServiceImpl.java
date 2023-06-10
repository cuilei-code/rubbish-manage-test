package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.WithdrawalRecordMainMapper;
import com.ruoyi.rubbish.domain.WithdrawalRecordMain;
import com.ruoyi.rubbish.service.IWithdrawalRecordMainService;

/**
 * 提现记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class WithdrawalRecordMainServiceImpl implements IWithdrawalRecordMainService 
{
    @Autowired
    private WithdrawalRecordMainMapper withdrawalRecordMainMapper;

    /**
     * 查询提现记录
     * 
     * @param id 提现记录主键
     * @return 提现记录
     */
    @Override
    public WithdrawalRecordMain selectWithdrawalRecordMainById(Long id)
    {
        return withdrawalRecordMainMapper.selectWithdrawalRecordMainById(id);
    }

    /**
     * 查询提现记录列表
     * 
     * @param withdrawalRecordMain 提现记录
     * @return 提现记录
     */
    @Override
    public List<WithdrawalRecordMain> selectWithdrawalRecordMainList(WithdrawalRecordMain withdrawalRecordMain)
    {
        return withdrawalRecordMainMapper.selectWithdrawalRecordMainList(withdrawalRecordMain);
    }

    /**
     * 新增提现记录
     * 
     * @param withdrawalRecordMain 提现记录
     * @return 结果
     */
    @Override
    public int insertWithdrawalRecordMain(WithdrawalRecordMain withdrawalRecordMain)
    {
        withdrawalRecordMain.setCreateTime(DateUtils.getNowDate());
        return withdrawalRecordMainMapper.insertWithdrawalRecordMain(withdrawalRecordMain);
    }

    /**
     * 修改提现记录
     * 
     * @param withdrawalRecordMain 提现记录
     * @return 结果
     */
    @Override
    public int updateWithdrawalRecordMain(WithdrawalRecordMain withdrawalRecordMain)
    {
        withdrawalRecordMain.setUpdateTime(DateUtils.getNowDate());
        return withdrawalRecordMainMapper.updateWithdrawalRecordMain(withdrawalRecordMain);
    }

    /**
     * 批量删除提现记录
     * 
     * @param ids 需要删除的提现记录主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawalRecordMainByIds(Long[] ids)
    {
        return withdrawalRecordMainMapper.deleteWithdrawalRecordMainByIds(ids);
    }

    /**
     * 删除提现记录信息
     * 
     * @param id 提现记录主键
     * @return 结果
     */
    @Override
    public int deleteWithdrawalRecordMainById(Long id)
    {
        return withdrawalRecordMainMapper.deleteWithdrawalRecordMainById(id);
    }
}
