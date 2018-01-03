package com.spring.cloud.bus.service;

import java.util.Date;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BusinessAcceptService {
	private static final Logger LOG = Logger.getLogger(BusinessAcceptService.class.getName());	
	 @Autowired
	    private DiscoveryClient discoveryClient;
	@RequestMapping(value = "/getAcceptSeria" ,method = RequestMethod.GET)
	public String getAcceptSerio(@RequestParam String client,@RequestParam String certNo) {
		LOG.log(Level.INFO, "service2 receive request");
		ServiceInstance instance = discoveryClient.getLocalServiceInstance();
		System.out.println("host:" + instance.getHost() +", service_id:" + instance.getServiceId());
		LOG.log(Level.INFO, "service2 invoker request");
		return new Date().toString()+client+certNo+"---------->service2";
	}

}
