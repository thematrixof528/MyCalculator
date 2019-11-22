package panel;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
/**
 * ��ʾһ���ı���
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
	// ��������JLabel���ڱ�ʾ�����ı�
	public static JLabel[] numField = new JLabel[2];
	// ����һ����ʽ�Ķ������ڱ�ʾһ�μ���
	public static Equation equation = new Equation();
	// �ж��Ƿ�Ϊ��һ���ַ�
	private static boolean firstChar = true;

	public TextLabelJPanel() {
		// ������������Ҫ�Ĳ�������
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		// ���ÿؼ�ȫ�����
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		// ѭ����ʼ������JLabel�������������
		for (int i = 0; i < numField.length; i++) {
			numField[i] = new JLabel("");
			if (i == 1) {
				numField[i] = new JLabel("0");
			}
			// ����JLabel�Ҷ���
			this.numField[i].setHorizontalAlignment(JLabel.RIGHT);
			this.numField[i].setBorder(null);
		}
		// ���ò��ֹ�������������JLabel������е�λ��
		add(numField[0], constraints, 0, 0, 5, 1);
		add(numField[1], constraints, 1, 0, 5, 2);
		numField[0].setFont(new Font("", Font.BOLD, 20));
		numField[1].setFont(new Font("����", Font.BOLD, 30));
	}

	public static void changeString(String button) {
		String nowText1 = numField[0].getText();
		String nowText2 = numField[1].getText();
		int length1 = nowText1.length();
		int length2 = nowText2.length();
		// ���������ť�Ǽ��㰴ť�Ļ����ı�������ʾ
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
			// ��������İ�ť�Ƿ���λ�Ļ����޸ķ���λ
			if (!"0".equals(nowText2) && !numField[1].getText().trim().startsWith(ConstString.START_OF_WARNING)) {
				if (nowText2.startsWith(ConstString.SUB_SIGN)) {
					numField[1].setText(nowText2.substring(1));
				} else {
					numField[1].setText(ConstString.SUB_SIGN + nowText2);
				}
			}
		} else if ("AC".equals(button)) {
			// �������հ�ť�Ļ��������������
			numField[1].setText("0");
			numField[0].setText("");
			firstChar = true;
		} else if ("<".equals(button)) {
			// �����ǰnumField[1]���ǿյĻ�
			if (length2 == 1) {
				if (!nowText2.equals("0")) {
					// ɾ�����һ���ַ�
					numField[1].setText("0");
				}
				// �޸ĵ�һ������λ
				firstChar = true;
			} else {
				numField[1].setText(nowText2.substring(0, length2 - 1));
			}
		} else if ("=".equals(button)) {
			// ����ǵ��ںŰ�ť�Ļ�
			if (nowText2.startsWith(ConstString.START_OF_WARNING)) {
				numField[1].setText("0");
				firstChar = true;
			} else {
				if (nowText2.equals("0") && equation.getSign().equals("��")) {
					// ��ʼ��һ��Equation
					equation = new Equation();
					// ����Label������
					numField[0].setText("");
					numField[1].setText(ConstString.WARNING);
				} else {
					if (nowText1.endsWith("+") || nowText1.endsWith("-") || nowText1.endsWith("*")
							|| nowText1.endsWith("��")) {
						equation.setNum2(nowText2);
						numField[0].setText(nowText1 + nowText2);
						// ���ü���ķ���
						String answerString = equation.deal();
						numField[1].setText(answerString);
					}
				}
			}
		} else {
			// �����ǰ��ť�����ְ�ť
			// �����ǰ��ʾ�������ַ�����ʾ��
			if (nowText2.startsWith(ConstString.START_OF_WARNING)) {
				numField[0].setText("");
				numField[1].setText("0");
				firstChar = true;
				System.out.println("ִ������������Label�Ĳ���");
			}
			if (firstChar && "0".equals(button)) {
				JOptionPane.showMessageDialog(null, "���ֵ�һ���ַ���������0");
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
	 * ���ݽ��Ƶ�����ǰ�ı����е�����
	 */
	public static void changeRadixOfString() {
		numField[1].setText(RadixJPanel.getLabel());
	}
}
