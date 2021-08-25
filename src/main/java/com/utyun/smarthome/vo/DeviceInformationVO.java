package com.utyun.smarthome.vo;


import com.utyun.smarthome.entity.VariableEntity;
import lombok.Data;

import java.util.List;

@Data

public class DeviceInformationVO {
//    @ApiModelProperty(value = "appKey")
    private JsonVO jsonVO;

    private List<VariableEntity> variableEntities;

    private String ulcName;


    private String appKey;

    private Integer type;


//    public void setJsonVO(JsonVO jsonVO) {
//        this.jsonVO = jsonVO;
//    }
//
//    public String getAppKey() {
//        return appKey;
//    }
}
