package com.utyun.smarthome.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.utyun.smarthome.dao.CompileRepository;
import com.utyun.smarthome.dao.VariableRepository;
import com.utyun.smarthome.entity.CompileEntity;
import com.utyun.smarthome.entity.VariableEntity;
import com.utyun.smarthome.feign.FeignUtil;
import com.utyun.smarthome.vo.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Resource
public class HomeService {


    @Autowired
    private FeignUtil feignUtil;

    @Autowired
    private CompileRepository compileRepository;

    @Autowired
    private VariableRepository variableRepository;

    // 先获取 变量表,储存,在发给中间件
    // 取出编译表储存,在发给中间件

    public DeviceInformationVO updateDeviceStatus(JsonVO jsonVO, String projectName) {
        List<VariableList> variableTable = jsonVO.getVariableList();
        List<VariableEntity> variableEntities = new ArrayList<>();
        for (VariableList item : variableTable) {
            VariableEntity variableEntity = new VariableEntity();
            BeanUtils.copyProperties(item, variableEntity);
            variableEntities.add(variableEntity);
            variableRepository.save(variableEntity);
        }
        String encodeStr = DigestUtils.md5Hex(projectName);

        // 存编译表
        CompileVO compileVO = new CompileVO();
        compileVO.setProjectName(projectName);
        compileVO.setInput(jsonVO);
        compileVO.setUlcName(encodeStr);//唯一
        compileVO.setCompileLog("MD5");
        compileVO.setCompileDate(new Date());

        CompileEntity compileEntity = new CompileEntity();
        BeanUtils.copyProperties(compileVO, compileEntity);
        compileRepository.save(compileEntity);

        DeviceInformationVO deviceInformationVO = new DeviceInformationVO();
        deviceInformationVO.setVariableEntities(variableEntities);
        deviceInformationVO.setAppKey(encodeStr);
        deviceInformationVO.setUlcName(encodeStr);
        deviceInformationVO.setType(1);

        return deviceInformationVO;
    }

    // 变量查询
    // 不用调feign，直接查数据库
    public List<VariableList> findVariable(String appKey) {
        if (StringUtils.isEmpty(appKey)) {
    //            throw new UtException(UtExceptionEnum.FIELD_DATATABLE_ROW_BATCH_CREATE_ERROR, "appKey为空");
        }
        List<VariableEntity> variableEntities = variableRepository.findAllByAppKey(appKey);
        List<VariableList> variableLists = new ArrayList<>();
        for (VariableEntity item : variableEntities) {
            VariableList variableList = new VariableList();
            BeanUtils.copyProperties(item, variableList);
            variableLists.add(variableList);
        }
        return variableLists;
    }


    // 变量更新
    public void updateVariable(List<VariableList> variableLists, String appKey) {
        List<VariableEntity> variableEntities = variableRepository.findAllByAppKey(appKey);
        for (VariableList item : variableLists) {
            VariableEntity variableEntity = new VariableEntity();
            BeanUtils.copyProperties(item, variableEntity);
            variableRepository.save(variableEntity);
        }
    }

    // 执行函数接口 模拟几个函数

    public void timeFunction() {
    }

    // 编译 两个接口 一个发送，一个接收
    // 编译表信息 发给中间件---中间件调用云编译----返回的信息存在compileLog里---------- compileLog
    public void compileFunction(String projectName,String json,String ulcName,Date compileDate){
        feignUtil.setCompileDate(projectName,json,ulcName,compileDate);
        feignUtil.getCompileLog(projectName);
    //save
    }
}
