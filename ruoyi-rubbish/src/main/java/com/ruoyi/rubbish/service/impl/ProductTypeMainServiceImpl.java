package com.ruoyi.rubbish.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.rubbish.mapper.ProductTypeMainMapper;
import com.ruoyi.rubbish.domain.ProductTypeMain;
import com.ruoyi.rubbish.service.IProductTypeMainService;

/**
 * 商品分类Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@Service
public class ProductTypeMainServiceImpl implements IProductTypeMainService 
{
    @Autowired
    private ProductTypeMainMapper productTypeMainMapper;

    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    @Override
    public ProductTypeMain selectProductTypeMainById(Long id)
    {
        return productTypeMainMapper.selectProductTypeMainById(id);
    }

    /**
     * 查询商品分类列表
     * 
     * @param productTypeMain 商品分类
     * @return 商品分类
     */
    @Override
    public List<ProductTypeMain> selectProductTypeMainList(ProductTypeMain productTypeMain)
    {
        return productTypeMainMapper.selectProductTypeMainList(productTypeMain);
    }

    /**
     * 新增商品分类
     * 
     * @param productTypeMain 商品分类
     * @return 结果
     */
    @Override
    public int insertProductTypeMain(ProductTypeMain productTypeMain)
    {
        productTypeMain.setCreateTime(DateUtils.getNowDate());
        return productTypeMainMapper.insertProductTypeMain(productTypeMain);
    }

    /**
     * 修改商品分类
     * 
     * @param productTypeMain 商品分类
     * @return 结果
     */
    @Override
    public int updateProductTypeMain(ProductTypeMain productTypeMain)
    {
        productTypeMain.setUpdateTime(DateUtils.getNowDate());
        return productTypeMainMapper.updateProductTypeMain(productTypeMain);
    }

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的商品分类主键
     * @return 结果
     */
    @Override
    public int deleteProductTypeMainByIds(Long[] ids)
    {
        return productTypeMainMapper.deleteProductTypeMainByIds(ids);
    }

    /**
     * 删除商品分类信息
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    @Override
    public int deleteProductTypeMainById(Long id)
    {
        return productTypeMainMapper.deleteProductTypeMainById(id);
    }
}
