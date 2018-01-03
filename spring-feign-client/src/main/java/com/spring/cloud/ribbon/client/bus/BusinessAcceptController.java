package com.spring.cloud.ribbon.client.bus;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class BusinessAcceptController {
	@Autowired
	BusinessAcceptService service;
	private static final Logger LOG = Logger.getLogger(BusinessAcceptController.class.getName());	
	@RequestMapping(value = "/getAcceptSeria", method = RequestMethod.GET)
    public String getAcceptSeria() {
		LOG.log(Level.INFO, "calling getAcceptSeria service");
		String str = service.getAcceptSerio("8", "tttt");
        return str;
    }

}
