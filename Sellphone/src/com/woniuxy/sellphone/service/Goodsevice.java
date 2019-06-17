package com.woniuxy.sellphone.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.woniuxy.sellphone.DAO.goodsDAO;
import com.woniuxy.sellphone.DAO.po.goodsPO;
import com.woniuxy.sellphone.util.C3P0util;

public class Goodsevice {

	public List<goodsPO> showGoodsByPage(String ppage, String pgoodtypeid) {
		//非空判断
		if(ppage==null||pgoodtypeid==null) {
			return new ArrayList<goodsPO>();
					
		}
		//有效性检查
		int page=0;
		int goodtypeid=0;
		try {
			page=Integer.parseInt(ppage);
		    goodtypeid=Integer.parseInt(pgoodtypeid);
		} catch (Exception e) {
			return new ArrayList<goodsPO>();
		}
		int index=0;
		index=(page-1)*4;
		//连接数据库
		Connection con=C3P0util.getConnection();
		goodsDAO gdao=new goodsDAO();
	 List<goodsPO> goods=gdao.findgoodbypage(index,con,goodtypeid);
		//释放资源
	C3P0util.close(con);
		return goods;
	}

	
	
	public List<goodsPO> findgoodbygoodid(String gid) {
		
		//非空判断 
				if(gid==null) {
					return new ArrayList<goodsPO>();
							
				}
	//连接数据库
				Connection con=C3P0util.getConnection();
				goodsDAO gdao=new goodsDAO();
				List<goodsPO>goods=gdao.findgoodbyid(con,gid);			
				
				try {
					con.close();
				} catch (SQLException e) {
					 
					e.printStackTrace();
				}
		  
		return goods;
	}

	
	
}
