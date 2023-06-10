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
import com.ruoyi.rubbish.domain.PointMallMain;
import com.ruoyi.rubbish.service.IPointMallMainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分商城管理Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/MallMain")
public class PointMallMainController extends BaseController
{
    @Autowired
    private IPointMallMainService pointMallMainService;

    /**
     * 查询积分商城管理列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallMain:list')")
    @GetMapping("/list")
    public TableDataInfo list(PointMallMain pointMallMain)
    {
        startPage();
        List<PointMallMain> list = pointMallMainService.selectPointMallMainList(pointMallMain);
        return getDataTable(list);
    }

    /**
     * 导出积分商城管理列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallMain:export')")
    @Log(title = "积分商城管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PointMallMain pointMallMain)
    {
        List<PointMallMain> list = pointMallMainService.selectPointMallMainList(pointMallMain);
        ExcelUtil<PointMallMain> util = new ExcelUtil<PointMallMain>(PointMallMain.class);
        util.exportExcel(response, list, "积分商城管理数据");
    }

    /**
     * 获取积分商城管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallMain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pointMallMainService.selectPointMallMainById(id));
    }

    /**
     * 新增积分商城管理
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallMain:add')")
    @Log(title = "积分商城管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PointMallMain pointMallMain)
    {
        return toAjax(pointMallMainService.insertPointMallMain(pointMallMain));
    }

    /**
     * 修改积分商城管理
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallMain:edit')")
    @Log(title = "积分商城管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PointMallMain pointMallMain)
    {
        return toAjax(pointMallMainService.updatePointMallMain(pointMallMain));
    }

    /**
     * 删除积分商城管理
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallMain:remove')")
    @Log(title = "积分商城管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pointMallMainService.deletePointMallMainByIds(ids));
    }
}
