package com.utyun.smarthome.dao;

import com.utyun.smarthome.entity.VariableEntity;
import com.utyun.smarthome.vo.VariableList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface VariableRepository extends JpaRepository<VariableEntity,Long>, JpaSpecificationExecutor<VariableEntity> {

    List<VariableEntity> findAllByAppKey(String appKey);
}
