package panel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * 表示数字及字母所在的面板
 */
import javax.swing.JPanel;

/**
 * 
 * @author Me
 *
 */
public class ButtonJPanel extends JPanel implements ActionListener {
	// 设置数字及字母按钮的相关属性
	public static JButton[] numButton = new JButton[16];// 按钮数组

	public ButtonJPanel() {
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		/*
		 * 初始化各个按钮
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
	 * 重写add方法
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
	 * 为一组按钮添加监听动作
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numButton.length; i++) {
			if (e.getSource().equals(numButton[i])) {
				/*
				 * 此处添加监听的动作
				 */
				TextLabelJPanel.changeString(numButton[i].getText());
				RadixJPanel.setLabel();
			}
		}
	}

	/**
	 * 用于设置每一个按钮的可用状态 应当可以在RadixJPanel中调用
	 * 
	 * @param index
	 */
	public static void setButton(int index) {
		// 循环遍历所有的Button
		for (int i = 0; i < numButton.length; i++) {
			if (i < index) {
				// 设置小于当前进制的按钮可用
				numButton[i].setEnabled(true);
			} else {
				// 设置大于等于当前进制的按钮不可用
				numButton[i].setEnabled(false);
			}
		}
	}
}
