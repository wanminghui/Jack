package com.woniuxy.sellphone.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.woniuxy.sellphone.DAO.UPDAO;
import com.woniuxy.sellphone.util.C3P0util;

public class updateservice {

	public String toupdata(String account,String password,String upassword) {
		
		// ����һ����������ķ���
	 String	result="�������ʧ��";
	 //���ӵ����ݿ�
	 Connection con=C3P0util.getConnection();
	 //�����˻��治����
	 UPDAO upda=new UPDAO();
	result = upda.tofindacc(con,account);
	
	//ȥ�ж�����������Ƿ�ɹ���
	String Presult=upda.tocheckpass(con,password,account);
     
	  //���жϴ����û���ʱ��ʼ��������
	  if(result.equals("���ڴ��˻���")&&Presult.equals("������ȷ")) {
		  //�õ��޸ĺ�õ������
		  result=upda.toupdatepassword(account,upassword,con);
		  //System.out.println(result);	  
	  }
	  else {
		result="��������ʧ����˶���������˻������Ƿ���ȷ";
		
		//System.out.println(result);
	}
	 
	 
	
	 try {
		con.close();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	 
		return result;
	}
	

}
