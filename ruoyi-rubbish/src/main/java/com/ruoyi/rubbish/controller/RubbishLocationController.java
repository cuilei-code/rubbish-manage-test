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
import com.ruoyi.rubbish.domain.RubbishLocation;
import com.ruoyi.rubbish.service.IRubbishLocationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 地图区位Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/location")
public class RubbishLocationController extends BaseController
{
    @Autowired
    private IRubbishLocationService rubbishLocationService;

    /**
     * 查询地图区位列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:location:list')")
    @GetMapping("/list")
    public TableDataInfo list(RubbishLocation rubbishLocation)
    {
        startPage();
        List<RubbishLocation> list = rubbishLocationService.selectRubbishLocationList(rubbishLocation);
        return getDataTable(list);
    }

    /**
     * 导出地图区位列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:location:export')")
    @Log(title = "地图区位", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RubbishLocation rubbishLocation)
    {
        List<RubbishLocation> list = rubbishLocationService.selectRubbishLocationList(rubbishLocation);
        ExcelUtil<RubbishLocation> util = new ExcelUtil<RubbishLocation>(RubbishLocation.class);
        util.exportExcel(response, list, "地图区位数据");
    }

    /**
     * 获取地图区位详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:location:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(rubbishLocationService.selectRubbishLocationById(id));
    }

    /**
     * 新增地图区位
     */
    @PreAuthorize("@ss.hasPermi('rubbish:location:add')")
    @Log(title = "地图区位", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RubbishLocation rubbishLocation)
    {
        return toAjax(rubbishLocationService.insertRubbishLocation(rubbishLocation));
    }

    /**
     * 修改地图区位
     */
    @PreAuthorize("@ss.hasPermi('rubbish:location:edit')")
    @Log(title = "地图区位", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RubbishLocation rubbishLocation)
    {
        return toAjax(rubbishLocationService.updateRubbishLocation(rubbishLocation));
    }

    /**
     * 删除地图区位
     */
    @PreAuthorize("@ss.hasPermi('rubbish:location:remove')")
    @Log(title = "地图区位", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(rubbishLocationService.deleteRubbishLocationByIds(ids));
    }
}
