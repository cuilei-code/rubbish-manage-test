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
import com.ruoyi.rubbish.domain.WithdrawalRecordMain;
import com.ruoyi.rubbish.service.IWithdrawalRecordMainService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 提现记录Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/WithDrawalRecordMain")
public class WithdrawalRecordMainController extends BaseController
{
    @Autowired
    private IWithdrawalRecordMainService withdrawalRecordMainService;

    /**
     * 查询提现记录列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WithDrawalRecordMain:list')")
    @GetMapping("/list")
    public TableDataInfo list(WithdrawalRecordMain withdrawalRecordMain)
    {
        startPage();
        List<WithdrawalRecordMain> list = withdrawalRecordMainService.selectWithdrawalRecordMainList(withdrawalRecordMain);
        return getDataTable(list);
    }

    /**
     * 导出提现记录列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WithDrawalRecordMain:export')")
    @Log(title = "提现记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WithdrawalRecordMain withdrawalRecordMain)
    {
        List<WithdrawalRecordMain> list = withdrawalRecordMainService.selectWithdrawalRecordMainList(withdrawalRecordMain);
        ExcelUtil<WithdrawalRecordMain> util = new ExcelUtil<WithdrawalRecordMain>(WithdrawalRecordMain.class);
        util.exportExcel(response, list, "提现记录数据");
    }

    /**
     * 获取提现记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WithDrawalRecordMain:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(withdrawalRecordMainService.selectWithdrawalRecordMainById(id));
    }

    /**
     * 新增提现记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WithDrawalRecordMain:add')")
    @Log(title = "提现记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WithdrawalRecordMain withdrawalRecordMain)
    {
        return toAjax(withdrawalRecordMainService.insertWithdrawalRecordMain(withdrawalRecordMain));
    }

    /**
     * 修改提现记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WithDrawalRecordMain:edit')")
    @Log(title = "提现记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WithdrawalRecordMain withdrawalRecordMain)
    {
        return toAjax(withdrawalRecordMainService.updateWithdrawalRecordMain(withdrawalRecordMain));
    }

    /**
     * 删除提现记录
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WithDrawalRecordMain:remove')")
    @Log(title = "提现记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(withdrawalRecordMainService.deleteWithdrawalRecordMainByIds(ids));
    }
}
