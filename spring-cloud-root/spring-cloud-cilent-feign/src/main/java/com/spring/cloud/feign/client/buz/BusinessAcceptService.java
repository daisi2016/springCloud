package com.spring.cloud.feign.client.buz;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="business-service",fallback = BusinessAcceptServiceHystrix.class)
public interface BusinessAcceptService {
	@RequestMapping(value = "/getSeria" ,method = RequestMethod.GET)
	public String getAcceptSerio(@RequestParam(value="client") String client,@RequestParam(value="certNo") String certNo) ;

}
