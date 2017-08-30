package com.spring.cloud.ribbon.client.bus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class BusinessAcceptController {
	@Autowired
	BusinessAcceptService service;
	
	@RequestMapping(value = "/getAcceptSeria", method = RequestMethod.GET)
    public String getAcceptSeria() {
		String str = service.getAcceptSerio("8", "tttt");
        return str;
    }

}
