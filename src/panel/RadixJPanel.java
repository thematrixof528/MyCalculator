package panel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
/**
 * 表示进制所在的面板
 */
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import staticfinal.ConstString;

/**
 * 
 * @author Me
 *
 */
public class RadixJPanel extends JPanel {
	// 几个单选框表示进制选择
	private JRadioButton hexButton = new JRadioButton("HEX");// 十六进制选择按钮
	private JRadioButton decButton = new JRadioButton("DEC", true);// 十进制选择按钮,默认选中
	private JRadioButton octButton = new JRadioButton("OCT");// 八进制选择按钮
	private JRadioButton binButton = new JRadioButton("BIN");// 二进制选择按钮
	private ButtonGroup radixButtonGroup = new ButtonGroup();// 进制单选框的按钮组
	// 添加几个Label用于显示进制数
	private static JLabel hexJLabel = new JLabel("0");
	private static JLabel decJLabel = new JLabel("0");
	private static JLabel octJLabel = new JLabel("0");
	private static JLabel binJLabel = new JLabel("0");
	public static int SELECTED = 10;// 默认选中十进制

	/**
	 * 构造方法,对进制按钮部分进行初始化
	 */
	public RadixJPanel() {
		// this.setBackground(Color.GREEN);
		this.radixButtonGroup.add(hexButton);
		this.radixButtonGroup.add(decButton);
		this.radixButtonGroup.add(octButton);
		this.radixButtonGroup.add(binButton);
		this.hexButton.setFocusPainted(false);
		this.decButton.setFocusPainted(false);
		this.octButton.setFocusPainted(false);
		this.binButton.setFocusPainted(false);
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		this.add(hexButton, constraints, 0, 0, 1, 1);
		this.add(hexJLabel, constraints, 0, 2, 1, 4);
		this.add(decButton, constraints, 1, 0, 1, 1);
		this.add(decJLabel, constraints, 1, 1, 1, 4);
		this.add(octButton, constraints, 2, 0, 1, 1);
		this.add(octJLabel, constraints, 2, 1, 1, 4);
		this.add(binButton, constraints, 3, 0, 1, 1);
		this.add(binJLabel, constraints, 3, 1, 1, 4);
		ButtonJPanel.setButton(RadixJPanel.SELECTED);
		/*
		 * 给几个按钮添加监听器
		 */
		this.hexButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RadixJPanel.SELECTED = 16;
				ButtonJPanel.setButton(16);
				TextLabelJPanel.changeRadixOfString();
			}
		});
		this.decButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RadixJPanel.SELECTED = 10;
				ButtonJPanel.setButton(10);
				TextLabelJPanel.changeRadixOfString();
			}
		});
		this.octButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RadixJPanel.SELECTED = 8;
				ButtonJPanel.setButton(8);
				TextLabelJPanel.changeRadixOfString();
			}
		});
		this.binButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				RadixJPanel.SELECTED = 2;
				ButtonJPanel.setButton(2);
				TextLabelJPanel.changeRadixOfString();
			}
		});
	}

	/**
	 * 添加一个方法
	 */
	public static void setLabel() {
		String nowString = TextLabelJPanel.numField[1].getText().trim();
		if (!nowString.startsWith(ConstString.START_OF_WARNING)) {
			RadixJPanel.binJLabel.setText("" + Long.toBinaryString(Long.parseLong(nowString, RadixJPanel.SELECTED)));
			RadixJPanel.decJLabel.setText("" + Long.parseLong(nowString, RadixJPanel.SELECTED));
			RadixJPanel.octJLabel.setText("" + Long.toOctalString(Long.parseLong(nowString, RadixJPanel.SELECTED)));
			RadixJPanel.hexJLabel
					.setText("" + Long.toHexString(Long.parseLong(nowString, RadixJPanel.SELECTED)).toUpperCase());
		}
	}

	public static String getLabel() {
		switch (RadixJPanel.SELECTED) {
		case 2:
			return RadixJPanel.binJLabel.getText();
		case 8:
			return RadixJPanel.octJLabel.getText();
		case 10:
			return RadixJPanel.decJLabel.getText();
		default:
			return RadixJPanel.hexJLabel.getText();
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
	public void add(Component c, GridBagConstraints constraints, int y, int x, int h, int w) {
		constraints.gridx = x;
		constraints.gridy = y;
		constraints.gridwidth = w;
		constraints.gridheight = h;
		constraints.weightx = 100;
		constraints.weighty = 100;
		add(c, constraints);
	}
}
