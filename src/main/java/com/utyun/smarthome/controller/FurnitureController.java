package com.utyun.smarthome.controller;

import com.utyun.smarthome.service.FurnitureService;
import com.utyun.smarthome.vo.DeviceInformationVO;
import com.utyun.smarthome.vo.VariableList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RefreshScope
@RequestMapping("/api")
@RestController
@Api(tags = "DEMO测试")
public class FurnitureController {

    @Autowired
    private   FurnitureService furnitureService;

    @Value("${utcloud.service-url.compileRuleData:null}")
    private String url;

    @GetMapping("/test")
    @ApiOperation(value = "Hello接口")
    public String test() {
        log.info("url:{}", url);
        return "Hello World..." + url;
    }

    //云执行
    @ResponseBody
    @RequestMapping("/update/device")
    @ApiOperation(value = "更新设备状态信息接口")
    public DeviceInformationVO updateDeviceStatus(String JsonDate, String projectName ) {
        return   furnitureService.updateDeviceStatus;
    }

    @ResponseBody
    @RequestMapping("/find/variable")
    @ApiOperation(value = "查询变量信息")
    public VariableList findVariable(String appKey) {
        return   null;
    }

    @ResponseBody
    @RequestMapping("/update/variable")
    @ApiOperation(value = "查询变量信息")
    public VariableList updateVariable(VariableList variableList) {
        return   null;
    }

    @ResponseBody
    @RequestMapping("/function/execution")
    @ApiOperation(value = "函数执行")
    public VariableList executionFunction(VariableList variableList) {
        return   null;
    }

    //云编译
    // appkey、ulcname、json---->ulcID、ulcName
    @ResponseBody
    @RequestMapping("/cloudCompilation")
    @ApiOperation(value = "云编译")
    public VariableList executionFunction(VariableList variableList) {
        return   null;
    }



}
