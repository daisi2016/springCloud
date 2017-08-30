package com.htsec.boot.jpa.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.htsec.boot.model.SystemConfigPropertyEntity;

/**
 * 系統參數配置服務接口-
 * 
 * @author Si.Dai
 * 
 */
@Repository(value="jpaSystemConfigPropertyService")
public interface IJpaSystemConfigPropertyService  extends JpaRepository<SystemConfigPropertyEntity, Long>,JpaSpecificationExecutor<SystemConfigPropertyEntity>{
	
	public SystemConfigPropertyEntity findById(Long id);
	public List<SystemConfigPropertyEntity> findByModuleAndCode(String module,String code);
	public List<SystemConfigPropertyEntity> findBySelectAllFlag(String selectAllFlag);
	
	
	
}
