package com.woniuxy.sellphone.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.woniuxy.sellphone.DAO.LoginDAO;
import com.woniuxy.sellphone.DAO.RegisterDAO;
import com.woniuxy.sellphone.util.C3P0util;
import com.woniuxy.sellphone.util.MD5_Encoding;
import com.woniuxy.sellphone.util.RegexUtil;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

public class RLservice {

	public static String check(String account,String pass,String truepiccode ,String piccode) {
		String result="��½ʧ��";
		//���Ƚ��зǿ��ж�
		if(account==null||pass==null) {
			result="�˺Ż�������Ϊ�գ���������Ч���ݣ�";
		    return result;
		}
		else if(piccode==null) {//��֤��Ϊ�յ�ʱ��
			result="��֤��Ϊ�գ���������֤�룡";
			return result;
		}
		else if(!account.matches(RegexUtil.REGEX_MOBILE)) {
			result="��������ֻ�������������11λ��Ч���ֻ����룡";
			return result;
		}
		else if(!truepiccode.equalsIgnoreCase(piccode)) {
			result="��֤������������������֤�룡";
			return result;
		}
		else {
		//�ٽ���ֵ���ж�
		//�������ݿ⣬�����ݿ���ȥ��ֵ
       Connection con=C3P0util.getConnection();
      
       LoginDAO login=new LoginDAO();
       //���ò�����ʵ������ķ���,���ҵ���ֵ����result
     result=login.findrealPass(account, con);
      if(result==null) {
    	  result="�˺Ų����ڣ����������벢ע��";
    	  return result;
      }	else {
		//�˺Ŵ��ڣ����벻��
    	  if(!result.equals(pass)) {
    		  result="������󣡵�½ʧ�ܣ�";
    		  return result;
    				
    	  }
    	  else if (result.equals(pass)) {
    		  result="��½�ɹ���";
    		  
    		  
    		  
    		  return result;
			
		}
	}
      try {
  		con.close();
  	} catch (SQLException e) {
  		
  		e.printStackTrace();
  	}
		}
		
		
		return result;
	}

	public String insertAccount(String account, String password, String truepiccode) {
		String Rresult="ע��ʧ��";
		//���зǿ��ж�
		if(account==null||password==null) {
			Rresult="�˺Ż�������Ϊ�գ���������Ч���ݣ�";
		    return Rresult;
		}
		else if(truepiccode==null) {//��֤��Ϊ�յ�ʱ��
			Rresult="��֤��Ϊ�գ���������֤�룡";
			return Rresult;
		}
		else if(!account.matches(RegexUtil.REGEX_MOBILE)) {
			Rresult=",��½ʧ�ܣ�������11λ��Ч���ֻ����룡";
			return Rresult;
		}
		else if(!truepiccode.equalsIgnoreCase(truepiccode)) {
			Rresult="��֤������������������֤�룡";
			return Rresult;
		}
		
		else {
			//����������ʱ���������ݿ���в���
		//ע���жϣ����ӵ����ݿ�
		Connection con=C3P0util.getConnection();
		//����DAO�Ķ���
		RegisterDAO reg=new RegisterDAO();
		//�ж��Ƿ������ͬ���˺ŵ�ʱ��
		if(reg.ifaccount(account, con)) {//�õ�һ��bool������ͬ�˺�
			
			Rresult="������ͬ���˺ţ�������ע��";
			return Rresult;
			
		}

		//����ע��ķ���
		Rresult=reg.toregister(account, password,con);
		//�ر����ӳأ��ͷ���Դ
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		}
		
		
		return Rresult;
	}

	public static int findLidByaccount(String account) {
		if(account==null) {
			return 0;
		}
		int lid=0;
		Connection con=C3P0util.getConnection();
		LoginDAO loginDAO=new LoginDAO();
	    lid=loginDAO.findpassByaccount(account,con);
		try {
			con.close();
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		return lid;
	}
}
