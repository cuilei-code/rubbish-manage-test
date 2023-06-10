package com.ruoyi.rubbish.mapper;

import java.util.List;
import com.ruoyi.rubbish.domain.ProductTypeMain;

/**
 * 商品分类Mapper接口
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
public interface ProductTypeMainMapper 
{
    /**
     * 查询商品分类
     * 
     * @param id 商品分类主键
     * @return 商品分类
     */
    public ProductTypeMain selectProductTypeMainById(Long id);

    /**
     * 查询商品分类列表
     * 
     * @param productTypeMain 商品分类
     * @return 商品分类集合
     */
    public List<ProductTypeMain> selectProductTypeMainList(ProductTypeMain productTypeMain);

    /**
     * 新增商品分类
     * 
     * @param productTypeMain 商品分类
     * @return 结果
     */
    public int insertProductTypeMain(ProductTypeMain productTypeMain);

    /**
     * 修改商品分类
     * 
     * @param productTypeMain 商品分类
     * @return 结果
     */
    public int updateProductTypeMain(ProductTypeMain productTypeMain);

    /**
     * 删除商品分类
     * 
     * @param id 商品分类主键
     * @return 结果
     */
    public int deleteProductTypeMainById(Long id);

    /**
     * 批量删除商品分类
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteProductTypeMainByIds(Long[] ids);
}
