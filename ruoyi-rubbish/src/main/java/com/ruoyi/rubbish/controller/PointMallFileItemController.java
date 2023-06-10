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
import com.ruoyi.rubbish.domain.PointMallFileItem;
import com.ruoyi.rubbish.service.IPointMallFileItemService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分商城文件Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/MallFileItem")
public class PointMallFileItemController extends BaseController
{
    @Autowired
    private IPointMallFileItemService pointMallFileItemService;

    /**
     * 查询积分商城文件列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallFileItem:list')")
    @GetMapping("/list")
    public TableDataInfo list(PointMallFileItem pointMallFileItem)
    {
        startPage();
        List<PointMallFileItem> list = pointMallFileItemService.selectPointMallFileItemList(pointMallFileItem);
        return getDataTable(list);
    }

    /**
     * 导出积分商城文件列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallFileItem:export')")
    @Log(title = "积分商城文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PointMallFileItem pointMallFileItem)
    {
        List<PointMallFileItem> list = pointMallFileItemService.selectPointMallFileItemList(pointMallFileItem);
        ExcelUtil<PointMallFileItem> util = new ExcelUtil<PointMallFileItem>(PointMallFileItem.class);
        util.exportExcel(response, list, "积分商城文件数据");
    }

    /**
     * 获取积分商城文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallFileItem:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pointMallFileItemService.selectPointMallFileItemById(id));
    }

    /**
     * 新增积分商城文件
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallFileItem:add')")
    @Log(title = "积分商城文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PointMallFileItem pointMallFileItem)
    {
        return toAjax(pointMallFileItemService.insertPointMallFileItem(pointMallFileItem));
    }

    /**
     * 修改积分商城文件
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallFileItem:edit')")
    @Log(title = "积分商城文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PointMallFileItem pointMallFileItem)
    {
        return toAjax(pointMallFileItemService.updatePointMallFileItem(pointMallFileItem));
    }

    /**
     * 删除积分商城文件
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MallFileItem:remove')")
    @Log(title = "积分商城文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pointMallFileItemService.deletePointMallFileItemByIds(ids));
    }
}
