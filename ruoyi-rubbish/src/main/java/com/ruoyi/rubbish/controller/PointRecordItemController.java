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
import com.ruoyi.rubbish.domain.PointRecordItem;
import com.ruoyi.rubbish.service.IPointRecordItemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分类目明细Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/PointRecordItem")
public class PointRecordItemController extends BaseController
{
    @Autowired
    private IPointRecordItemService pointRecordItemService;

    /**
     * 查询积分类目明细列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordItem:list')")
    @GetMapping("/list")
    public TableDataInfo list(PointRecordItem pointRecordItem)
    {
        startPage();
        List<PointRecordItem> list = pointRecordItemService.selectPointRecordItemList(pointRecordItem);
        return getDataTable(list);
    }

    /**
     * 导出积分类目明细列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordItem:export')")
    @Log(title = "积分类目明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PointRecordItem pointRecordItem)
    {
        List<PointRecordItem> list = pointRecordItemService.selectPointRecordItemList(pointRecordItem);
        ExcelUtil<PointRecordItem> util = new ExcelUtil<PointRecordItem>(PointRecordItem.class);
        util.exportExcel(response, list, "积分类目明细数据");
    }

    /**
     * 获取积分类目明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordItem:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pointRecordItemService.selectPointRecordItemById(id));
    }

    /**
     * 新增积分类目明细
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordItem:add')")
    @Log(title = "积分类目明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PointRecordItem pointRecordItem)
    {
        return toAjax(pointRecordItemService.insertPointRecordItem(pointRecordItem));
    }

    /**
     * 修改积分类目明细
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordItem:edit')")
    @Log(title = "积分类目明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PointRecordItem pointRecordItem)
    {
        return toAjax(pointRecordItemService.updatePointRecordItem(pointRecordItem));
    }

    /**
     * 删除积分类目明细
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointRecordItem:remove')")
    @Log(title = "积分类目明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pointRecordItemService.deletePointRecordItemByIds(ids));
    }
}
