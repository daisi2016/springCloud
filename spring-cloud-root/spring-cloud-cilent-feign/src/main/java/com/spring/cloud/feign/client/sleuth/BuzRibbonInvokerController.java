package com.spring.cloud.feign.client.sleuth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.cloud.feign.client.buz.BusinessAcceptService;
@RestController
public class BuzRibbonInvokerController {
	@Autowired
	BuzRibbonInvokerService service;
	@Autowired
	BusinessAcceptService acceptService;
	@RequestMapping(value = "/get2Seria", method = RequestMethod.GET)
    public String getAcceptSeria2(@RequestParam String certNo) {
		String str = service.getAcceptSerio(certNo);
        return str;
    }

	@RequestMapping(value = "/get3Seria", method = RequestMethod.GET)
    public String getAcceptSeria3(@RequestParam String certNo) {
		String str =acceptService.getAcceptSerio("feign sleuth", certNo);
		 str = service.getAcceptSerio(str);
        return str;
    }
}
