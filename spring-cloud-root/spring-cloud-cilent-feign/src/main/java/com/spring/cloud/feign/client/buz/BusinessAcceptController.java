package com.spring.cloud.feign.client.buz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BusinessAcceptController {
	@Autowired
	BusinessAcceptService service;
	@RequestMapping(value = "/getClientSeria", method = RequestMethod.GET)
    public String getAcceptSeria(@RequestParam String certNo) {
		String str = service.getAcceptSerio("feign",certNo);
        return str;
    }

}
