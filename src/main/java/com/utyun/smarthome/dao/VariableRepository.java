package com.utyun.smarthome.dao;

import com.utyun.smarthome.entity.VariableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface VariableRepository extends JpaRepository<VariableEntity,Long>, JpaSpecificationExecutor<VariableEntity> {
}
