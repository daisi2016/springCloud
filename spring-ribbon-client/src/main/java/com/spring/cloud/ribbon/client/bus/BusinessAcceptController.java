package com.spring.cloud.ribbon.client.bus;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class BusinessAcceptController {
	@Autowired
	BusinessAcceptService service;
	
	@RequestMapping(value = "/getAcceptSeria", method = RequestMethod.GET)
    public String getAcceptSeria() {
		Map<String,Object>map = new HashMap<String,Object>();
		map.put("clent", "5");
		map.put("certNo", "530381198510015");
		String str = service.invok(map);
		return str;
    }

}
