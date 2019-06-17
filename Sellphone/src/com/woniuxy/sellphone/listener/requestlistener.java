package com.woniuxy.sellphone.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.SessionListener;

public class requestlistener implements ServletRequestListener,HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// 创建的时候
		System.out.println("session创建");
		int sum=0;
		//创建application对象,因为应用层级别最大
		ServletContext application = se.getSession().getServletContext();
		Object obj=application.getAttribute("count");
		if(obj != null) {
			sum=(int) obj;
		}
		++sum;
		application.setAttribute("count",sum);
		System.out.println(sum);
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session销毁");
		
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("request销毁");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

}
