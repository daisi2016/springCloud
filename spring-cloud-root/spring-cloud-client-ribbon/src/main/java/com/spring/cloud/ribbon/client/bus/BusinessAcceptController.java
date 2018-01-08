package com.spring.cloud.ribbon.client.bus;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BusinessAcceptController {
	  private static final Logger LOG = Logger.getLogger(BusinessAcceptController.class.getName());
	@Autowired
	BusinessAcceptService service;
	
	@RequestMapping(value = "/getClientSeria", method = RequestMethod.GET)
    public String getAcceptSeria(@RequestParam String certNo) {
		LOG.info("go");
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("client", "ribbon");
		map.put("certNo", certNo);
		String str = service.invok(map);
		return str;
    }
	

}
