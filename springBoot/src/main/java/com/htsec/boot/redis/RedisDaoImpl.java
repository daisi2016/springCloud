package com.htsec.boot.redis;
 
	import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

	 @Service(value="redisDaoImpl")
	public class RedisDaoImpl implements IRedisDao {
		 @Autowired
		@Qualifier("stringTemplate")
		private  StringRedisTemplate stringRedisTemplate;
		 @Autowired
		 @Qualifier("redisTemplate")
		private  RedisTemplate<String, Object> redisTemplate;
			
		/**
		 * 删除缓存<br>
		 * 根据key精确匹配删除
		 * @param key
		 */
		@SuppressWarnings("unchecked")
		public  void del(String... key){
			if(key!=null && key.length > 0){
				if(key.length == 1){
					redisTemplate.delete(key[0]);
				}else{
					redisTemplate.delete(CollectionUtils.arrayToList(key));				
				}
			}
		}
		
		/**
		 * 批量删除<br>
		 * （该操作会执行模糊查询，请尽量不要使用，以免影响性能或误删）
		 * @param pattern
		 */	
		@Deprecated
		public  void delBatch(String... pattern){
			for (String kp : pattern) {
				redisTemplate.delete(redisTemplate.keys(kp + "*"));
			}
		}
		
		/**
		 * 取得缓存（字符串类型）
		 * @param key
		 * @return
		 */
		public  String getStr(String key){
			return stringRedisTemplate.boundValueOps(key).get();
		}

		/**
		 * 取得缓存（字符串类型）
		 * @param key
		 * @return
		 */
		public  void setStr(String key,String value){
			 stringRedisTemplate.opsForValue().set(key, value);
		}
		/**
		 * 取得缓存（字符串类型）
		 * @param key
		 * @return
		 */
		public  void setStr(String key,String value,int time){
			if(time > 0){
			 stringRedisTemplate.opsForValue().set(key, value,time,TimeUnit.SECONDS);
			}
		}
		
		/**
		 * 取得缓存（字符串类型）
		 * @param key
		 * @return
		 */
		public  String getStr(String key, boolean delete){
			String value = stringRedisTemplate.boundValueOps(key).get();
			if(delete){
				stringRedisTemplate.delete(key);
			}
			return value;
		}
		
		/**
		 * 获取缓存<br>
		 * 注：基本数据类型(Character除外)，请直接使用get(String key, Class<T> clazz)取值
		 * @param key
		 * @return
		 */
		public  Object getObj(String key){
			return redisTemplate.boundValueOps(key).get();
		}
		
		/**
		 * 获取缓存<br>
		 * 注：java 8种基本类型的数据请直接使用get(String key, Class<T> clazz)取值
		 * @param key		
		 * @param retain	是否保留
		 * @return
		 */
		public  Object getObj(String key, boolean delete){
			Object obj = redisTemplate.boundValueOps(key).get();
			if(delete){
				redisTemplate.delete(key);
			}
			return obj;
		}
		
		/**
		 * 获取缓存<br>
		 * 注：该方法暂不支持Character数据类型
		 * @param key	key
		 * @param clazz	类型
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public  <T> T get(String key, Class<T> clazz) {
			return (T)redisTemplate.boundValueOps(key).get();
		}
		
		
		/**
		 * 将value对象写入缓存
		 * @param key
		 * @param value
		 * @param time 失效时间(秒)
		 */
		public  void set(String key,Object value,int time){
			redisTemplate.opsForValue().set(key, value);			
			if(time > 0){
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
		}
		
		/**
		 * 将value对象写入缓存
		 * @param key
		 * @param value
		 */
		public  void set(String key,Object value){
			redisTemplate.opsForValue().set(key, value);			
		}
		
		/**
		 * 递减操作
		 * @param key
		 * @param by
		 * @return
		 */
		public  double decr(String key, double by){
			return redisTemplate.opsForValue().increment(key, -by);
		}
		
		/**
		 * 递增操作
		 * @param key
		 * @param by
		 * @return
		 */
		public  double incr(String key, double by){
			return redisTemplate.opsForValue().increment(key, by);
		}
		 
		
		/**
		 * 将map写入缓存
		 * @param key
		 * @param map
		 * @param time 失效时间(秒)
		 */
		public  <T> void setMap(String key, Map<String, T> map, int time){
			redisTemplate.opsForHash().putAll(key, map);
			if(time>0){
			redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
		}
		
		/**
		 * 向key对应的map中添加缓存对象
		 * @param key
		 * @param map
		 */
		public  <T> void setMap(String key, Map<String, T> map){
			redisTemplate.opsForHash().putAll(key, map);
		}
		/**
		 * 向key对应的map中添加缓存对象
		 * @param key	cache对象key
		 * @param field map对应的key
		 * @param obj 	对象
		 */
		public  <T> void setMap(String key, String field, T obj){
			redisTemplate.opsForHash().put(key, field, obj);
		}
		
		/**
		 * 获取map缓存
		 * @param key
		 * @param clazz
		 * @return
		 */
		public  <T> Map<String, T> getMap(String key, Class<T> clazz){
			BoundHashOperations<String, String, T> boundHashOperations = redisTemplate.boundHashOps(key); 
			return boundHashOperations.entries();
		}
		
		 
		
		/**
		 * 获取map缓存中的某个对象
		 * @param key
		 * @param field
		 * @param clazz
		 * @return
		 */
		@SuppressWarnings("unchecked")
		public  <T> T getMapField(String key, String field, Class<T> clazz){
			return (T)redisTemplate.boundHashOps(key).get(field);
			//			redisTemplate.opsForHash().get(arg0, arg1)
		}
		
		/**
		 * 删除map中的某个对象
		 * @date 2016年8月10日
		 * @param key	map对应的key
		 * @param field	map中该对象的key
		 */
		public void delMapField(String key, String... field){
			//BoundHashOperations<String, String, ?> boundHashOperations = redisTemplate.boundHashOps(key); 
			//boundHashOperations.delete(field);
			redisTemplate.opsForHash().delete(key, field);
		}
		
		/**
		 * 指定缓存的失效时间
		 * 
		 * @date 2016年8月14日
		 * @param key 缓存KEY
		 * @param time 失效时间(秒)
		 */
		public  void expire(String key, int time) {
			if(time > 0){
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
		}
		
		/**
		 * 添加set
		 * @param key
		 * @param value
		 */
		public <T> void addToSet(String key, T... value) {
			redisTemplate.opsForSet().add(key, value);
		}

		/**
		 * 删除set集合中的对象
		 * @param key
		 * @param value
		 */
		public  <T> void deleteToSet(String key, T... value) {
			redisTemplate.opsForSet().remove(key, value);
		}
		
		/**
		 * set重命名
		 * @param oldkey
		 * @param newkey
		 */
		public  void renameSet(String oldkey, String newkey){
			redisTemplate.boundSetOps(oldkey).rename(newkey);
		}
		
		/**
		 * 模糊查询keys
		 * @param pattern
		 * @return
		 */
		public  Set<String> keys(String pattern){
			return redisTemplate.keys(pattern);	
		}
		
	}

