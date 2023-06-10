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
import com.ruoyi.rubbish.domain.WxUserContrast;
import com.ruoyi.rubbish.service.IWxUserContrastService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新人拉新记录Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/UserContrast")
public class WxUserContrastController extends BaseController
{
    @Autowired
    private IWxUserContrastService wxUserContrastService;

    /**
     * 查询新人拉新记录列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:UserContrast:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxUserContrast wxUserContrast)
    {
        startPage();
        List<WxUserContrast> list = wxUserContrastService.selectWxUserContrastList(wxUserContrast);
        return getDataTable(list);
    }

    /**
     * 导出新人拉新记录列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:UserContrast:export')")
    @Log(title = "新人拉新记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WxUserContrast wxUserContrast)
    {
        List<WxUserContrast> list = wxUserContrastService.selectWxUserContrastList(wxUserContrast);
        ExcelUtil<WxUserContrast> util = new ExcelUtil<WxUserContrast>(WxUserContrast.class);
        util.exportExcel(response, list, "新人拉新记录数据");
    }

    /**
     * 获取新人拉新记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:UserContrast:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wxUserContrastService.selectWxUserContrastById(id));
    }

    /**
     * 新增新人拉新记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:UserContrast:add')")
    @Log(title = "新人拉新记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxUserContrast wxUserContrast)
    {
        return toAjax(wxUserContrastService.insertWxUserContrast(wxUserContrast));
    }

    /**
     * 修改新人拉新记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:UserContrast:edit')")
    @Log(title = "新人拉新记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxUserContrast wxUserContrast)
    {
        return toAjax(wxUserContrastService.updateWxUserContrast(wxUserContrast));
    }

    /**
     * 删除新人拉新记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:UserContrast:remove')")
    @Log(title = "新人拉新记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxUserContrastService.deleteWxUserContrastByIds(ids));
    }
}
