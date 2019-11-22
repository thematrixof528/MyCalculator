package baseclass;

import panel.RadixJPanel;
import staticfinal.ConstString;

/**
 * 用于表示一个计算式
 * 需要含有两个number和一个答案number--->Long
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
		// 对num1进行处理
		this.num1 = Long.parseLong(num1.trim(), RadixJPanel.SELECTED);
		// 从对应进制转换成十进制
	}

	public long getNum2() {
		return num2;
	}

	public void setNum2(String num2) {
		// 对num2进行处理
		this.num2 = Long.parseLong(num2.trim(), RadixJPanel.SELECTED);
		// 从对应进制转换成十进制
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getSign() {
		return this.sign;
	}

	/**
	 * 用于处理一个算式
	 * 
	 * @return
	 */
	public String deal() {
		if (!"".equals(this.sign)) {
			// 如果当前算式的符号不为空，则进行计算
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
	 * 用于表示两个数之间的加法
	 * 
	 * @return
	 */
	private long add() {
		answer = num1 + num2;
		return answer;
	}

	/**
	 * 用于表示两个数之间的减法
	 * 
	 * @return
	 */
	private long sub() {
		answer = num1 - num2;
		return answer;
	}

	/**
	 * 用于表示两个数之间的乘法
	 * 
	 * @return
	 */
	private long times() {
		answer = num1 * num2;
		return answer;
	}

	/**
	 * 用于表示两个数之间的除法
	 * 
	 * @return
	 */
	private long into() {
		// 如果第二个数不是0的话
		if (num2 != 0) {
			answer = num1 / num2;
			return answer;
		} else {
			return Long.MAX_VALUE;
		}
	}
}

//	
//	private NumberStack numberStack = new NumberStack();// 创建一个数字堆栈
//	private SignStack signStack = new SignStack();// 创建一个符号堆栈
//
//	public String deal() {
//		return "";
//	}
//}
//
///**
// * 创建一个新的堆栈用于保存用户的输入的数据
// * 
// * @author Me
// *
// */
//class NumberStack {
//	public static int PopPoint = 0;
//	public long[] num = new long[10];// 最多支持十个数字的混合运算
//
//	public NumberStack() {
//		PopPoint = 0;
//	}
//
//	public String Pop() {
//		if (PopPoint > 0) {// 如果当前堆栈不为空
//			String numString = num[PopPoint] + "";
//			PopPoint--;
//			return numString;
//		}
//		return "";// 如果当前堆栈为空，则返回一个空字符串
//	}

//	public void Push(String numString) {
//		if (PopPoint < num.length) {
//			num[PopPoint] = Long.parseLong(numString.trim(), RadixJPanel.SELECTED);
//			PopPoint++;
//		} else {
//			JOptionPane.showMessageDialog(null, "超出限定的数字个数！");
//		}
//	}
//}
//
///**
// * 创建一个新的堆栈用于保存用户输入的符号
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
//		if (PopPoint > 0) {// 如果当前堆栈不为空
//			String numString = sign[PopPoint] + "";
//			PopPoint--;
//			return numString;
//		}
//		int length = NumberStack.PopPoint;
//		if (length != 0 && length % 2 == 1) {// 保证数字堆栈里面至少有两个数字
//			if (sign[PopPoint - 1].equals("*") || sign[PopPoint - 1].equals("÷")) {
//
//			}
//		}
//		return "";// 如果当前堆栈为空，则返回一个空字符串
//	}
//
//	public void Push(String numString) {
//		if (PopPoint < sign.length) {
//			sign[PopPoint] = numString.trim();
//			PopPoint++;
//		} else {
//			JOptionPane.showMessageDialog(null, "超出限定的符号个数！");
//		}
//	}
//}
