package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.rubbish.domain.PointRecordItem;
import com.ruoyi.rubbish.mapper.PointRecordMainMapper;
import com.ruoyi.rubbish.domain.PointRecordMain;
import com.ruoyi.rubbish.service.IPointRecordMainService;

/**
 * 积分类目Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class PointRecordMainServiceImpl implements IPointRecordMainService 
{
    @Autowired
    private PointRecordMainMapper pointRecordMainMapper;

    /**
     * 查询积分类目
     * 
     * @param id 积分类目主键
     * @return 积分类目
     */
    @Override
    public PointRecordMain selectPointRecordMainById(String id)
    {
        return pointRecordMainMapper.selectPointRecordMainById(id);
    }

    /**
     * 查询积分类目列表
     * 
     * @param pointRecordMain 积分类目
     * @return 积分类目
     */
    @Override
    public List<PointRecordMain> selectPointRecordMainList(PointRecordMain pointRecordMain)
    {
        return pointRecordMainMapper.selectPointRecordMainList(pointRecordMain);
    }

    /**
     * 新增积分类目
     * 
     * @param pointRecordMain 积分类目
     * @return 结果
     */
    @Transactional
    @Override
    public int insertPointRecordMain(PointRecordMain pointRecordMain)
    {
        pointRecordMain.setCreateTime(DateUtils.getNowDate());
        int rows = pointRecordMainMapper.insertPointRecordMain(pointRecordMain);
        insertPointRecordItem(pointRecordMain);
        return rows;
    }

    /**
     * 修改积分类目
     * 
     * @param pointRecordMain 积分类目
     * @return 结果
     */
    @Transactional
    @Override
    public int updatePointRecordMain(PointRecordMain pointRecordMain)
    {
        pointRecordMain.setUpdateTime(DateUtils.getNowDate());
        pointRecordMainMapper.deletePointRecordItemByRecordMainId(pointRecordMain.getId());
        insertPointRecordItem(pointRecordMain);
        return pointRecordMainMapper.updatePointRecordMain(pointRecordMain);
    }

    /**
     * 批量删除积分类目
     * 
     * @param ids 需要删除的积分类目主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePointRecordMainByIds(String[] ids)
    {
        pointRecordMainMapper.deletePointRecordItemByRecordMainIds(ids);
        return pointRecordMainMapper.deletePointRecordMainByIds(ids);
    }

    /**
     * 删除积分类目信息
     * 
     * @param id 积分类目主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deletePointRecordMainById(Long id)
    {
        pointRecordMainMapper.deletePointRecordItemByRecordMainId(id);
        return pointRecordMainMapper.deletePointRecordMainById(id);
    }

    /**
     * 新增积分类目明细信息
     * 
     * @param pointRecordMain 积分类目对象
     */
    public void insertPointRecordItem(PointRecordMain pointRecordMain)
    {
        List<PointRecordItem> pointRecordItemList = pointRecordMain.getPointRecordItemList();
        Long id = pointRecordMain.getId();
        if (StringUtils.isNotNull(pointRecordItemList))
        {
            List<PointRecordItem> list = new ArrayList<PointRecordItem>();
            for (PointRecordItem pointRecordItem : pointRecordItemList)
            {
                pointRecordItem.setRecordMainId(id);
                list.add(pointRecordItem);
            }
            if (list.size() > 0)
            {
                pointRecordMainMapper.batchPointRecordItem(list);
            }
        }
    }
}
