package com.utyun.smarthome.feign;

import com.utyun.smarthome.vo.VariableList;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "util-service2", url = "${platform.service-url.util}")
public interface FeignUtil {

//    https://dev.utcook.com/application-manager/user/application/variable/list?appKey=aaa

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    VariableList getVariableList(String appKey);


    @RequestMapping(value = "/update", method = RequestMethod.GET)
    void updateVariableList(VariableList variableList);


}
