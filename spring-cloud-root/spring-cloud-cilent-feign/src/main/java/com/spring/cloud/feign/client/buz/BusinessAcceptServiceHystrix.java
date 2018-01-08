package com.spring.cloud.feign.client.buz;

import org.springframework.stereotype.Component;

@Component
public class BusinessAcceptServiceHystrix  implements BusinessAcceptService{

	@Override
	public String getAcceptSerio(String client, String certNo) {
		 
		return "feign:-BUSINESS-SERVICE不可用，请联系管理员";
	}

}
