package com.utyun.smarthome.vo;


import lombok.Data;

@Data
public class DeviceInformationVO {
//    @ApiModelProperty(value = "appKey")
    private JsonVO jsonVO;


    private String ulcName;


    private String jsonDate;


    public void setJsonVO(JsonVO jsonVO) {
        this.jsonVO = jsonVO;
    }

}
