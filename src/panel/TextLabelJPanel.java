package panel;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * 表示一个文本域
 */
import javax.swing.JPanel;

import baseclass.Equation;
import staticfinal.ConstString;

/**
 * 
 * @author Me
 *
 */
public class TextLabelJPanel extends JPanel {
	// 创建两个JLabel用于表示两行文本
	public static JLabel[] numField = new JLabel[2];
	// 创建一个等式的对象，用于表示一次计算
	public static Equation equation = new Equation();
	// 判断是否为第一个字符
	private static boolean firstChar = true;

	public TextLabelJPanel() {
		// 创建布局所必要的参数对象
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		// 设置控件全部填充
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		// 循环初始化两个JLabel，设置相关属性
		for (int i = 0; i < numField.length; i++) {
			numField[i] = new JLabel("");
			if (i == 1) {
				numField[i] = new JLabel("0");
			}
			// 设置JLabel右对齐
			this.numField[i].setHorizontalAlignment(JLabel.RIGHT);
			this.numField[i].setBorder(null);
		}
		// 利用布局管理器设置两个JLabel在面板中的位置
		add(numField[0], constraints, 0, 0, 5, 1);
		add(numField[1], constraints, 1, 0, 5, 2);
		numField[0].setFont(new Font("", Font.BOLD, 20));
		numField[1].setFont(new Font("宋体", Font.BOLD, 30));
	}

	public static void changeString(String button) {
		String nowText1 = numField[0].getText();
		String nowText2 = numField[1].getText();
		int length1 = nowText1.length();
		int length2 = nowText2.length();
		// 如果所按按钮是计算按钮的话则文本换行显示
		if (ConstString.ADD_SIGN.equals(button) || ConstString.SUB_SIGN.equals(button)
				|| ConstString.TIMES_SIGN.equals(button) || ConstString.INTO_SIGN.equals(button)) {
			if (nowText2.startsWith(ConstString.START_OF_WARNING)) {
				numField[1].setText("0");
				firstChar = true;
			} else {
				equation.setNum1(nowText2);
				equation.setSign(button);
				numField[0].setText(nowText2 + button);
				numField[1].setText("0");
			}
		} else if ("+/-".equals(button)) {
			// 如果所按的按钮是符号位的话则修改符号位
			if (!"0".equals(nowText2) && !numField[1].getText().trim().startsWith(ConstString.START_OF_WARNING)) {
				if (nowText2.startsWith(ConstString.SUB_SIGN)) {
					numField[1].setText(nowText2.substring(1));
				} else {
					numField[1].setText(ConstString.SUB_SIGN + nowText2);
				}
			}
		} else if ("AC".equals(button)) {
			// 如果是清空按钮的话则清空所有内容
			numField[1].setText("0");
			numField[0].setText("");
			firstChar = true;
		} else if ("<".equals(button)) {
			// 如果当前numField[1]不是空的话
			if (length2 == 1) {
				if (!nowText2.equals("0")) {
					// 删除最后一个字符
					numField[1].setText("0");
				}
				// 修改第一个符号位
				firstChar = true;
			} else {
				numField[1].setText(nowText2.substring(0, length2 - 1));
			}
		} else if ("=".equals(button)) {
			// 如果是等于号按钮的话
			if (nowText2.startsWith(ConstString.START_OF_WARNING)) {
				numField[1].setText("0");
				firstChar = true;
			} else {
				if (nowText2.equals("0") && equation.getSign().equals("÷")) {
					// 初始化一个Equation
					equation = new Equation();
					// 设置Label的内容
					numField[0].setText("");
					numField[1].setText(ConstString.WARNING);
				} else {
					if (nowText1.endsWith("+") || nowText1.endsWith("-") || nowText1.endsWith("*")
							|| nowText1.endsWith("÷")) {
						equation.setNum2(nowText2);
						numField[0].setText(nowText1 + nowText2);
						// 调用计算的方法
						String answerString = equation.deal();
						numField[1].setText(answerString);
					}
				}
			}
		} else {
			// 如果当前按钮是数字按钮
			// 如果当前显示内容是字符串提示：
			if (nowText2.startsWith(ConstString.START_OF_WARNING)) {
				numField[0].setText("");
				numField[1].setText("0");
				firstChar = true;
				System.out.println("执行了重置两个Label的操作");
			}
			if (firstChar && "0".equals(button)) {
				JOptionPane.showMessageDialog(null, "数字第一个字符不可以是0");
			} else {
				if (numField[1].getText().trim().equals("0")) {
					numField[1].setText(button);
				} else {
					numField[1].setText(numField[1].getText().trim() + button);
				}
				firstChar = false;
			}
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
	 * 根据进制调整当前文本框中的内容
	 */
	public static void changeRadixOfString() {
		numField[1].setText(RadixJPanel.getLabel());
	}
}
