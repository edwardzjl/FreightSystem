package com.mango.jtt.main;

import com.mango.jtt.swing.FreightSwing;
import com.mango.jtt.util.FileUtil;


/**
 * @author HHL
 * @data 2016��8��14��
 * main����
 * 
 */
public class SwingMain {

	public static void main(String args[]) {
		//��ʼ������
		FileUtil.initData();
		//����ϵͳ
		new FreightSwing("JTT�����˷Ѽ���ϵͳ");
	}

}
