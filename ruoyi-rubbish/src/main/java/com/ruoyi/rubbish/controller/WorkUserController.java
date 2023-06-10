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
import com.ruoyi.rubbish.domain.WorkUser;
import com.ruoyi.rubbish.service.IWorkUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 工作端用户信息Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/WorkUser")
public class WorkUserController extends BaseController
{
    @Autowired
    private IWorkUserService workUserService;

    /**
     * 查询工作端用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WorkUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(WorkUser workUser)
    {
        startPage();
        List<WorkUser> list = workUserService.selectWorkUserList(workUser);
        return getDataTable(list);
    }

    /**
     * 导出工作端用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WorkUser:export')")
    @Log(title = "工作端用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WorkUser workUser)
    {
        List<WorkUser> list = workUserService.selectWorkUserList(workUser);
        ExcelUtil<WorkUser> util = new ExcelUtil<WorkUser>(WorkUser.class);
        util.exportExcel(response, list, "工作端用户信息数据");
    }

    /**
     * 获取工作端用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WorkUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(workUserService.selectWorkUserById(id));
    }

    /**
     * 新增工作端用户信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WorkUser:add')")
    @Log(title = "工作端用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WorkUser workUser)
    {
        return toAjax(workUserService.insertWorkUser(workUser));
    }

    /**
     * 修改工作端用户信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WorkUser:edit')")
    @Log(title = "工作端用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WorkUser workUser)
    {
        return toAjax(workUserService.updateWorkUser(workUser));
    }

    /**
     * 删除工作端用户信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WorkUser:remove')")
    @Log(title = "工作端用户信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(workUserService.deleteWorkUserByIds(ids));
    }
}
