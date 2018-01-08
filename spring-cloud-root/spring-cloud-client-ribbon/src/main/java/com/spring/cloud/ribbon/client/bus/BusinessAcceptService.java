package com.spring.cloud.ribbon.client.bus;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class BusinessAcceptService {
	@Autowired
    RestTemplate restTemplate;
	 @HystrixCommand(fallbackMethod = "errorCall")
    public String invok(Map<String,Object>param) {
		String url = getBusUrl(param);
		String str = restTemplate.getForEntity(url, String.class).getBody();
        return str;
    }
	public String errorCall(Map<String,Object>param) {
		return "ribbon:-BUSINESS-SERVICE不可用，请联系管理员";
	}
	private String getBusUrl(Map<String, Object> param) {
		String str = "http://BUSINESS-SERVICE/getSeria?client="+param.get("client")+"&certNo="+param.get("certNo");
		return str;
	}

}
