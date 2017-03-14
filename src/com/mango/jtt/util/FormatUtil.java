package com.mango.jtt.util;

import java.text.DecimalFormat;

/**
 * @author HHL
 * @data 2016��8��21�� ���ݸ�ʽ��������
 * 
 */
public class FormatUtil {

	/**
	 * ��ʽ��������λ
	 */
	public static DecimalFormat df = new DecimalFormat("#.##");

	/**
	 * @param dou
	 * @return �������뱣����λС��
	 */
	public static double formatDouble(double dou) {
		df.setGroupingUsed(false);
		return Double.valueOf(df.format(dou));
	}

	/**
	 * @param dou
	 * @return �������뱣����λС��
	 */
	public static String formatDoubleT(double dou) {
		df.setGroupingUsed(false);
		return df.format(dou);
	}

}
