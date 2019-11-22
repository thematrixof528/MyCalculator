package frame;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import panel.ButtonJPanel;
import panel.FunctionJPanel;
import panel.RadixJPanel;
import panel.TextLabelJPanel;
import staticfinal.ConstString;
/**
 * @author Me
 */
public class Calculator extends JFrame {
	/**
	 * 序列化
	 */
	private static final long serialVersionUID = 1L;
	// 创建对应的页面
	public static TextLabelJPanel textLabel = new TextLabelJPanel();
	public static ButtonJPanel buttonJPanel = new ButtonJPanel();
	public static RadixJPanel radixJPanel = new RadixJPanel();
	public static FunctionJPanel functionJPanel = new FunctionJPanel();

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		// TODO Auto-generated method stub
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new Calculator();
	}

	/**
	 * 构造方法,用于初始化计算器界面
	 * 
	 * @throws HeadlessException
	 */
	public Calculator() throws HeadlessException {
		super(ConstString.FRAME_TITLE);
		this.setLayout(new GridBagLayout());
		this.setLocation(300, 200);
		this.setSize(320, 500);
		//设置布局
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		//设置文本域
		this.add(textLabel, constraints, 0, 0, 3, 8);
		//将进制按钮添加到界面中
		this.add(radixJPanel, constraints, 4, 0, 3, 8);
		//将数字及字母按钮添加到面板中
		this.add(buttonJPanel, constraints, 8, 0, 4, 4);
		//将功能按钮添加到面板中
		this.add(functionJPanel, constraints, 8, 5, 4, 2);
		//设置窗体可见
		this.setVisible(true);
		//设置窗体始终置顶
		this.setAlwaysOnTop(true);
		// 设置窗体不可调整大小
		this.setResizable(false);
		//设置窗体随点击关闭而关闭
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		constraints.gridwidth = h;
		constraints.gridheight = w;
		constraints.weightx = 100;
		constraints.weighty = 100;
		add(c, constraints);
	}
}
