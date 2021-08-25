package com.utyun.smarthome.dao;

import com.utyun.smarthome.entity.CompileEntity;
import com.utyun.smarthome.entity.VariableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CompileRepository extends JpaRepository<CompileEntity,Long>, JpaSpecificationExecutor<CompileEntity> {
}
