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
import com.ruoyi.rubbish.domain.PointUseRecordDetail;
import com.ruoyi.rubbish.service.IPointUseRecordDetailService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 积分核销记录明细Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/PointUseRecordDetail")
public class PointUseRecordDetailController extends BaseController
{
    @Autowired
    private IPointUseRecordDetailService pointUseRecordDetailService;

    /**
     * 查询积分核销记录明细列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecordDetail:list')")
    @GetMapping("/list")
    public TableDataInfo list(PointUseRecordDetail pointUseRecordDetail)
    {
        startPage();
        List<PointUseRecordDetail> list = pointUseRecordDetailService.selectPointUseRecordDetailList(pointUseRecordDetail);
        return getDataTable(list);
    }

    /**
     * 导出积分核销记录明细列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecordDetail:export')")
    @Log(title = "积分核销记录明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PointUseRecordDetail pointUseRecordDetail)
    {
        List<PointUseRecordDetail> list = pointUseRecordDetailService.selectPointUseRecordDetailList(pointUseRecordDetail);
        ExcelUtil<PointUseRecordDetail> util = new ExcelUtil<PointUseRecordDetail>(PointUseRecordDetail.class);
        util.exportExcel(response, list, "积分核销记录明细数据");
    }

    /**
     * 获取积分核销记录明细详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecordDetail:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pointUseRecordDetailService.selectPointUseRecordDetailById(id));
    }

    /**
     * 新增积分核销记录明细
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecordDetail:add')")
    @Log(title = "积分核销记录明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PointUseRecordDetail pointUseRecordDetail)
    {
        return toAjax(pointUseRecordDetailService.insertPointUseRecordDetail(pointUseRecordDetail));
    }

    /**
     * 修改积分核销记录明细
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecordDetail:edit')")
    @Log(title = "积分核销记录明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PointUseRecordDetail pointUseRecordDetail)
    {
        return toAjax(pointUseRecordDetailService.updatePointUseRecordDetail(pointUseRecordDetail));
    }

    /**
     * 删除积分核销记录明细
     */
    @PreAuthorize("@ss.hasPermi('rubbish:PointUseRecordDetail:remove')")
    @Log(title = "积分核销记录明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pointUseRecordDetailService.deletePointUseRecordDetailByIds(ids));
    }
}
