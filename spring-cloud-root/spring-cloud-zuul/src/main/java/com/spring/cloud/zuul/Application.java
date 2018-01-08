package com.spring.cloud.zuul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.spring.cloud.zuul.filter.AccessFilter;
@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class Application {
	
	@Bean
	public AccessFilter accessFilter() {
		return new AccessFilter();
	}
	
	public static void main(String[] args) {
		new SpringApplicationBuilder(Application.class).web(true).run(args);
	}

}
