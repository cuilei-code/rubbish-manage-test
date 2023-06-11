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
import com.ruoyi.rubbish.domain.WxUser;
import com.ruoyi.rubbish.service.IWxUserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客户端普通用户Controller
 * 
 * @author ruoyi
 * @date 2023-06-11
 */
@RestController
@RequestMapping("/rubbish/WxUser")
public class WxUserController extends BaseController
{
    @Autowired
    private IWxUserService wxUserService;

    /**
     * 查询客户端普通用户列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WxUser:list')")
    @GetMapping("/list")
    public TableDataInfo list(WxUser wxUser)
    {
        startPage();
        List<WxUser> list = wxUserService.selectWxUserList(wxUser);
        return getDataTable(list);
    }

    /**
     * 导出客户端普通用户列表
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WxUser:export')")
    @Log(title = "客户端普通用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WxUser wxUser)
    {
        List<WxUser> list = wxUserService.selectWxUserList(wxUser);
        ExcelUtil<WxUser> util = new ExcelUtil<WxUser>(WxUser.class);
        util.exportExcel(response, list, "客户端普通用户数据");
    }

    /**
     * 获取客户端普通用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WxUser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(wxUserService.selectWxUserById(id));
    }

    //@PreAuthorize("@ss.hasPermi('rubbish:WxUser:query')")
    @GetMapping(value = "/wx/{openid}")
    public AjaxResult getInfoByOpenId(@PathVariable("openid") String openid)
    {
        return success(wxUserService.selectWxUserByOpenId(openid));
    }

    /**
     * 新增客户端普通用户
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WxUser:add')")
    @Log(title = "客户端普通用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WxUser wxUser)
    {
        return toAjax(wxUserService.insertWxUser(wxUser));
    }

    /**
     * 修改客户端普通用户
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WxUser:edit')")
    @Log(title = "客户端普通用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WxUser wxUser)
    {
        return toAjax(wxUserService.updateWxUser(wxUser));
    }

    /**
     * 删除客户端普通用户
     */
    @PreAuthorize("@ss.hasPermi('rubbish:WxUser:remove')")
    @Log(title = "客户端普通用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wxUserService.deleteWxUserByIds(ids));
    }
}
