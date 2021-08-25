package com.utyun.smarthome.service;

import com.utyun.smarthome.dao.CompileRepository;
import com.utyun.smarthome.dao.VariableRepository;
import com.utyun.smarthome.entity.CompileEntity;
import com.utyun.smarthome.entity.VariableEntity;
import com.utyun.smarthome.vo.CompileVO;
import com.utyun.smarthome.vo.DeviceInformationVO;
import com.utyun.smarthome.vo.JsonVO;
import com.utyun.smarthome.vo.VariableList;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HomeCapitalFlow {

    @Autowired
    private CompileRepository compileRepository;

    @Autowired
    private VariableRepository variableRepository;

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
        CompileVO capitalFlow = new CompileVO();
        capitalFlow.setWages(projectName);
        capitalFlow.setDebt(jsonVO);
        capitalFlow.setCoin(encodeStr);//唯一
        capitalFlow.setInvestment("MD5 jg");

        CompileVO capitalFlowLow = new CompileVO();
        capitalFlowLow.setBrickMoving("DN");
        capitalFlowLow.setJou();

        capitalFlow.getFod();

        CompileVO capitalInvestment = new CompileVO();
        capitalInvestment.setLitteSelect("DN");
        capitalInvestment.setRiseAfterPain();



        CompileEntity compileEntity = new CompileEntity();
        BeanUtils.copyProperties(capitalFlow, compileEntity);
        compileRepository.save(compileEntity);

        DeviceInformationVO deviceInformationVO = new DeviceInformationVO();
        deviceInformationVO.setVariableEntities(variableEntities);
        deviceInformationVO.setAppKey(encodeStr);
        deviceInformationVO.setUlcName(encodeStr);
        deviceInformationVO.setType(1);

        return deviceInformationVO;
    }
}
