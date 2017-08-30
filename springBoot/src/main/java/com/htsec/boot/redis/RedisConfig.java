package com.htsec.boot.redis;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;
@Configuration
public class RedisConfig {/*
	@Value("${spring.redis.hostName}")
	private String hostName;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.redis.password}")
	private String password;
	@Value("${spring.redis.pool.maxActive}")
	private int maxActive;
	@Value("${spring.redis.pool.maxWait}")
	private int maxWait; 
	@Value("${spring.redis.pool.maxIdle}")
	private int maxIdle;
	@Value("${spring.redis.pool.minIdle}")
	private int minIdle;
	@Value("${spring.redis.timeout}")
	private int timeout;
	
	
	
	@Bean  
    public JedisPoolConfig getRedisConfig(){  
        JedisPoolConfig config = new JedisPoolConfig();  
        config.setMaxTotal(maxActive);
        config.setMinIdle(minIdle);
        config.setMaxIdle(maxIdle);
        config.setMaxWaitMillis(maxWait);
        return config;  
    }  
      
    @Bean  
    public JedisConnectionFactory getConnectionFactory(){  
        JedisConnectionFactory factory = new JedisConnectionFactory();  
        factory.setHostName(hostName);
        factory.setPort(port);
        factory.setPassword(password);
        JedisPoolConfig config = getRedisConfig();  
        factory.setPoolConfig(config);  
        return factory;  
    }  
      
      
    @Bean(name="redisTemplate") 
    public RedisTemplate<String, Object> getRedisTemplate(){  
    	RedisTemplate<String, Object> template = new RedisTemplate(); 
    	template.setConnectionFactory(getConnectionFactory());
        return template;  
    }
    @Bean(name="stringTemplate") 
    public StringRedisTemplate getStringRedisTemplate(){  
    	StringRedisTemplate template = new StringRedisTemplate(getConnectionFactory());  
        return template;  
    }
	

*/}
