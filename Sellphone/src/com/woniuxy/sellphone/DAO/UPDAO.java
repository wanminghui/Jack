package com.woniuxy.sellphone.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UPDAO {

	

	public String tofindacc(Connection con, String account) {
		
		String result="���˺ţ�";
		PreparedStatement state=null;
		ResultSet res=null;
			//�����˺�
		//׼��sql���
		String sql="SELECT * FROM login WHERE account=?";
		try {
			state=con.prepareStatement(sql);
			state.setString(1, account);
			res=state.executeQuery();
			if(res.next()) {
				//��ѯ����ֵ�Ļ�
				result="���ڴ��˻���";
				//System.out.println(result);
				return result;
				
				
			}
			else {
				result="�����ڴ��˻��������������˺ţ�";
				//System.out.println(result);
				return result;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}

	public String toupdatepassword(String account, String upassword,Connection con) {
	       String result="�޸�����ʧ��";
	       PreparedStatement state=null;
	       int num=0;
	     //׼��sql���
	       String sql="UPDATE login SET password=? WHERE account=?";
	       try {
			state=con.prepareStatement(sql);
			state.setString(1, upassword);
			state.setString(2, account);
			num=state.executeUpdate();//���и��²���
			if (num>0) {
				result="�����޸ĳɹ�!�����µ�½��";
				return result;
			} else {
                   result="�������ʧ�ܣ�";
                   return result;
			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
	       
	          
		// �޸�����ķ�����
		return result;
	}

	public String tocheckpass(Connection con, String password, String account) {
		// �ж�����������Ƿ����
		String presult=null;
		PreparedStatement state=null;
		ResultSet res=null;
			//�����˺�
		//׼��sql���
		String sql="SELECT * FROM login WHERE account=? AND password=?";
		try {
			state=con.prepareStatement(sql);
			state.setString(1, account);
			state.setString(2, password);
			res=state.executeQuery();
			if(res.next()) {
				//��ѯ����ֵ�Ļ�
				presult="������ȷ";
				//System.out.println(result);
				return presult;
				
				
			}
			else {
				presult="��������������";
				//System.out.println(result);
				return presult;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return presult;
		
	}

}
