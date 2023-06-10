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
import com.ruoyi.rubbish.domain.PointRecordMain;
import com.ruoyi.rubbish.service.IPointRecordMainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分类目Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/PointRecordMain")
public class PointRecordMainController extends BaseController
{
    @Autowired
    private IPointRecordMainService pointRecordMainService;

    /**
     * 查询积分类目列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordMain:list')")
    @GetMapping("/list")
    public TableDataInfo list(PointRecordMain pointRecordMain)
    {
        startPage();
        List<PointRecordMain> list = pointRecordMainService.selectPointRecordMainList(pointRecordMain);
        return getDataTable(list);
    }

    /**
     * 导出积分类目列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordMain:export')")
    @Log(title = "积分类目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PointRecordMain pointRecordMain)
    {
        List<PointRecordMain> list = pointRecordMainService.selectPointRecordMainList(pointRecordMain);
        ExcelUtil<PointRecordMain> util = new ExcelUtil<PointRecordMain>(PointRecordMain.class);
        util.exportExcel(response, list, "积分类目数据");
    }

    /**
     * 获取积分类目详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordMain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") String id)
    {
        return success(pointRecordMainService.selectPointRecordMainById(id));
    }

    /**
     * 新增积分类目
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordMain:add')")
    @Log(title = "积分类目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PointRecordMain pointRecordMain)
    {
        return toAjax(pointRecordMainService.insertPointRecordMain(pointRecordMain));
    }

    /**
     * 修改积分类目
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordMain:edit')")
    @Log(title = "积分类目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PointRecordMain pointRecordMain)
    {
        return toAjax(pointRecordMainService.updatePointRecordMain(pointRecordMain));
    }

    /**
     * 删除积分类目
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordMain:remove')")
    @Log(title = "积分类目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        return toAjax(pointRecordMainService.deletePointRecordMainByIds(ids));
    }
}
