package panel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/**
 * 表示计算按钮所在的面板
 */
import javax.swing.JPanel;

import staticfinal.ConstString;

/**
 * 
 * @author Me
 *
 */
public class FunctionJPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 设置计算按钮等控件
	 */
	private JButton addButton = new JButton(ConstString.ADD_SIGN);
	private JButton subButton = new JButton(ConstString.SUB_SIGN);
	private JButton timesButton = new JButton(ConstString.TIMES_SIGN);
	private JButton intoButton = new JButton(ConstString.INTO_SIGN);
	private JButton equalButton = new JButton(ConstString.EQUAL_SIGN);
	private JButton delButton = new JButton(ConstString.DEL_SIGN);// 删除
	private JButton clearButton = new JButton(ConstString.CLEAR_SIGN);// 清空
	private JButton signButton = new JButton(ConstString.SIGN_SIGN);// 表示符号

	public FunctionJPanel() {
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		add(addButton, constraints, 0, 0, 1, 1);
		add(subButton, constraints, 1, 0, 1, 1);
		add(timesButton, constraints, 2, 0, 1, 1);
		add(intoButton, constraints, 3, 0, 1, 1);
		add(delButton, constraints, 0, 1, 1, 1);
		add(clearButton, constraints, 1, 1, 1, 1);
		add(signButton, constraints, 2, 1, 1, 1);
		add(equalButton, constraints, 3, 1, 1, 1);
		/*
		 * 需要添加监听器
		 */
		this.addButton.addActionListener(this);
		this.subButton.addActionListener(this);
		this.timesButton.addActionListener(this);
		this.intoButton.addActionListener(this);
		this.delButton.addActionListener(this);
		this.clearButton.addActionListener(this);
		this.equalButton.addActionListener(this);
		this.signButton.addActionListener(this);
		/*
		 * 去掉绘制焦点
		 */
		this.addButton.setFocusPainted(false);
		this.subButton.setFocusPainted(false);
		this.timesButton.setFocusPainted(false);
		this.intoButton.setFocusPainted(false);
		this.delButton.setFocusPainted(false);
		this.clearButton.setFocusPainted(false);
		this.signButton.setFocusPainted(false);
		this.equalButton.setFocusPainted(false);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonString = "";
		if (e.getSource().equals(addButton)) {
			buttonString = addButton.getText();
		} else if (e.getSource().equals(subButton)) {
			buttonString = subButton.getText();
		} else if (e.getSource().equals(timesButton)) {
			buttonString = timesButton.getText();
		} else if (e.getSource().equals(intoButton)) {
			buttonString = intoButton.getText();
		} else if (e.getSource().equals(delButton)) {
			buttonString = delButton.getText();
		} else if (e.getSource().equals(clearButton)) {
			buttonString = clearButton.getText();
		} else if (e.getSource().equals(equalButton)) {
			buttonString = equalButton.getText();
		} else if (e.getSource().equals(signButton)) {
			buttonString = signButton.getText();
		}
		TextLabelJPanel.changeString(buttonString);
		RadixJPanel.setLabel();
	}
}
