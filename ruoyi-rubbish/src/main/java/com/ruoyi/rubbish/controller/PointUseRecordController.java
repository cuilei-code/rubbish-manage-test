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
import com.ruoyi.rubbish.domain.PointUseRecord;
import com.ruoyi.rubbish.service.IPointUseRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分使用记录Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/PointUseRecord")
public class PointUseRecordController extends BaseController
{
    @Autowired
    private IPointUseRecordService pointUseRecordService;

    /**
     * 查询积分使用记录列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(PointUseRecord pointUseRecord)
    {
        startPage();
        List<PointUseRecord> list = pointUseRecordService.selectPointUseRecordList(pointUseRecord);
        return getDataTable(list);
    }

    /**
     * 导出积分使用记录列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecord:export')")
    @Log(title = "积分使用记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PointUseRecord pointUseRecord)
    {
        List<PointUseRecord> list = pointUseRecordService.selectPointUseRecordList(pointUseRecord);
        ExcelUtil<PointUseRecord> util = new ExcelUtil<PointUseRecord>(PointUseRecord.class);
        util.exportExcel(response, list, "积分使用记录数据");
    }

    /**
     * 获取积分使用记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pointUseRecordService.selectPointUseRecordById(id));
    }

    /**
     * 新增积分使用记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecord:add')")
    @Log(title = "积分使用记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PointUseRecord pointUseRecord)
    {
        return toAjax(pointUseRecordService.insertPointUseRecord(pointUseRecord));
    }

    /**
     * 修改积分使用记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecord:edit')")
    @Log(title = "积分使用记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PointUseRecord pointUseRecord)
    {
        return toAjax(pointUseRecordService.updatePointUseRecord(pointUseRecord));
    }

    /**
     * 删除积分使用记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecord:remove')")
    @Log(title = "积分使用记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pointUseRecordService.deletePointUseRecordByIds(ids));
    }
}
