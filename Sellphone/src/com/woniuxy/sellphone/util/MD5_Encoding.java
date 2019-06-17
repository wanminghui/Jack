package com.woniuxy.sellphone.util;



	import java.math.BigInteger;
	import java.security.MessageDigest;

	/*******************************************************************************
	 * 
	 * 
	 * MD5����
	 */

	public class MD5_Encoding {

		/**
	     * ���ַ���md5����(Сд+����) 
	     * 
	     * @param str ����Ҫ���ܵ��ַ��� 
	     * @return  MD5���ܺ���ַ��� 
	     */ 
	    public static String lowerMD5(String str) {
	        try {
	            // ����һ��MD5���ܼ���ժҪ
	            MessageDigest md = MessageDigest.getInstance("MD5");
	            // ����md5����
	            md.update(str.getBytes());
	            // digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ� 
	            // BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
	            return new BigInteger(1, md.digest()).toString(16);
	        } catch (Exception e) {
	           e.printStackTrace();
	           return null;
	        }
	    }
	      
	      
	    /**
	     * ���ַ���md5����(��д+����)
	     *
	     * @param str ����Ҫ���ܵ��ַ���
	     * @return  MD5���ܺ���ַ���
	     */ 
	      
	    public static String upperMD5(String s) {
	        char hexDigits[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	  
	        try {
	            byte[] btInput = s.getBytes();
	            // ���MD5ժҪ�㷨�� MessageDigest ����
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	            // ʹ��ָ�����ֽڸ���ժҪ
	            mdInst.update(btInput);
	            // �������
	            byte[] md = mdInst.digest();
	            // ������ת����ʮ�����Ƶ��ַ�����ʽ
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public static void main(String[] args) {
			System.out.println(upperMD5("13213123"));
			System.out.println(lowerMD5("ad123467"));
		}
}
