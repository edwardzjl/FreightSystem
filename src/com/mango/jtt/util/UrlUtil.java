package com.mango.jtt.util;

import java.net.URL;

/**
 * Aug 19, 2016
 * 
 * @author HHL ��ȡurl������
 */
public class UrlUtil {

	/**
	 * @return ��ȡ��Ŀ¼ ��ʵ��classpath
	 */
	public static String getRootUrl() {
		URL rootUrl = UrlUtil.class.getClassLoader().getResource("");
		// ��Դ����jar�����ȡrootUrlΪnull������
		if (null == rootUrl) {
			return "";
		}

		String rootUrlS = rootUrl.getPath();
		if (rootUrlS.contains("/bin/")) {
			return rootUrlS.substring(0, rootUrlS.length() - 4);
		}
		return rootUrlS;
	}

	// /**
	// * @param args
	// */
	// public static void main(String[] args) {
	// System.out.println(UrlUtil.class.getClassLoader().getResource("")
	// .getPath());
	// }
}
