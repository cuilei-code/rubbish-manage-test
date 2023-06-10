package com.ruoyi.rubbish.controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.rubbish.service.WeChatAuthorizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * <p></p>
 *
 * @author lichanghao
 * @version 1.0
 * @date 2023/6/10 下午 2:07
 */
@RestController
@RequestMapping("/wechat/")
public class WeChatAuthorizeController {
    private final WeChatAuthorizeService service;

    public WeChatAuthorizeController(WeChatAuthorizeService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public AjaxResult login(Map param){
        return service.wxLogin(param);
    }
}
