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
		// ������ʱ��
		System.out.println("session����");
		int sum=0;
		//����application����,��ΪӦ�ò㼶�����
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
		System.out.println("session����");
		
		
	}

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("request����");
	}

	@Override
	public void requestInitialized(ServletRequestEvent sre) {
		// TODO Auto-generated method stub
		
	}

}
