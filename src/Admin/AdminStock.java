package Admin;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import dao.PcDao;
import dto.Stock;

public class AdminStock extends JFrame implements WindowListener, ActionListener{
	
	private static final long serialVersionUID = 1L;
	JPanel contentPane, grid1,grid2;
	JButton btn1, btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11;
	JButton btn12, btn13,btn14;
	JLabel la1, la2, la3, la4;
	JTable table;
	JTextField text;
	String str;
	
	public void showStock() {

		Object[] colNames; 
		Object[][] data; 
		contentPane = new JPanel();
		setTitle("��� ���� ���α׷�");
		addWindowListener(this);

		setLayout(null);

		PcDao dao = new PcDao();
		ArrayList<Stock> list = dao.getStock();

		int rowCount = list.size();
		System.out.println("row: " + rowCount);

		colNames = new Object[rowCount];

		for (int i = 0; i < rowCount; i++) {
			colNames[i] = list.get(i).getName();
		}

		data = new Object[1][rowCount];
		for (int r = 0; r < rowCount; r++) {
			data[0][r] = list.get(r).getCount();
		}

		la1 = new JLabel("��� ��Ȳ");
		la1.setBounds(35, 5, 100, 50);
		add(la1);

		table = new JTable(data, colNames);
		table.setRowHeight(20);
		JScrollPane j = new JScrollPane(table);
		j.setBounds(35, 50, 900, 150);
		add(j);

		la2 = new JLabel("��ǰ�ֹ�");
		la2.setBounds(35, 200, 100, 50);
		add(la2);

		grid1 = new JPanel();
		grid1.setLayout(new GridLayout(2, 5, 30, 30));

		btn1 = new JButton("�ǻ�");
		btn2 = new JButton("���׶��");
		btn3 = new JButton("��");
		btn4 = new JButton("�����");
		btn5 = new JButton("�Ҽ���");
		btn6 = new JButton("���̽�Ƽ");
		btn7 = new JButton("����");
		btn8 = new JButton("����");
		btn9 = new JButton("�����");
		btn10 = new JButton("¥�İ�Ƽ");
		btn11 = new JButton("Ȩ����");

		la3 = new JLabel();
		la3.setBounds(35, 475, 500, 50);
		la4 = new JLabel();
		la4.setBounds(35, 520, 500, 50);
		text = new JTextField(5);
		text.setBounds(130, 525, 300, 40);
		grid1.add(btn1);
		btn1.addActionListener(this);
		grid1.add(btn2);
		btn2.addActionListener(this);
		grid1.add(btn3);
		btn3.addActionListener(this);
		grid1.add(btn4);
		btn4.addActionListener(this);
		grid1.add(btn5);
		btn5.addActionListener(this);
		grid1.add(btn6);
		btn6.addActionListener(this);
		grid1.add(btn7);
		btn7.addActionListener(this);
		grid1.add(btn8);
		btn8.addActionListener(this);
		grid1.add(btn9);
		btn9.addActionListener(this);
		grid1.add(btn10);
		btn10.addActionListener(this);
		grid1.add(btn11);
		btn11.addActionListener(this);
		add(la3);
		add(la4);
		grid1.setBounds(35, 250, 900, 200);

		add(grid1);

		grid2 = new JPanel();
		grid2.setLayout(new GridLayout(1, 4, 100, 100));

		btn12 = new JButton("�ֹ�");
		btn12.addActionListener(this);
		btn13 = new JButton("�Ǹ���Ȳ");
		btn13.addActionListener(this);
		btn14 = new JButton("�ʱ�ȭ");
		btn14.addActionListener(this);

		grid2.add(btn12);
		grid2.add(btn13);
		grid2.add(btn14);

		grid2.setBounds(35, 600, 900, 80);

		add(grid2);
		setSize(1000, 800);
		setLocation(800, 10);
		setVisible(true);

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == btn12) {
			try {
				Integer.parseInt(text.getText());
				if (Integer.parseInt(text.getText()) <= 0)
					throw new Exception();
				new PcDao().useStock(str, -Integer.parseInt(text.getText()));
				setVisible(false);
				new AdminStock().showStock();
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "�߸��� �Է� �Դϴ�.");
			}
		} else if (e.getSource() == btn13) {
			setVisible(false);
			new AdminSale().sale();
		} else if (e.getSource() == btn14) {
			text.setText("");
		}

		if (e.getSource() == btn1 || e.getSource() == btn2 || e.getSource() == btn3 || e.getSource() == btn4||
			e.getSource() == btn5 || e.getSource() == btn6 || e.getSource() == btn7 || e.getSource() == btn8||
			e.getSource() == btn9 || e.getSource() == btn10 || e.getSource() == btn11) {
			str = e.getActionCommand();
			la3.setText(e.getActionCommand()+"��/�� �ֹ��Ͻǰǰ���? ������ �Է��ϼ���.");
			la4.setText("�ֹ������Է�:");
			add(text);
		}

		
	}
}
