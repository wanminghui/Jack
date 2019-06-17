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
		//准备语句
		String sql="SELECT goodID,goodname,price,picture,describute FROM goods WHERE ?=1 AND flag=0 LIMIT ?,4;";
		PreparedStatement state=null;
		ResultSet res=null;
		//创建一个数组
		List<goodsPO>goods=new ArrayList<>();
		try {
			//执行sql语句  
			
			state=con.prepareStatement(sql);
			state.setInt(1, goodtypeid);
			state.setInt(2, index);
		    res=state.executeQuery();
		    while(res.next()) {
		    	//将结果中的值取出来放在po中
		    	goodsPO po=new goodsPO();
		        po.setGoodID(res.getInt("goodID"));
		        po.setGoodname(res.getString("goodname"));
		        po.setPrice(res.getInt("price"));
		        po.setPicture(res.getString("picture"));
		        po.setDescribute(res.getString("describute"));
		        //最后将值加入到数组中
		    	goods.add(po);
		    }
			
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}
		
		//进行过编译
		//处理结果
		return goods;
	}

	public List<goodsPO> findgoodbyid(Connection con, String gid) {
	//准备sql语句
		String sql="SELECT goodname,price,picture,describute FROM goods WHERE goodID=? AND flag=0";
		PreparedStatement state=null;
		ResultSet res=null;
		//创建一个数组
		List<goodsPO>goods=new ArrayList<>();
		//执行sql语句
		try {
			//进行预编译
			state=con.prepareStatement(sql);
			state.setString(1, gid);
			res=state.executeQuery();//进行查询结果的储存
			  while(res.next()) {
			    	//将结果中的值取出来放在po中
			    	goodsPO po=new goodsPO();
			        po.setGoodname(res.getString("goodname"));
			        po.setPrice(res.getInt("price"));
			        po.setPicture(res.getString("picture"));
			        po.setDescribute(res.getString("describute"));
			        //最后将值加入到数组中
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
		//准备sql语句
		String sql="SELECT price FROM goods WHERE goodID=?";
		//预编译
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
		
		//执行
		return po;
	}

	public int getpriceByacc(Connection con, String lid) {
		int getprice=0;
		PreparedStatement state=null;
		ResultSet res=null;
		//准备sql语句
		String sql="SELECT money FROM userinfo WHERE name=? AND flag=0";
		//预编译
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
		//执行
		//返回用户的金钱
		return getprice;
	}

	public boolean updatemoney(Connection con, int totalprice, String lid) {
		//进行扣余额的操作！
		System.out.println("进入updata*********");
		boolean res=false;
		PreparedStatement state=null;
		
		//准备sql语句
		String sql="UPDATE userinfo SET money=money-? WHERE name=?";
		//预编译
		try {
			state=con.prepareStatement(sql);
			state.setInt(1,totalprice);
			state.setString(2, lid);
			int test=state.executeUpdate();
			//System.out.println("进行了编译");
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
