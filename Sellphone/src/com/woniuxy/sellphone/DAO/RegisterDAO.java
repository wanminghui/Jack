package com.woniuxy.sellphone.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//���ӵ����ݿ�Ĳ���
public class RegisterDAO {
	public static String toregister(String account,String password,Connection con) {
		String res="������ͬ�˻�ע��ʧ��";
		PreparedStatement state=null;
		int total=0;
		//���ӵ����ݿ�
		//׼��sql���
		String sql="INSERT INTO login(account,password) VALUE(?,?)";
		try {//׼��sql���
			state=con.prepareStatement(sql);
			state.setString(1, account);
			state.setString(2, password);
			total=state.executeUpdate();//���и��²���
			//System.out.println(total);
			if(total!=0) {
				res="ע��ɹ�,���½��";
				return res;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}
	
	public static boolean ifaccount(String account,Connection con) {
		PreparedStatement state=null;
		String sql="SELECT * FROM login WHERE account=?";
		boolean rest=false;
		ResultSet re=null;
		try {//׼��sql���
			state=con.prepareStatement(sql);
			state.setString(1,account);
			//���в�ѯ
			re=state.executeQuery();
			if(re.next()) {//�����д��˺�
				
				rest=true;
				return rest;
			}
			System.out.println(rest);
			//System.out.println(total);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rest;
	}

}
