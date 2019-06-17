package com.woniuxy.sellphone.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
import com.woniuxy.sellphone.util.C3P0util;
import sun.security.krb5.internal.crypto.crc32;

public class LoginDAO {
	 //���������������ϵķ���
	public static String findrealPass(String  account,Connection con) {
		String realpass=null;
		PreparedStatement state=null;
		ResultSet res=null;
		//׼��sql���
		String sql="SELECT password FROM login WHERE account=?";
		//ִ��sql���
		try {
			state=con.prepareStatement(sql);
			state.setString(1,account);
			res=state.executeQuery();
			if(res.next()) {
				realpass=res.getString("password");
				return realpass;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return realpass;
	}

	public int findpassByaccount(String account, Connection con) {
		int lid=0;
		PreparedStatement state=null;
		ResultSet res=null;
		//׼��sql���
		String sql="SELECT loginID FROM login WHERE account=?";
		//ִ��sql���
		try {
			state=con.prepareStatement(sql);
			state.setString(1,account);
			res=state.executeQuery();
			if(res.next()) {
				lid=res.getInt("loginID");
				return lid;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lid;
	}
	
	

}
