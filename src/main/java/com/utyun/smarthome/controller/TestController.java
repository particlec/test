package com.utyun.smarthome.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RequestMapping("/api")
@RestController
@Api(tags = "DEMO测试")
public class TestController {

    @Value("${utcloud.service-url.compileRuleData:null}")
    private String url;

    @GetMapping("/test")
    @ApiOperation(value = "Hello接口")
    public String test() {
        log.info("url:{}", url);
        return "Hello World..." + url;
    }

}
