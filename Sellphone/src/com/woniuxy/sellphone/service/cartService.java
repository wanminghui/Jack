package com.woniuxy.sellphone.service;

import java.util.Map;

import org.eclipse.jdt.internal.compiler.env.IGenericField;

import com.woniuxy.sellphone.DAO.po.vi_knowpo;

public class cartService {

	public String update(String pimg, String pname, String pprice,String pnumber, String pgid, Map<String, vi_knowpo> cart) {
		String result="购物车更新失败"; 
		//非空判断
		//System.out.println(pimg+pname+pprice+pgid+pnumber);
		if(pimg==null||pname==null||pprice==null||cart==null||pgid==null|| pnumber==null) {
			return result;
		}
		//数据格式检查
		if(pimg.length()<1 || pname.length()<1) {
			return result;
		}
		int price=0;
		int number=0;	
		int gid = 0;
		try {
			//封装转成对应的类型
			price=Integer.parseInt(pprice);
			number=Integer.parseInt(pnumber);
			gid=Integer.parseInt(pgid);
						
		} catch (Exception e) {
			
		}
	 //通过商品id查map中是否存在po
	 vi_knowpo po=cart.get(pgid);
	 if(po!=null) {
		//修改，修改po中的数量
		int total=po.getNumber()+1;
	    po.setNumber(total);
	    
		result="购物车数据添加成功！";
	}
	else {
		//不存在，则添加
		//检查修改的数量大于零，则创建po，存到map中
		/*if(number>0) {
			//int lid=(int)olid;
*/			
		cart.put(pgid,new vi_knowpo(pname, pimg,(gid+""),number,price));	
		result="购物车数据更新成功";
		}
		
	return result;	
	}
	
}
