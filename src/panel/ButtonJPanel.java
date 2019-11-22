package panel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * ��ʾ���ּ���ĸ���ڵ����
 */
import javax.swing.JPanel;

/**
 * 
 * @author Me
 *
 */
public class ButtonJPanel extends JPanel implements ActionListener {
	// �������ּ���ĸ��ť���������
	public static JButton[] numButton = new JButton[16];// ��ť����

	public ButtonJPanel() {
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		/*
		 * ��ʼ��������ť
		 */
		int i = 0;
		while (i < numButton.length) {
			String name = "";
			if (i <= 9) {
				name = name + i;
			} else {
				name = name + (char) ('A' + i - 10);
			}
			numButton[i] = new JButton(name);
			this.add(numButton[i], constraints, i / 4, i % 4, 1, 1);
			numButton[i].setFocusPainted(false);
			numButton[i].addActionListener(this);
			i++;
		}
	}

	/**
	 * ��дadd����
	 * 
	 * @param c
	 * @param constraints
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 */
	public void add(Component c, GridBagConstraints constraints, int x, int y, int w, int h) {
		constraints.gridx = y;
		constraints.gridy = x;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		constraints.weightx = 100;
		constraints.weighty = 100;
		add(c, constraints);
	}

	/**
	 * Ϊһ�鰴ť��Ӽ�������
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numButton.length; i++) {
			if (e.getSource().equals(numButton[i])) {
				/*
				 * �˴���Ӽ����Ķ���
				 */
				TextLabelJPanel.changeString(numButton[i].getText());
				RadixJPanel.setLabel();
			}
		}
	}

	/**
	 * ��������ÿһ����ť�Ŀ���״̬ Ӧ��������RadixJPanel�е���
	 * 
	 * @param index
	 */
	public static void setButton(int index) {
		// ѭ���������е�Button
		for (int i = 0; i < numButton.length; i++) {
			if (i < index) {
				// ����С�ڵ�ǰ���Ƶİ�ť����
				numButton[i].setEnabled(true);
			} else {
				// ���ô��ڵ��ڵ�ǰ���Ƶİ�ť������
				numButton[i].setEnabled(false);
			}
		}
	}
}
