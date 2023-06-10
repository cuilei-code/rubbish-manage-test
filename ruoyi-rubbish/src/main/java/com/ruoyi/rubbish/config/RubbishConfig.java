package com.ruoyi.rubbish.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * <p></p>
 *
 * @author lichanghao
 * @version 1.0
 * @date 2023/6/10 下午 9:23
 */
@Component
@ConfigurationProperties(prefix = "rubbish.wechat")
@PropertySource(value = {"classpath:rubbish.yaml"})
@Data
public class RubbishConfig {
    @Value("${appId}")
    private String appId;
    @Value("${appSecret}")
    private String appSecret;
}
