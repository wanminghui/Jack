package com.woniuxy.sellphone.util;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;

public class EhcacheUtil {
	public static Cache cache=null;
	static{
		//���������:������������������
		CacheManager manager=CacheManager.create();
		//�����������
		cache=new Cache("woniushop", 0, false, false, 0, 0);
		//�Ի����������
		CacheConfiguration config=cache.getCacheConfiguration();
		//�����ڴ滺�����Ԫ�ظ���
		config.setMaxElementsInMemory(120);
		//���û���Ԫ���Ƿ�������Ч
		config.setEternal(false);
		//���û���Ԫ�ص��������ʱ��
		config.setTimeToIdleSeconds(120);
		//���û���Ԫ������ʱ��
		config.setTimeToLiveSeconds(300);
		//���ڴ��л���Ԫ�شﵽ�����������ʱ���Ƿ�ʹ��Ӳ�̻���
		config.overflowToDisk(true);
		//����Ӳ�̻���Ԫ��������
		config.setMaxElementsOnDisk(300);
		//�����̼߳����ʱ��
		config.setDiskExpiryThreadIntervalSeconds(120);
		//���û����������
		config.memoryStoreEvictionPolicy("LRU");
		//��������󽻸����������ͳһ����
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
