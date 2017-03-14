package com.mango.jtt.box;

import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.mango.jtt.swing.FreightSwing;
import com.mango.jtt.util.PinYinUtil;

/**
 * Aug 23, 2016
 * 
 * @author HHL �Զ���������Զ��ҵ���ƥ�����Ŀ���������б����ǰ�档
 * 
 */
public class AutoCompleter implements KeyListener {

	private JComboBox owner = null;
	private JTextField editor = null;

	private ComboBoxModel model = null;

	private FreightSwing freightSwing = null;

	public AutoCompleter(JComboBox comboBox) {
		owner = comboBox;
		editor = (JTextField) comboBox.getEditor().getEditorComponent();
		editor.addKeyListener(this);
		model = comboBox.getModel();
		// owner.addItemListener(this);
		editor.setCaretPosition(editor.getText().length());
	}

	public AutoCompleter(JComboBox comboBox, ItemListener itemListener,
			FreightSwing fs) {
		owner = comboBox;
		editor = (JTextField) comboBox.getEditor().getEditorComponent();
		editor.addKeyListener(this);
		model = comboBox.getModel();
		owner.addItemListener(itemListener);
		freightSwing = fs;
	}

	public void keyTyped(KeyEvent e) {
	}

	// ����Ƿ�Enter���������
	public void keyPressed(KeyEvent e) {
		char ch = e.getKeyChar();
		if (ch == KeyEvent.VK_ENTER) {
			return;
		}
		// editor.setText("");
	}

	public void keyReleased(KeyEvent e) {
		char ch = e.getKeyChar();
		if (ch != KeyEvent.VK_ENTER || ch == KeyEvent.CHAR_UNDEFINED
				|| ch == KeyEvent.VK_DELETE)
			return;

		int caretPosition = editor.getCaretPosition();
		String str = editor.getText();
		if (str.length() == 0)
			return;
		autoComplete(str, caretPosition);
	}

	/**
	 * �Զ���ɡ�������������ݣ����б����ҵ����Ƶ���Ŀ.
	 */
	protected void autoComplete(String strf, int caretPosition) {
		Object[] opts;
		opts = getMatchingOptions(strf.substring(0, caretPosition));
		if (owner != null) {
			model = new DefaultComboBoxModel(opts);
			owner.setModel(model);
		}
		if (opts.length > 0) {
			String str = opts[0].toString();
			// editor.setCaretPosition(caretPosition);
			if (owner != null) {
				try {
					owner.showPopup();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		if (freightSwing != null) {
			freightSwing.itemChange();
		}
	}

	/**
	 * 
	 * �ҵ����Ƶ���Ŀ, ���ҽ�֮���е��������ǰ�档
	 * 
	 * @param str
	 * @return ����������Ŀ���б�
	 */
	protected Object[] getMatchingOptions(String str) {
		List v = new Vector();
		List v1 = new Vector();
		model = owner.getModel();
		for (int k = 0; k < model.getSize(); k++) {
			Object itemObj = model.getElementAt(k);
			if (itemObj != null) {
				String itemObjA = PinYinUtil.getPingYin(itemObj.toString());
				String item = itemObjA.toString().toLowerCase();
				String strZ = PinYinUtil.getPingYin(str).toLowerCase();
				if (item.startsWith(strZ) || item.contains(strZ)) {
					v.add(model.getElementAt(k));
				} else {
					v1.add(model.getElementAt(k));
				}
			} else {
				v1.add(model.getElementAt(k));
			}
		}
		for (int i = 0; i < v1.size(); i++) {
			v.add(v1.get(i));
		}
		if (v.isEmpty())
			v.add(str);
		return v.toArray();
	}

}
