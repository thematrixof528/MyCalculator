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
	 * ���л�
	 */
	private static final long serialVersionUID = 1L;
	// ������Ӧ��ҳ��
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
	 * ���췽��,���ڳ�ʼ������������
	 * 
	 * @throws HeadlessException
	 */
	public Calculator() throws HeadlessException {
		super(ConstString.FRAME_TITLE);
		this.setLayout(new GridBagLayout());
		this.setLocation(300, 200);
		this.setSize(320, 500);
		//���ò���
		GridBagLayout myLayout = new GridBagLayout();
		this.setLayout(myLayout);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.anchor = GridBagConstraints.CENTER;
		//�����ı���
		this.add(textLabel, constraints, 0, 0, 3, 8);
		//�����ư�ť��ӵ�������
		this.add(radixJPanel, constraints, 4, 0, 3, 8);
		//�����ּ���ĸ��ť��ӵ������
		this.add(buttonJPanel, constraints, 8, 0, 4, 4);
		//�����ܰ�ť��ӵ������
		this.add(functionJPanel, constraints, 8, 5, 4, 2);
		//���ô���ɼ�
		this.setVisible(true);
		//���ô���ʼ���ö�
		this.setAlwaysOnTop(true);
		// ���ô��岻�ɵ�����С
		this.setResizable(false);
		//���ô��������رն��ر�
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
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
		constraints.gridwidth = h;
		constraints.gridheight = w;
		constraints.weightx = 100;
		constraints.weighty = 100;
		add(c, constraints);
	}
}
