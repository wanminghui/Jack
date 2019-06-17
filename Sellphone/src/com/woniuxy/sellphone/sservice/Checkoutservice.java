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
		String result="����ʧ��";
		if(obj==null|| olid==null) {
			return result;
		}
		//ת����ȥ
		Map<String,vi_knowpo>cart=(Map<String,vi_knowpo>)obj;
		//�������ݿ�
	
		Connection con=C3P0util.getConnection();
	
	
		//�õ����ﳵ���ݣ���������
		Collection<vi_knowpo> cartpo=cart.values();
		//����һ������
		goodsDAO goodsDAO=new goodsDAO();
		int totalprice=0;
		for (vi_knowpo po : cartpo) {
			//ͨ����Ʒid���ҳ���Ʒ�ļ۸�
			goodsPO po1=goodsDAO.findpricebyID(con,po.getGoodID());
			//�õ���Ʒ���ܼ�
			totalprice+=po1.getPrice()*po.getNumber();		
		
		}
		//
		String lid=(String) olid;
		//ͨ��session�е�accountȥ���û��Ľ�Ǯ
	      int getprice=goodsDAO.getpriceByacc(con, lid);
		 
		//System.out.println(totalprice);
		//System.out.println(lid);
	      //�û���Ǯ��ȥ������Ǯ����ʣ�����
	      int balance=getprice-totalprice;
	      //���û���Ǯ������ʱ��
	      if(balance<0) {
	    	  result="�㵱ǰ�����Ϊ"+getprice+"��Ʒ�ܼ�Ϊ"+totalprice+"����ʧ�ܣ����㣡";
	    	  try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				 
				e.printStackTrace();
			}
	    	  C3P0util.close(con);
	    	  return result;
	    	  
	      }
	    //�۽��
	     boolean re=goodsDAO.updatemoney(con,totalprice,lid);
	      if(re) {
	    	  result="�����Ʒ����ɹ���������Ϊ"+totalprice+"Ԫ"+"���Ϊ"+ balance;
	    	  //System.out.println(result);
	    	  //���ؽ��
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
