package com.woniuxy.sellphone.service;

import java.util.Map;

import org.eclipse.jdt.internal.compiler.env.IGenericField;

import com.woniuxy.sellphone.DAO.po.vi_knowpo;

public class cartService {

	public String update(String pimg, String pname, String pprice,String pnumber, String pgid, Map<String, vi_knowpo> cart) {
		String result="���ﳵ����ʧ��"; 
		//�ǿ��ж�
		//System.out.println(pimg+pname+pprice+pgid+pnumber);
		if(pimg==null||pname==null||pprice==null||cart==null||pgid==null|| pnumber==null) {
			return result;
		}
		//���ݸ�ʽ���
		if(pimg.length()<1 || pname.length()<1) {
			return result;
		}
		int price=0;
		int number=0;	
		int gid = 0;
		try {
			//��װת�ɶ�Ӧ������
			price=Integer.parseInt(pprice);
			number=Integer.parseInt(pnumber);
			gid=Integer.parseInt(pgid);
						
		} catch (Exception e) {
			
		}
	 //ͨ����Ʒid��map���Ƿ����po
	 vi_knowpo po=cart.get(pgid);
	 if(po!=null) {
		//�޸ģ��޸�po�е�����
		int total=po.getNumber()+1;
	    po.setNumber(total);
	    
		result="���ﳵ������ӳɹ���";
	}
	else {
		//�����ڣ������
		//����޸ĵ����������㣬�򴴽�po���浽map��
		/*if(number>0) {
			//int lid=(int)olid;
*/			
		cart.put(pgid,new vi_knowpo(pname, pimg,(gid+""),number,price));	
		result="���ﳵ���ݸ��³ɹ�";
		}
		
	return result;	
	}
	
}
