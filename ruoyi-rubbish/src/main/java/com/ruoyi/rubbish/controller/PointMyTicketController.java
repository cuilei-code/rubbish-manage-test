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
import com.ruoyi.rubbish.domain.PointMyTicket;
import com.ruoyi.rubbish.service.IPointMyTicketService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 兑换券管理Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/MyTicket")
public class PointMyTicketController extends BaseController
{
    @Autowired
    private IPointMyTicketService pointMyTicketService;

    /**
     * 查询兑换券管理列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MyTicket:list')")
    @GetMapping("/list")
    public TableDataInfo list(PointMyTicket pointMyTicket)
    {
        startPage();
        List<PointMyTicket> list = pointMyTicketService.selectPointMyTicketList(pointMyTicket);
        return getDataTable(list);
    }

    /**
     * 导出兑换券管理列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MyTicket:export')")
    @Log(title = "兑换券管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PointMyTicket pointMyTicket)
    {
        List<PointMyTicket> list = pointMyTicketService.selectPointMyTicketList(pointMyTicket);
        ExcelUtil<PointMyTicket> util = new ExcelUtil<PointMyTicket>(PointMyTicket.class);
        util.exportExcel(response, list, "兑换券管理数据");
    }

    /**
     * 获取兑换券管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MyTicket:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(pointMyTicketService.selectPointMyTicketById(id));
    }

    /**
     * 新增兑换券管理
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MyTicket:add')")
    @Log(title = "兑换券管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PointMyTicket pointMyTicket)
    {
        return toAjax(pointMyTicketService.insertPointMyTicket(pointMyTicket));
    }

    /**
     * 修改兑换券管理
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MyTicket:edit')")
    @Log(title = "兑换券管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PointMyTicket pointMyTicket)
    {
        return toAjax(pointMyTicketService.updatePointMyTicket(pointMyTicket));
    }

    /**
     * 删除兑换券管理
     */
    @PreAuthorize("@ss.hasPermi('rubbish:MyTicket:remove')")
    @Log(title = "兑换券管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pointMyTicketService.deletePointMyTicketByIds(ids));
    }
}
