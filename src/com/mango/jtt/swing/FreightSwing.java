package com.mango.jtt.swing;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.mango.jtt.box.JAutoCompleteComboBox;
import com.mango.jtt.container.AirContainer;
import com.mango.jtt.model.AirFreight;
import com.mango.jtt.service.AirFreightService;
import com.mango.jtt.util.FormatUtil;
import com.mango.jtt.util.StringUtil;

/**
 * @author HHL
 * @data 2016��8��14�� �˷Ѽ���ϵͳ
 * 
 */
public class FreightSwing extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	GridBagLayout g = new GridBagLayout();
	GridBagConstraints c = new GridBagConstraints();

	public FreightSwing(String str) {
		super(str);
		setSize(800, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(g);
		// ���÷���
		addComponent();
		submit.addActionListener(this);
		setVisible(true);
		setLocationRelativeTo(null);// �������ʾ;
	}

	// ����������н���������е����;ʹ�õ������鲼��
	public void addComponent() {
		// �����Ϣ����
		noteInformation = new JLabel("�����������Ϣ");
		// ָ������߿���Χ���ⲿ��䡣Ĭ��Ϊ����䡣
		c.insets = new Insets(2, 1, 1, 1);
		add(g, c, noteInformation, 0, 0, 1, 1);
		// ʼ��վ
		originStation = new JLabel("ʼ��վ��");
		add(g, c, originStation, 0, 1, 1, 1);
		// ʼ��վ����
		originStationName = new JLabel("���");
		add(g, c, originStationName, 1, 1, 1, 1);
		// Ŀ�ĵ�
		destinationStation = new JLabel("Ŀ�ĵأ�");
		add(g, c, destinationStation, 0, 2, 1, 1);
		// ��ѡ�������� ���к�ʡ��
		cityProvince = new JAutoCompleteComboBox(new DefaultComboBoxModel(
				getCityProvince()));
		add(g, c, cityProvince, 1, 2, 1, 1);
		// province = new JAutoCompleteComboBox(this, new DefaultComboBoxModel(
		// getProvince()), new ItemListener() {
		//
		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// itemChange();
		// }
		//
		// });
		// add(g, c, province, 1, 2, 1, 1);
		//
		// // ��ѡ������ ����
		// city = new JAutoCompleteComboBox(new
		// DefaultComboBoxModel(getCity()));
		// add(g, c, city, 2, 2, 1, 1);
		//
		// province.addItemListener(new ItemListener() {
		//
		// @Override
		// public void itemStateChanged(ItemEvent e) {
		// itemChange();
		// }
		//
		// });

		// ������������֧����
		quantity = new JLabel("��������(��֧)��");
		add(g, c, quantity, 0, 3, 1, 1);
		// ���������
		textQuantity = new JTextField(15);
		add(g, c, textQuantity, 1, 3, 1, 1);
		// ���ͷ�ʽ
		deliveryMethod = new JLabel("���ͷ�ʽ��");
		add(g, c, deliveryMethod, 0, 4, 1, 1);
		// ���� ��ѡ��
		send = new JRadioButton("����");
		add(g, c, send, 1, 4, 1, 1);
		// ���� ��ѡ��
		take = new JRadioButton("����");
		add(g, c, take, 2, 4, 1, 1);
		ButtonGroup group = new ButtonGroup();
		group.add(send);
		group.add(take);
		// submit��ť
		submit = new JButton("submit");
		c.insets = new Insets(7, 0, 4, 0);
		add(g, c, submit, 1, 5, 1, 1);

		result = new JTextArea(15, 30);
		add(g, c, result, 0, 6, 3, 4);

	}

	private Object[] getCityProvince() {
		Object[] PRO1 = AirContainer.cityProvinceList.toArray();
		Object[] PRO2 = { "��ѡ��Ŀ�ĵ�" };
		Object[] PRO = arrayProcess(PRO1, PRO2);
		return PRO;
	}

	/**
	 * @return ��ȡʡ��
	 */
	private Object[] getProvince() {
		Object[] PRO1 = AirContainer.airCitySelectorMap.keySet().toArray();
		Object[] PRO2 = { "��ѡ��ʡ��" };
		Object[] PRO = arrayProcess(PRO1, PRO2);
		return PRO;
	}

	/**
	 * @return ����ʡ�ݻ�ȡ����
	 */
	private Object[] getCity() {
		String key = (String) province.getSelectedItem();
		List<String> cityList = AirContainer.airCitySelectorMap.get(key);
		Object[] city1 = { "��ѡ�����" };
		Object[] city2;
		if (null != cityList) {
			Object[] cityArray = cityList.toArray();
			city2 = arrayProcess(cityArray, city1);
		} else {
			city2 = city1;
		}
		return city2;
	}

	/**
	 * ������ѡʡ�ݣ���ʾ����
	 */
	public void itemChange() {
		Object[] city2 = getCity();
		city.setModel(new DefaultComboBoxModel(city2));

	}

	/**
	 * @param PRO
	 * @param PRO2
	 * @return ���鴦��, ���պ��ֽ������򲢺ϲ�����
	 */
	private Object[] arrayProcess(Object[] PRO, Object[] PRO2) {
		Comparator<Object> com = Collator.getInstance(java.util.Locale.CHINA);
		Arrays.sort(PRO, com);
		int strl1 = PRO2.length;
		int strl2 = PRO.length;
		PRO2 = Arrays.copyOf(PRO2, strl1 + strl2);
		System.arraycopy(PRO, 0, PRO2, strl1, strl2);
		return PRO2;
	}

	public void add(GridBagLayout g, GridBagConstraints c, JComponent jc,
			int x, int y, int gw, int gh) {
		// ָ����Ԫ����ʼ�к��У�xΪ�У�yΪ�У�Ĭ��ֵΪ0
		c.gridx = x;
		c.gridy = y;
		// ��ʾ����ڵ�Ԫ���ڵĶ��뷽ʽ
		c.anchor = GridBagConstraints.WEST;
		// ָ����Ԫ���к��еķ�Χ��Ĭ��ֵΪ1��wΪ�У�hΪ��
		c.gridwidth = gw;
		c.gridheight = gh;
		g.setConstraints(jc, c);
		add(jc);
	}

	JLabel noteInformation, originStation, quantity;
	JLabel deliveryMethod, destinationStation;
	JLabel originStationName;
	JTextField textQuantity;
	JRadioButton send, take;
	JComboBox province, city, cityProvince;
	JButton submit;
	JTextArea result;

	@Override
	public void actionPerformed(ActionEvent arg0) {

		String osn = originStationName.getText();
		String pro = (String) cityProvince.getSelectedItem();
		if (StringUtil.isEmpty(pro) || "��ѡ��Ŀ�ĵ�".equals(pro)) {
			toolTip("��ѡ��Ŀ�ĵأ�");
			cityProvince.grabFocus();
			return;
		}
		if (!AirContainer.cityProvinceList.contains(pro)) {
			toolTip("Ŀ�ĵ� " + pro + " �����ڣ���ѡ����ȷ��Ŀ�ĵأ�");
			cityProvince.grabFocus();
			return;
		}
		// String cit = (String) city.getSelectedItem();
		// if (StringUtil.isEmpty(cit) || "��ѡ�����"equals(cit)) {
		// toolTip("��ѡ����У�");
		// city.grabFocus();
		// return;
		// }
		String quan = textQuantity.getText();
		if (StringUtil.isEmpty(quan) || !StringUtil.isNumeric(quan)) {
			toolTip("����д��ȷ�ľ���������");
			textQuantity.grabFocus();
			return;
		}
		String sen = send.getText();
		String tak = take.getText();
		if (!take.isSelected() && !send.isSelected()) {
			toolTip("��ѡ�����ͷ�ʽ��");
			return;
		}

		// ���ͷ�ʽ
		String takeType = (String) (send.isSelected() ? sen : tak);
		// �����˷�����
		AirFreight af = AirFreightService.computeFreight(osn + "-" + pro,
				takeType, quan);

		String num = "ʼ��վ��" + osn + "\nĿ��վ��" + pro + "\n��������(��֧)��" + quan
				+ "\n���ͷ�ʽ��" + takeType + "\n�����˷Ѻϼ�(Ԫ)��"
				+ FormatUtil.formatDoubleT(af.getAirTotalCost())
				+ "\n��·�˷Ѻϼ�(Ԫ)��"
				+ FormatUtil.formatDoubleT(af.getLandTotalCost())
				+ "\n�����˷� - ��·�˷�(Ԫ)��"
				+ FormatUtil.formatDoubleT(af.getMarginCost());
		result.setText(num);
	}

	/**
	 * @param mes
	 *            ��ʾ��
	 */
	private void toolTip(String mes) {
		Toolkit.getDefaultToolkit().beep();
		JOptionPane.showMessageDialog(null, mes, "��ܰ��ʾ",
				JOptionPane.INFORMATION_MESSAGE);
		return;
	}

}
