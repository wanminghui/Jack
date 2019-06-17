package com.woniuxy.sellphone.servlet;

import java.io.IOException;
import java.io.StringReader;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.org.apache.regexp.internal.REUtil;
import com.woniuxy.sellphone.DAO.po.vi_knowpo;
import com.woniuxy.sellphone.service.cartService;
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取到页面传参
		//获得请求处理的类型
		String oper=request.getParameter("oper");
		//获得请求中的sessi
		HttpSession session=request.getSession();		
		//设置一个集合得到键为cart的session
		Object obj=session.getAttribute("cart");
		Map<String,vi_knowpo >cart=null;
		//接收返回值,存到session中
		Object result=null;
		if(obj==null) {
			cart=new HashMap<String,vi_knowpo>();
			session.setAttribute("cart", cart);
		}
		else {
			cart=(Map<String,vi_knowpo>)obj;
		}
		if(oper.equals("update")) {
			result=updatecart(request,cart);
			
			//得到登陆成功时候的用户登录ID
			session.setAttribute("cart",cart);
			//System.out.println(cart.get("7"));
			
		
		
		}else if (oper.equals("delete")) {
			result=deleteCart(request,cart);
		}
		else if (oper.equals("show")) {
			//直接得session中的值
		//创建一个collection来存值
		Collection<vi_knowpo> coll= cart.values();
		result=coll;					
		}
		//响应给客户端
		ObjectMapper om=new ObjectMapper();
		om.writeValue(response.getOutputStream(), result);
			 
	}
	
	private Object deleteCart(HttpServletRequest request, Map<String, vi_knowpo> cart) {
		// TODO Auto-generated method stub
		return null;
	}

	private String updatecart(HttpServletRequest request, Map<String, vi_knowpo> cart) {
		String img=request.getParameter("picture");
		String name=request.getParameter("goodname");	
		String number=request.getParameter("number");
		String price=request.getParameter("price");
		//商品id
		String gid=request.getParameter("gid");		
		cartService cartService=new cartService();
		 String result= cartService.update(img,name,price,number,gid,cart);
		 System.out.println(number);
		System.out.println(result+"***********");
		return result;
	}

}
