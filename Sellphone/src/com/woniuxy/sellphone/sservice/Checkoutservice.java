package com.woniuxy.sellphone.sservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Map;

import com.woniuxy.sellphone.DAO.goodsDAO;
import com.woniuxy.sellphone.DAO.po.goodsPO;
import com.woniuxy.sellphone.DAO.po.vi_knowpo;
import com.woniuxy.sellphone.util.C3P0util;

import sun.security.krb5.internal.crypto.Crc32CksumType;

public class Checkoutservice {

	public String checkout(Object obj,Object olid) {
		String result="结账失败";
		if(obj==null|| olid==null) {
			return result;
		}
		//转换回去
		Map<String,vi_knowpo>cart=(Map<String,vi_knowpo>)obj;
		//连接数据库
	
		Connection con=C3P0util.getConnection();
	
	
		//得到购物车数据，遍历集合
		Collection<vi_knowpo> cartpo=cart.values();
		//创建一个对象
		goodsDAO goodsDAO=new goodsDAO();
		int totalprice=0;
		for (vi_knowpo po : cartpo) {
			//通过商品id查找出商品的价格
			goodsPO po1=goodsDAO.findpricebyID(con,po.getGoodID());
			//得到商品的总价
			totalprice+=po1.getPrice()*po.getNumber();		
		
		}
		//
		String lid=(String) olid;
		//通过session中的account去找用户的金钱
	      int getprice=goodsDAO.getpriceByacc(con, lid);
		 
		//System.out.println(totalprice);
		//System.out.println(lid);
	      //用户的钱减去买东西的钱，还剩的余额
	      int balance=getprice-totalprice;
	      //当用户的钱不够的时候
	      if(balance<0) {
	    	  result="你当前的余额为"+getprice+"商品总价为"+totalprice+"购买失败，余额不足！";
	    	  try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
	    	  C3P0util.close(con);
	    	  return result;
	    	  
	      }
	    //扣金额
	     boolean re=goodsDAO.updatemoney(con,totalprice,lid);
	      if(re) {
	    	  result="你好商品购买成功，你消费为"+totalprice+"元"+"余额为"+ balance;
	    	  //System.out.println(result);
	    	  //返回结果
	    	    return result;
	      }
	      
	      try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
		return result;
	}

}
