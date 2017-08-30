package com.htsec.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htsec.boot.jpa.service.IJpaSystemConfigPropertyService;
import com.htsec.boot.model.AuditLogEntity;
import com.htsec.boot.model.SystemConfigPropertyEntity;
import com.htsec.boot.mybaties.service.AuditLogEntityMapper;
import com.htsec.boot.mybaties.service.PagingBo;
import com.htsec.boot.mybaties.service.SystemConfigMapper;
@RestController
@RequestMapping(value="/audit")
public class AuditLogController {

	 
	@Autowired
	AuditLogEntityMapper service;
	
	@RequestMapping(value="/logs/{id}",method=RequestMethod.GET)
	public AuditLogEntity getByid(@PathVariable Long id) {
		AuditLogEntity entity = service.findById(id);
		return entity;
	}
	@RequestMapping(value="/logs/count",method=RequestMethod.GET)
	public int geCount() {
		int count = service.getCount();
		return count;
	}

	@RequestMapping(value="/logs",method=RequestMethod.GET)
	public List<AuditLogEntity> getConfigByid() {
		AuditLogEntity entity = new AuditLogEntity();
		 PagingBo bo = new PagingBo();
		 bo.setStart(0);
		 bo.setPagesize(40);
		 bo.setParameter("auditResult", "AS");
		List<AuditLogEntity> list = service.getPageData(bo);
		return list;
		
	}



}
