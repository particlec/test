package com.utyun.smarthome.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.utyun.smarthome.dao.VariableRepository;
import com.utyun.smarthome.entity.VariableEntity;
import com.utyun.smarthome.feign.FeignUtil;
import com.utyun.smarthome.vo.DeviceInformationVO;
import com.utyun.smarthome.vo.JsonVO;
import com.utyun.smarthome.vo.VariableList;
import com.utyun.smarthome.vo.VariableVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Resource
public class FurnitureService {

    @Autowired
    private FeignUtil feignUtil;

    @Autowired
    private VariableRepository variableRepository;

   // 先获取 变量表,储存,在发给中间件
   // 取出编译表储存,在发给中间件
    public DeviceInformationVO updateDeviceStatus;

    public DeviceInformationVO updateDeviceStatus(JsonVO jsonVO, String projectName) {

        List<VariableList> variableTable = jsonVO.getVariableList();
        List<VariableEntity> variableEntities = new ArrayList<>();
        for (VariableList item : variableTable) {
            VariableEntity variableEntity = new VariableEntity();
            BeanUtils.copyProperties(item, variableEntity);
            variableEntities.add(variableEntity);
            variableRepository.save(variableEntity);
        }
        DeviceInformationVO deviceInformationVO = new DeviceInformationVO();

        deviceInformationVO.setJsonVO(jsonVO);

        return deviceInformationVO;
    }

    // 变量查询
    // 不用调feign，直接查数据库
    public List<VariableList> findVariable(String appKey){
        if( StringUtils.isEmpty(appKey)){
//            throw new UtException(UtExceptionEnum.FIELD_DATATABLE_ROW_BATCH_CREATE_ERROR, "appKey为空");
        }
       List<VariableEntity>variableEntities = variableRepository.findAllByAppKey(appKey);
        List<VariableList>variableLists = new ArrayList<>();
        for( VariableEntity item : variableEntities){
            VariableList variableList = new VariableList();
            BeanUtils.copyProperties(item,variableList);
            variableLists.add(variableList);
        }
        return variableLists;
    }

   
    // 变量更新
    public void updateVariable(List<VariableList> variableLists,String appKey){
        List<VariableEntity> variableEntities =  variableRepository.findAllByAppKey(appKey);
        for(VariableList item : variableLists){
            VariableEntity variableEntity = new VariableEntity();
            BeanUtils.copyProperties(item,variableEntity);
            variableRepository.save(variableEntity);
        }
    }



    // 执行函数接口
       public void timeFunction(){

       }






}
