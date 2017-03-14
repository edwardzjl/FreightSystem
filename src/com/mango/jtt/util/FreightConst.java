package com.mango.jtt.util;

/**
 * @author DELL �˷ѳ�������
 */
/**
 * @author HHL
 * @data 2016��8��21��
 * 
 */
public class FreightConst {
	/**
	 * ���˱������
	 */
	public static String AIREXCELNAME = PropertiesUtil.getValue("airExcelName");

	/**
	 * ��������sheet����
	 */
	public static String AIRSHEETNAME = PropertiesUtil.getValue("airSheetName");
	/**
	 * �̳���������������
	 */
	public static double FACTOAIRF = Double.valueOf(PropertiesUtil
			.getValue("facToAirF"));
	/**
	 * ��������ת��Ϊ����������
	 */
	public static double KGF = Double.valueOf(PropertiesUtil.getValue("kgF"));
	/**
	 * ���շ���
	 */
	public static double INSURANCERATE = Double.valueOf(PropertiesUtil
			.getValue("insuranceRateF").replace('%', ' ')) / 100.00;
	/**
	 * Ͷ���������
	 */
	public static double INSURANCECOSTF = Double.valueOf(PropertiesUtil
			.getValue("insuranceCostF"));
	/**
	 * ��װ������
	 */
	public static double PACKINGCOSTF = Double.valueOf(PropertiesUtil
			.getValue("packingCostF"));
	/**
	 * �����������Ŀ�ĵ�
	 */
	public static String DESTINATION = PropertiesUtil.getValue("destination");
	/**
	 * �����������Ŀ�ĵ�����
	 */
	public static double DESTINATIONF = Double.valueOf(PropertiesUtil
			.getValue("destinationF"));
	/**
	 * ��·�˷�(����С����700��֧)����
	 */
	public static double LANDCOSTF = Double.valueOf(PropertiesUtil
			.getValue("landCostF"));
	/**
	 * ��·�˷�(����С����700��֧)����
	 */
	public static double LANDCOSTT = Double.valueOf(PropertiesUtil
			.getValue("landCostT"));

	// EXCEL �к� ��0��ʼ 0�����A�У�0�����1��
	/**
	 * 
	 */
	public static int ROWNUMBER = Integer.valueOf(PropertiesUtil
			.getValue("rowNumber"));
	public static int ID = Integer.valueOf(PropertiesUtil.getValue("id"));
	public static int ORIGINSTATION = Integer.valueOf(PropertiesUtil
			.getValue("originStation"));
	public static int DESTINATIONSTATION = Integer.valueOf(PropertiesUtil
			.getValue("destinationStation"));
	public static int PROVINCE = Integer.valueOf(PropertiesUtil
			.getValue("province"));
	public static int UNITPRICEF = Integer.valueOf(PropertiesUtil
			.getValue("unitPriceF"));
	public static int UNITPRICET = Integer.valueOf(PropertiesUtil
			.getValue("unitPriceT"));
	public static int UNITPRICEDH = Integer.valueOf(PropertiesUtil
			.getValue("unitPriceDH"));
	public static int UNITPRICEZT = Integer.valueOf(PropertiesUtil
			.getValue("unitPriceZT"));
	public static int SUBSIDYMILEAGE = Integer.valueOf(PropertiesUtil
			.getValue("subsidyMileage"));
	public static int LANDMILEAGE = Integer.valueOf(PropertiesUtil
			.getValue("landMileage"));
	public static int LANDUNITPRICE = Integer.valueOf(PropertiesUtil
			.getValue("landUnitPrice"));

	/**
	 * @param args
	 */
	// public static void main(String[] args) {
	//
	// System.out.println(FACTOAIRF);
	// System.out.println(KGF);
	// System.out.println(INSURANCERATE);
	// System.out.println(INSURANCECOSTF);
	// System.out.println(PACKINGCOSTF);
	// }
}
