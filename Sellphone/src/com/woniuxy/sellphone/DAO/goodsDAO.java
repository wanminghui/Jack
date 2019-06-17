package com.woniuxy.sellphone.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.State;
import com.sun.org.apache.bcel.internal.generic.Select;
import com.woniuxy.sellphone.DAO.po.goodsPO;

import jdk.internal.dynalink.linker.GuardedTypeConversion;

public class goodsDAO {

	public List<goodsPO> findgoodbypage(int index, Connection con, int goodtypeid) {
		//׼�����
		String sql="SELECT goodID,goodname,price,picture,describute FROM goods WHERE ?=1 AND flag=0 LIMIT ?,4;";
		PreparedStatement state=null;
		ResultSet res=null;
		//����һ������
		List<goodsPO>goods=new ArrayList<>();
		try {
			//ִ��sql���  
			
			state=con.prepareStatement(sql);
			state.setInt(1, goodtypeid);
			state.setInt(2, index);
		    res=state.executeQuery();
		    while(res.next()) {
		    	//������е�ֵȡ��������po��
		    	goodsPO po=new goodsPO();
		        po.setGoodID(res.getInt("goodID"));
		        po.setGoodname(res.getString("goodname"));
		        po.setPrice(res.getInt("price"));
		        po.setPicture(res.getString("picture"));
		        po.setDescribute(res.getString("describute"));
		        //���ֵ���뵽������
		    	goods.add(po);
		    }
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		//���й�����
		//������
		return goods;
	}

	public List<goodsPO> findgoodbyid(Connection con, String gid) {
	//׼��sql���
		String sql="SELECT goodname,price,picture,describute FROM goods WHERE goodID=? AND flag=0";
		PreparedStatement state=null;
		ResultSet res=null;
		//����һ������
		List<goodsPO>goods=new ArrayList<>();
		//ִ��sql���
		try {
			//����Ԥ����
			state=con.prepareStatement(sql);
			state.setString(1, gid);
			res=state.executeQuery();//���в�ѯ����Ĵ���
			  while(res.next()) {
			    	//������е�ֵȡ��������po��
			    	goodsPO po=new goodsPO();
			        po.setGoodname(res.getString("goodname"));
			        po.setPrice(res.getInt("price"));
			        po.setPicture(res.getString("picture"));
			        po.setDescribute(res.getString("describute"));
			        //���ֵ���뵽������
			    	goods.add(po);
			    }
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return goods;
	}

	public goodsPO findpricebyID(Connection con, String goodID) {
		goodsPO po=new goodsPO();
		PreparedStatement state=null;
		ResultSet res=null;
		//׼��sql���
		String sql="SELECT price FROM goods WHERE goodID=?";
		//Ԥ����
		try {
			state=con.prepareStatement(sql);
			state.setString(1, goodID);
			res=state.executeQuery();
			if(res.next()) {
				po.setPrice(res.getInt("price"));
				
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		//ִ��
		return po;
	}

	public int getpriceByacc(Connection con, String lid) {
		int getprice=0;
		PreparedStatement state=null;
		ResultSet res=null;
		//׼��sql���
		String sql="SELECT money FROM userinfo WHERE name=? AND flag=0";
		//Ԥ����
		try {
			state=con.prepareStatement(sql);
			state.setString(1, lid);
			res=state.executeQuery();
			if(res.next()) {
				getprice=res.getInt("money");				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		//System.out.println(getprice);
		//ִ��
		//�����û��Ľ�Ǯ
		return getprice;
	}

	public boolean updatemoney(Connection con, int totalprice, String lid) {
		//���п����Ĳ�����
		System.out.println("����updata*********");
		boolean res=false;
		PreparedStatement state=null;
		
		//׼��sql���
		String sql="UPDATE userinfo SET money=money-? WHERE name=?";
		//Ԥ����
		try {
			state=con.prepareStatement(sql);
			state.setInt(1,totalprice);
			state.setString(2, lid);
			int test=state.executeUpdate();
			//System.out.println("�����˱���");
			if(test>0) {
				res=true;
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		System.out.println(res);
		
		
		return res;
	}

}
