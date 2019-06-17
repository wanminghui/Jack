package com.woniuxy.sellphone.util;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.dsna.util.images.ValidateCode;


public class picturesevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
 @Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	 ValidateCode vi=new ValidateCode(250, 60, 4, 120);
	 //设置键值对
	 req.getSession().setAttribute("pic", vi.getCode());
	 // req.setAttribute("pic", vi.getCode());
	 //写出
	  vi.write(resp.getOutputStream());
}
	 
}
