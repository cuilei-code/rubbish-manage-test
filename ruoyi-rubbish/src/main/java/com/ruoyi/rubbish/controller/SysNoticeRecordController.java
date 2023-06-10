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
import com.ruoyi.rubbish.domain.SysNoticeRecord;
import com.ruoyi.rubbish.service.ISysNoticeRecordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 消息发送记录Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/NoticeRecord")
public class SysNoticeRecordController extends BaseController
{
    @Autowired
    private ISysNoticeRecordService sysNoticeRecordService;

    /**
     * 查询消息发送记录列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:NoticeRecord:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysNoticeRecord sysNoticeRecord)
    {
        startPage();
        List<SysNoticeRecord> list = sysNoticeRecordService.selectSysNoticeRecordList(sysNoticeRecord);
        return getDataTable(list);
    }

    /**
     * 导出消息发送记录列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:NoticeRecord:export')")
    @Log(title = "消息发送记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysNoticeRecord sysNoticeRecord)
    {
        List<SysNoticeRecord> list = sysNoticeRecordService.selectSysNoticeRecordList(sysNoticeRecord);
        ExcelUtil<SysNoticeRecord> util = new ExcelUtil<SysNoticeRecord>(SysNoticeRecord.class);
        util.exportExcel(response, list, "消息发送记录数据");
    }

    /**
     * 获取消息发送记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:NoticeRecord:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(sysNoticeRecordService.selectSysNoticeRecordById(id));
    }

    /**
     * 新增消息发送记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:NoticeRecord:add')")
    @Log(title = "消息发送记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysNoticeRecord sysNoticeRecord)
    {
        return toAjax(sysNoticeRecordService.insertSysNoticeRecord(sysNoticeRecord));
    }

    /**
     * 修改消息发送记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:NoticeRecord:edit')")
    @Log(title = "消息发送记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysNoticeRecord sysNoticeRecord)
    {
        return toAjax(sysNoticeRecordService.updateSysNoticeRecord(sysNoticeRecord));
    }

    /**
     * 删除消息发送记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:NoticeRecord:remove')")
    @Log(title = "消息发送记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysNoticeRecordService.deleteSysNoticeRecordByIds(ids));
    }
}
