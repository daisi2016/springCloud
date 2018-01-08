package com.spring.cloud.feign.client.sleuth;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="ribbon-consumer",fallback=BuzRibbonInvokerServiceHystrix.class)
public interface BuzRibbonInvokerService {
	@RequestMapping(value = "/getClientSeria" ,method = RequestMethod.GET)
	public String getAcceptSerio(@RequestParam(value="certNo") String certNo) ;

}
