package com.woniuxy.sellphone.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.fabric.ShardingType;
import com.sun.xml.internal.ws.policy.privateutil.RuntimePolicyUtilsException;
import com.woniuxy.sellphone.service.RLservice;

import cn.dsna.util.images.ValidateCode;

/**
 * Servlet implementation class Userservlet
 */
public class Userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置显示的格式
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//设置回应页面显示的
		response.setContentType("html/text");
		//获取页面信息
	
      String  account= request.getParameter("account");
      String  password=request.getParameter("pass");
      String  piccode=request.getParameter("checkpicture");
      //获取真实的验证码只，不传参相当于ture,这里取得的验证码是object类型的
      Object truepic=request.getSession().getAttribute("pic");
      
      //转化本来页面上的验证码为string类型的
      String truepiccode=(String) truepic;
      RLservice sLservice=new RLservice();
      String re=sLservice.check(account, password,truepiccode,piccode);
      System.out.println(re);
       //System.out.println(account+password+"  "+truepiccode);
      // Map<String, Object>result = new HashMap<>();
       //result.put("mes", re);
      if(re.equals("登陆成功！")) {
    	  //登陆成功存用户的账号存在session中
    	 HttpSession session= request.getSession();
    	  session.setAttribute("account", account);
    	  int lid=RLservice.findLidByaccount(account);
          session.setAttribute("lid", lid);
      }
       ObjectMapper om=new ObjectMapper();
       //通过传的流响应给客户端
       om.writeValue(response.getOutputStream(), re);//第一个是响应流，第二个是需要转的对象
     
        
       
       
		
		
	}

}
