package com.htsec.boot.redis;

import java.util.Map;
import java.util.Set;
 
public interface IRedisDao {
 
		
	/**
	 * 删除缓存<br>
	 * 根据key精确匹配删除
	 * @param key
	 */
	public  void del(String... key);
	
	/**
	 * 批量删除<br>
	 * （该操作会执行模糊查询，请尽量不要使用，以免影响性能或误删）
	 * @param pattern
	 */	
	@Deprecated
	public  void delBatch(String... pattern);
	
	/**
	 * 取得缓存（字符串类型）
	 * @param key
	 * @return
	 */
	public  String getStr(String key);

	/**
	 * 取得缓存（字符串类型）
	 * @param key
	 * @return
	 */
	public  void setStr(String key,String value);
	/**
	 * 取得缓存（字符串类型）
	 * @param key
	 * @return
	 */
	public  void setStr(String key,String value,int time);
	
	/**
	 * 取得缓存（字符串类型）
	 * @param key
	 * @return
	 */
	public  String getStr(String key, boolean delete);
	
	/**
	 * 获取缓存<br>
	 * 注：基本数据类型(Character除外)，请直接使用get(String key, Class<T> clazz)取值
	 * @param key
	 * @return
	 */
	public  Object getObj(String key);
	
	/**
	 * 获取缓存<br>
	 * 注：java 8种基本类型的数据请直接使用get(String key, Class<T> clazz)取值
	 * @param key		
	 * @param retain	是否保留
	 * @return
	 */
	public  Object getObj(String key, boolean delete);
	
	/**
	 * 获取缓存<br>
	 * 注：该方法暂不支持Character数据类型
	 * @param key	key
	 * @param clazz	类型
	 * @return
	 */
	public  <T> T get(String key, Class<T> clazz);
	
	/**
	 * 将value对象写入缓存
	 * @param key
	 * @param value
	 * @param time 失效时间(秒)
	 */
	public  void set(String key,Object value,int time);
	
	/**
	 * 将value对象写入缓存
	 * @param key
	 * @param value
	 */
	public  void set(String key,Object value);
	
	/**
	 * 递减操作
	 * @param key
	 * @param by
	 * @return
	 */
	public  double decr(String key, double by);
	
	/**
	 * 递增操作
	 * @param key
	 * @param by
	 * @return
	 */
	public  double incr(String key, double by);
	 
	
	/**
	 * 将map写入缓存
	 * @param key
	 * @param map
	 * @param time 失效时间(秒)
	 */
	public  <T> void setMap(String key, Map<String, T> map, int time);
	
	/**
	 * 向key对应的map中添加缓存对象
	 * @param key
	 * @param map
	 */
	public  <T> void setMap(String key, Map<String, T> map);
	/**
	 * 向key对应的map中添加缓存对象
	 * @param key	cache对象key
	 * @param field map对应的key
	 * @param obj 	对象
	 */
	public  <T> void setMap(String key, String field, T obj);
	/**
	 * 获取map缓存
	 * @param key
	 * @param clazz
	 * @return
	 */
	public  <T> Map<String, T> getMap(String key, Class<T> clazz);
	
	 
	
	/**
	 * 获取map缓存中的某个对象
	 * @param key
	 * @param field
	 * @param clazz
	 * @return
	 */
	public  <T> T getMapField(String key, String field, Class<T> clazz);
	
	/**
	 * 删除map中的某个对象
	 * @date 2016年8月10日
	 * @param key	map对应的key
	 * @param field	map中该对象的key
	 */
	public void delMapField(String key, String... field);
	
	/**
	 * 指定缓存的失效时间
	 * 
	 * @date 2016年8月14日
	 * @param key 缓存KEY
	 * @param time 失效时间(秒)
	 */
	public  void expire(String key, int time);
	
	/**
	 * 添加set
	 * @param key
	 * @param value
	 */
	public <T> void addToSet(String key, T... value);
	/**
	 * 删除set集合中的对象
	 * @param key
	 * @param value
	 */
	public  <T> void deleteToSet(String key, T... value) ;
	
	/**
	 * set重命名
	 * @param oldkey
	 * @param newkey
	 */
	public  void renameSet(String oldkey, String newkey);
	
	/**
	 * 模糊查询keys
	 * @param pattern
	 * @return
	 */
	public  Set<String> keys(String pattern);
	

}
