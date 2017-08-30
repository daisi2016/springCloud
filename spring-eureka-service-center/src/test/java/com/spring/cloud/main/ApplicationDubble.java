package com.spring.cloud.main;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ApplicationDubble {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ApplicationDubble.class).web(true).run(args);
	}
}
