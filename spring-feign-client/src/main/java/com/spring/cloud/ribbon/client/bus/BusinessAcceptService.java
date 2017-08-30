package com.spring.cloud.ribbon.client.bus;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="business-service",fallback=BusinessAcceptServiceFallback.class)
public interface BusinessAcceptService {
	@RequestMapping(value = "/getAcceptSeria" ,method = RequestMethod.GET)
	public String getAcceptSerio(@RequestParam(value="client") String client,@RequestParam(value="certNo") String certNo) ;

}
