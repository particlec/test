package com.utyun.smarthome.controller;

import com.utyun.smarthome.service.HomeService;
import com.utyun.smarthome.vo.DeviceInformationVO;
import com.utyun.smarthome.vo.JsonVO;
import com.utyun.smarthome.vo.VariableList;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RefreshScope
@RequestMapping("/furniture")
@RestController
@Api(tags = "家具模拟")
public class FurnitureController {

    @Autowired
    private HomeService furnitureService;

    @Value("${utcloud.service-url.compileRuleData:null}")
    private String url;


    @ResponseBody
    @RequestMapping("/update/device")
    @ApiOperation(value = "更新设备状态信息接口")
    public DeviceInformationVO updateDeviceStatus(@Valid JsonVO JsonDate, String projectName ) {
        return   furnitureService.updateDeviceStatus(JsonDate,projectName);
    }

    @ResponseBody
    @RequestMapping("/find/variable")
    @ApiOperation(value = "查询变量信息")
    public VariableList findVariable(@Valid String appKey) {
        return   null;
    }

    @ResponseBody
    @RequestMapping("/update/variable")
    @ApiOperation(value = "更新变量信息")
    public VariableList updateVariable(@Valid VariableList variableList) {
        return   null;
    }

    @ResponseBody
    @RequestMapping("/function/execution")
    @ApiOperation(value = "函数执行")
    public VariableList executionFunction(@Valid VariableList variableList) {
        return   null;
    }

    @ResponseBody
    @RequestMapping("/compile")
    @ApiOperation(value = "编译")
    public VariableList compileFunction(@Valid VariableList variableList) {
        return   null;
    }

}
