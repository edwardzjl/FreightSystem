package com.mango.jtt.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author DELL �ַ���������
 */
public class StringUtil {
	/**
	 * @param str
	 * @return �ַ����Ƿ�Ϊ��
	 */
	public static boolean isEmpty(String str) {
		return (str == null) || str.trim().equals("")
				|| str.trim().equals("null");
	}

	/**
	 * �����Ƿ��Ƿ����������,������+��
	 * 
	 * @return
	 */
	public static boolean isNumeric(String str) {
		String regex = "^[1-9][0-9]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
}
