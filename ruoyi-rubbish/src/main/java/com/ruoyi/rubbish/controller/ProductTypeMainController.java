package com.ruoyi.rubbish.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.rubbish.domain.ProductTypeMain;
import com.ruoyi.rubbish.service.IProductTypeMainService;
import com.ruoyi.common.utils.poi.ExcelUtil;

/**
 * 商品分类Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/ProductType")
public class ProductTypeMainController extends BaseController
{
    @Autowired
    private IProductTypeMainService productTypeMainService;

    /**
     * 查询商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:ProductType:list')")
    @GetMapping("/list")
    public AjaxResult list(ProductTypeMain productTypeMain)
    {
        List<ProductTypeMain> list = productTypeMainService.selectProductTypeMainList(productTypeMain);
        return success(list);
    }

    /**
     * 导出商品分类列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:ProductType:export')")
    @Log(title = "商品分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ProductTypeMain productTypeMain)
    {
        List<ProductTypeMain> list = productTypeMainService.selectProductTypeMainList(productTypeMain);
        ExcelUtil<ProductTypeMain> util = new ExcelUtil<ProductTypeMain>(ProductTypeMain.class);
        util.exportExcel(response, list, "商品分类数据");
    }

    /**
     * 获取商品分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:ProductType:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(productTypeMainService.selectProductTypeMainById(id));
    }

    /**
     * 新增商品分类
     */
    @PreAuthorize("@ss.hasPermi('rubbish:ProductType:add')")
    @Log(title = "商品分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ProductTypeMain productTypeMain)
    {
        return toAjax(productTypeMainService.insertProductTypeMain(productTypeMain));
    }

    /**
     * 修改商品分类
     */
    @PreAuthorize("@ss.hasPermi('rubbish:ProductType:edit')")
    @Log(title = "商品分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ProductTypeMain productTypeMain)
    {
        return toAjax(productTypeMainService.updateProductTypeMain(productTypeMain));
    }

    /**
     * 删除商品分类
     */
    @PreAuthorize("@ss.hasPermi('rubbish:ProductType:remove')")
    @Log(title = "商品分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(productTypeMainService.deleteProductTypeMainByIds(ids));
    }
}
