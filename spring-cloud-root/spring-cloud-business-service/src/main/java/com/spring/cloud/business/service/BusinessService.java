package com.spring.cloud.business.service;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessService {
 @Value("${server.port}")
   private String port;
	private static final Logger LOG = Logger.getLogger(BusinessService.class.getName());	
	@RequestMapping(value = "/getSeria" ,method = RequestMethod.GET)
	public String getAcceptSerio(@RequestParam String client,@RequestParam String certNo) {
		LOG.info(new Date().toString()+"certNo:"+certNo);
		return new Date().toString()+"certNo:"+certNo+",request resource:"+client;
	}



}
