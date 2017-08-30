package com.spring.cloud.ribbon.client.bus;

import org.springframework.stereotype.Component;

@Component
public class BusinessAcceptServiceFallback implements BusinessAcceptService {

	@Override
	public String getAcceptSerio(String client, String certNo) {
		return "-9999";
	}

}
