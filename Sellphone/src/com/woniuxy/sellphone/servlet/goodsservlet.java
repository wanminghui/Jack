package com.woniuxy.sellphone.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.woniuxy.sellphone.DAO.po.goodsPO;
import com.woniuxy.sellphone.service.Goodsevice;

/**
 * Servlet implementation class goodsservlet
 */
public class goodsservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡҳ�洫��
		String page=request.getParameter("page");
		String oper= request.getParameter("oper");
		//ȡ����Ʒ��id
		String gid=request.getParameter("gid");
		//System.out.println(gid);
		if(oper==null) {
			return;
		}
		Object result=null;
		if(oper.equals("add")){
			//��ѯ
			result=showGoods(page,request,response);	
		} 
		if(oper.equals("sigle")) {//����չʾ��Ʒ����ϸ���ܵ�ʱ��
			result=findGoodBygid(gid, request, response);
			
		}
		
		//�����д����
		ObjectMapper om=new ObjectMapper();
	/*	Map<String, Object> x=null;
		x.put("pnum",page);
		x.put("res", result);*/
		//���д�ڿͻ���
		om.writeValue(response.getOutputStream(),result);
		//System.out.println(result);
	    
	}

	private Object showGoods(String page, HttpServletRequest request, HttpServletResponse response) {
		//��ȡҳ�洫��
	
	//�ֶ�����ֵΪ1
	String goodtypeid="1";
			//request.getParameter("goodtypeid");
	Goodsevice goodservice=new Goodsevice();
	List<goodsPO> goods=goodservice.showGoodsByPage(page,goodtypeid);
	//System.out.println(page);	
	//System.out.println(goods);
	return goods;
	}
	private Object findGoodBygid(String gid,HttpServletRequest request,HttpServletResponse response) {
		Goodsevice findgood=new Goodsevice();
		List<goodsPO> goods=findgood.findgoodbygoodid(gid);
		return goods;
		
		
	}

}
