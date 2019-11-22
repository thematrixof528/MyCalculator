package baseclass;

import panel.RadixJPanel;
import staticfinal.ConstString;

/**
 * ���ڱ�ʾһ������ʽ
 * ��Ҫ��������number��һ����number--->Long
 * 
 * @author Me
 *
 */
public class Equation {
	private long num1 = 0;
	private String sign = "+";
	private long num2 = 0;
	private long answer = 0;
	private String answerString = "";

	public long getNum1() {
		return num1;
	}

	public void setNum1(String num1) {
		// ��num1���д���
		this.num1 = Long.parseLong(num1.trim(), RadixJPanel.SELECTED);
		// �Ӷ�Ӧ����ת����ʮ����
	}

	public long getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		// ��num2���д���
		this.num2 = Long.parseLong(num2.trim(), RadixJPanel.SELECTED);
		// �Ӷ�Ӧ����ת����ʮ����
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return this.sign;
	}

	/**
	 * ���ڴ���һ����ʽ
	 * 
	 * @return
	 */
	public String deal() {
		if (!"".equals(this.sign)) {
			// �����ǰ��ʽ�ķ��Ų�Ϊ�գ�����м���
			if (ConstString.ADD_SIGN.equals(this.sign)) {
				this.answer = add();
			} else if (ConstString.SUB_SIGN.equals(sign)) {
				this.answer = sub();
			} else if (ConstString.TIMES_SIGN.equals(sign)) {
				this.answer = times();
			} else if (ConstString.INTO_SIGN.equals(sign)) {
				this.answer = into();
			}
		}
		switch (RadixJPanel.SELECTED) {
		case 2:
			return ("" + Long.toBinaryString(answer));
		case 8:
			return ("" + Long.toOctalString(answer));
		case 16:
			return ("" + Long.toHexString(answer)).toUpperCase();
		default:
			return ("" + answer);
		}
	}

	/**
	 * ���ڱ�ʾ������֮��ļӷ�
	 * 
	 * @return
	 */
	private long add() {
		answer = num1 + num2;
		return answer;
	}

	/**
	 * ���ڱ�ʾ������֮��ļ���
	 * 
	 * @return
	 */
	private long sub() {
		answer = num1 - num2;
		return answer;
	}

	/**
	 * ���ڱ�ʾ������֮��ĳ˷�
	 * 
	 * @return
	 */
	private long times() {
		answer = num1 * num2;
		return answer;
	}

	/**
	 * ���ڱ�ʾ������֮��ĳ���
	 * 
	 * @return
	 */
	private long into() {
		// ����ڶ���������0�Ļ�
		if (num2 != 0) {
			answer = num1 / num2;
			return answer;
		} else {
			return Long.MAX_VALUE;
		}
	}
}

//	
//	private NumberStack numberStack = new NumberStack();// ����һ�����ֶ�ջ
//	private SignStack signStack = new SignStack();// ����һ�����Ŷ�ջ
//
//	public String deal() {
//		return "";
//	}
//}
//
///**
// * ����һ���µĶ�ջ���ڱ����û������������
// * 
// * @author Me
// *
// */
//class NumberStack {
//	public static int PopPoint = 0;
//	public long[] num = new long[10];// ���֧��ʮ�����ֵĻ������
//
//	public NumberStack() {
//		PopPoint = 0;
//	}
//
//	public String Pop() {
//		if (PopPoint > 0) {// �����ǰ��ջ��Ϊ��
//			String numString = num[PopPoint] + "";
//			PopPoint--;
//			return numString;
//		}
//		return "";// �����ǰ��ջΪ�գ��򷵻�һ�����ַ���
//	}

//	public void Push(String numString) {
//		if (PopPoint < num.length) {
//			num[PopPoint] = Long.parseLong(numString.trim(), RadixJPanel.SELECTED);
//			PopPoint++;
//		} else {
//			JOptionPane.showMessageDialog(null, "�����޶������ָ�����");
//		}
//	}
//}
//
///**
// * ����һ���µĶ�ջ���ڱ����û�����ķ���
// * 
// * @author Me
// *
// */
//class SignStack {
//	public static int PopPoint = 0;
//	public String[] sign = new String[9];
//
//	public SignStack() {
//		PopPoint = 0;
//	}
//
//	public String Pop() {
//		if (PopPoint > 0) {// �����ǰ��ջ��Ϊ��
//			String numString = sign[PopPoint] + "";
//			PopPoint--;
//			return numString;
//		}
//		int length = NumberStack.PopPoint;
//		if (length != 0 && length % 2 == 1) {// ��֤���ֶ�ջ������������������
//			if (sign[PopPoint - 1].equals("*") || sign[PopPoint - 1].equals("��")) {
//
//			}
//		}
//		return "";// �����ǰ��ջΪ�գ��򷵻�һ�����ַ���
//	}
//
//	public void Push(String numString) {
//		if (PopPoint < sign.length) {
//			sign[PopPoint] = numString.trim();
//			PopPoint++;
//		} else {
//			JOptionPane.showMessageDialog(null, "�����޶��ķ��Ÿ�����");
//		}
//	}
//}
