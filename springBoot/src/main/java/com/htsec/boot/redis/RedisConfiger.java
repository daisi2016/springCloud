package com.htsec.boot.redis;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;
@Configuration
public class RedisConfiger {
	  	@Bean  
	    @ConfigurationProperties(prefix="spring.redis")  
	    public JedisPoolConfig getRedisConfig(){  
	        JedisPoolConfig config = new JedisPoolConfig();  
	        return config;  
	    }  
	      
	    @Bean 
	    @ConfigurationProperties(prefix="spring.redis")  
	    public JedisConnectionFactory getConnectionFactory(){  
	        JedisConnectionFactory factory = new JedisConnectionFactory();  
	        JedisPoolConfig config = getRedisConfig();  
	        factory.setPoolConfig(config);  
	        return factory;  
	    }  
	      
	    @Bean(name="redisTemplate") 
	    public RedisTemplate<String, Object> getRedisTemplate(){  
	    	RedisTemplate<String, Object> template = new RedisTemplate<String, Object>(); 
	    	template.setConnectionFactory(getConnectionFactory());
	        return template;  
	    }
	    @Bean(name="stringTemplate") 
	    public StringRedisTemplate getStringRedisTemplate(){  
	    	StringRedisTemplate template = new StringRedisTemplate(getConnectionFactory());  
	        return template;  
	    }
	

}
