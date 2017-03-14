package com.mango.jtt.container;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.mango.jtt.model.AirFreight;

/**
 * @author DELL ����������
 */
public class AirContainer {
	/**
	 * ������˷Ѷ����map�� keyΪ��originStation-destinationStation-province��
	 * valueΪAireFreight
	 */
	public static Map<String, AirFreight> airFreightMap = new HashMap<String, AirFreight>();

	/**
	 * ����Ŀ�ĵ�ʡ��list ��Ӧ province
	 */
	public static List<String> airProvinceList = new LinkedList<String>();
	/**
	 * ����Ŀ�ĵس���list ��ӦdestinationStation
	 */
	public static List<String> airCityList = new LinkedList<String>();
	/**
	 * ���밴ʡ��������Ŀ�ĵ�
	 */
	public static Map<String, List<String>> airCitySelectorMap = new HashMap<String, List<String>>();

	/**
	 * Ŀ�ĵغ�ʡ�ݱ��
	 */
	public static List<String> cityProvinceList = new LinkedList<String>();;

	/**
	 * ��Ŀ�ĵغ�ʡ�ݶ�Ӧ����������map��
	 */
	public static void citySelector() {
		if (airProvinceList.size() > 0 && airCityList.size() > 0) {
			for (int i = 0; i < airProvinceList.size(); i++) {
				String key = airProvinceList.get(i);
				String city = airCityList.get(i);
				if (airCitySelectorMap.containsKey(key)) {
					List<String> cityList = airCitySelectorMap.get(key);
					cityList.add(city);
					airCitySelectorMap.put(key, cityList);
				} else {
					List<String> cityList = new LinkedList<String>();
					cityList.add(city);
					airCitySelectorMap.put(key, cityList);
				}
			}
		}

	}
}
