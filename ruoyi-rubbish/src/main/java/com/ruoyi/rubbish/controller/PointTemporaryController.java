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
import com.ruoyi.rubbish.domain.PointTemporary;
import com.ruoyi.rubbish.service.IPointTemporaryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 临时积分Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/temporary")
public class PointTemporaryController extends BaseController
{
    @Autowired
    private IPointTemporaryService pointTemporaryService;

    /**
     * 查询临时积分列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:temporary:list')")
    @GetMapping("/list")
    public TableDataInfo list(PointTemporary pointTemporary)
    {
        startPage();
        List<PointTemporary> list = pointTemporaryService.selectPointTemporaryList(pointTemporary);
        return getDataTable(list);
    }

    /**
     * 导出临时积分列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:temporary:export')")
    @Log(title = "临时积分", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PointTemporary pointTemporary)
    {
        List<PointTemporary> list = pointTemporaryService.selectPointTemporaryList(pointTemporary);
        ExcelUtil<PointTemporary> util = new ExcelUtil<PointTemporary>(PointTemporary.class);
        util.exportExcel(response, list, "临时积分数据");
    }

    /**
     * 获取临时积分详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:temporary:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pointTemporaryService.selectPointTemporaryById(id));
    }

    /**
     * 新增临时积分
     */
    @PreAuthorize("@ss.hasPermi('rubbish:temporary:add')")
    @Log(title = "临时积分", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PointTemporary pointTemporary)
    {
        return toAjax(pointTemporaryService.insertPointTemporary(pointTemporary));
    }

    /**
     * 修改临时积分
     */
    @PreAuthorize("@ss.hasPermi('rubbish:temporary:edit')")
    @Log(title = "临时积分", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PointTemporary pointTemporary)
    {
        return toAjax(pointTemporaryService.updatePointTemporary(pointTemporary));
    }

    /**
     * 删除临时积分
     */
    @PreAuthorize("@ss.hasPermi('rubbish:temporary:remove')")
    @Log(title = "临时积分", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pointTemporaryService.deletePointTemporaryByIds(ids));
    }
}
