package com.htsec.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htsec.boot.jpa.service.IJpaSystemConfigPropertyService;
import com.htsec.boot.model.SystemConfigPropertyEntity;
import com.htsec.boot.mybaties.service.SystemConfigMapper;

@RestController
@RequestMapping(value="/system")
public class SystemPropertyController {
	@Autowired
	IJpaSystemConfigPropertyService service;
	@Autowired
	SystemConfigMapper daoService;
	
	@RequestMapping(value="/configs/{id}",method=RequestMethod.GET)
	public SystemConfigPropertyEntity getByid(@PathVariable Long id) {
		SystemConfigPropertyEntity entity = service.findById(id);
		return entity;
	}

	@RequestMapping(value="/configs/mybaties/{id}",method=RequestMethod.GET)
	public SystemConfigPropertyEntity getConfigByid(@PathVariable Long id) {
		SystemConfigPropertyEntity entity = daoService.findById(id);
		return entity;
		
	}

}
