package com.spring.cloud.ribbon.client.bus;

import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class BusinessAcceptService {
	 private static final Logger LOG = Logger.getLogger(BusinessAcceptService.class.getName());
	@Autowired
    RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "errorCall")
    public String invok(Map<String,Object>param) {
		String url = getBusUrl(param);
		String str = restTemplate.getForEntity(url, String.class).getBody();
		LOG.log(Level.INFO, "calling getAcceptSeria service");
        return str;
    }
	
	public String errorCall(Map<String,Object>param) {
		return "-9999";
	}
	private String getBusUrl(Map<String, Object> param) {
		String str = "http://BUSINESS-SERVICE/getAcceptSeria?client="+param.get("client")+"&certNo="+param.get("certNo");
		return str;
	}

}
