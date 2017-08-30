package com.htsec.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.htsec.boot.redis.IRedisDao;

@RestController
@RequestMapping("/redis")
public class RedisController {
	@Autowired
	@Qualifier(value="redisDaoImpl")
	IRedisDao service;

	@RequestMapping(value = "/keys", method = RequestMethod.GET)
	public String get() {
		service.setStr("test1", "test1");
		String str = service.getStr("test1");
		System.out.println(str);
		return str;
	}

}
