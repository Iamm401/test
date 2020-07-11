package com.util;

import java.io.UnsupportedEncodingException;

public class StringUtils {
	public static boolean isEmpty(String str){
		if("".equals(str)|| str == null){
			return true;
		}
		return false;
	}
	
	public static String UFT8Decoding(String str) {
		try {
			return new String(str.getBytes("iso8859-1"),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
}
