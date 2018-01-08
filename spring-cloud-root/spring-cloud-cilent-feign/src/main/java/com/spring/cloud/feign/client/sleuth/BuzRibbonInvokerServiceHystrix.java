package com.spring.cloud.feign.client.sleuth;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class BuzRibbonInvokerServiceHystrix implements BuzRibbonInvokerService {
	public String getAcceptSerio(@RequestParam(value="certNo") String certNo) {
		
		return "feign:-ribbon-consumer不可用，请联系管理员";
		
	}

}
