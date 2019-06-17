package com.woniuxy.sellphone.util;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

public class EhcacheUtil {
	public static Cache cache=null;
	static{
		//缓存管理器:管理缓存对象的生命周期
		CacheManager manager=CacheManager.create();
		//创建缓存对象
		cache=new Cache("woniushop", 0, false, false, 0, 0);
		//对缓存进行配置
		CacheConfiguration config=cache.getCacheConfiguration();
		//设置内存缓存最大元素个数
		config.setMaxElementsInMemory(120);
		//设置缓存元素是否永久有效
		config.setEternal(false);
		//设置缓存元素的最大闲置时间
		config.setTimeToIdleSeconds(120);
		//设置缓存元素最长存活时间
		config.setTimeToLiveSeconds(300);
		//当内存中缓存元素达到最大设置数量时，是否使用硬盘缓存
		config.overflowToDisk(true);
		//设置硬盘缓存元素最大个数
		config.setMaxElementsOnDisk(300);
		//设置线程检查间隔时间
		config.setDiskExpiryThreadIntervalSeconds(120);
		//设置缓存清理策略
		config.memoryStoreEvictionPolicy("LRU");
		//将缓存对象交给缓存管理器统一管理
		manager.addCache(cache);
	}
	public static void save(String key,Object value){
		if(key != null && value != null){
			Element ele=new Element(key, value);
			cache.put(ele);
		}
	}
	public static Object get(String key){
		Object obj=null;
		if(key != null){
			Element ele=cache.get(key);
			if(ele != null){
				obj=ele.getObjectValue();
			}
		}
		return obj;
	}
}
