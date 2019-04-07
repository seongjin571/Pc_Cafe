package Admin;

import java.awt.*;
import Chat.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import dao.*;
import dto.*;

public class AdminGUI extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	JPanel contentPane, grid;
	JButton btn1, btn2,btn3;
	JLabel la1, la2, la3;
	
=======

	JPanel contentPane, contentPane_sub, grid1, grid2, grid3, grid4;
	JButton btn1, btn2;
	JButton btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14;
	JButton btn16, btn17, btn18;
	JButton btn19, btn20, btn21;
	BufferedImage img;
	JLabel la1, la2, label, la3, la4, la5;
	JTextField text;
	String str; 
	int count = 0;
	WindowEvent win = null;

	public void showStock() {

		Object[] colNames;
		Object[][] data; 
		contentPane_sub = new JPanel();
		setTitle("재고 관리 프로그램");
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

		la1 = new JLabel("재고 현황");
		la1.setBounds(35, 5, 100, 50);
		add(la1);

		// �뀒�씠釉� �깮�꽦
		JTable table = new JTable(data, colNames);
		JScrollPane j = new JScrollPane(table);
		j.setBounds(35, 50, 900, 150);
		add(j);

		la2 = new JLabel("물품주문");
		la2.setBounds(35, 200, 100, 50);
		add(la2);

		grid1 = new JPanel();
		grid1.setLayout(new GridLayout(2, 5, 30, 30));

		btn4 = new JButton("건빵");
		btn5 = new JButton("누네띠네");
		btn6 = new JButton("빵");
		btn7 = new JButton("새우깡");
		btn8 = new JButton("소세지");
		btn9 = new JButton("아이스티");
		btn10 = new JButton("우유");
		btn11 = new JButton("원두");
		btn12 = new JButton("진라면");
		btn13 = new JButton("짜파게티");
		btn14 = new JButton("홈런볼");

		label = new JLabel();
		label.setBounds(35, 475, 500, 50);
		la3 = new JLabel();
		la3.setBounds(35, 520, 500, 50);
		text = new JTextField(5);
		text.setBounds(130, 525, 300, 40);
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
		grid1.add(btn12);
		btn12.addActionListener(this);
		grid1.add(btn13);
		btn13.addActionListener(this);
		grid1.add(btn14);
		btn14.addActionListener(this);
		add(label);
		add(la3);
		grid1.setBounds(35, 250, 900, 200);

		add(grid1);

		grid2 = new JPanel();
		grid2.setLayout(new GridLayout(1, 4, 100, 100));

		btn16 = new JButton("주문");
		btn16.addActionListener(this);
		btn17 = new JButton("판매현황");
		btn17.addActionListener(this);
		btn18 = new JButton("초기화");
		btn18.addActionListener(this);

		grid2.add(btn16);
		grid2.add(btn17);
		grid2.add(btn18);

		grid2.setBounds(35, 600, 900, 80);

		add(grid2);
		setSize(1000, 800);
		setLocation(800, 10);
		setVisible(true);

	}

	public void sale() {

		setTitle("판매 현황");
		addWindowListener(this);
		setLayout(null);
		contentPane_sub = new JPanel();
		la4 = new JLabel("재고 현황");
		la4.setBounds(35, 5, 100, 50);
		add(la4);

		la5 = new JLabel("물품주문");
		la5.setBounds(35, 200, 100, 50);
		add(la5);

		grid4 = new JPanel();
		grid4.setLayout(new GridLayout(1, 3, 100, 100));

		btn19 = new JButton("매출");
		btn20 = new JButton("메뉴별판매");
		btn21 = new JButton("판매리스트");

		grid4.add(btn19);
		grid4.add(btn20);
		grid4.add(btn21);

		grid4.setBounds(35, 600, 900, 80);

		add(grid4);

		setSize(1000, 800);
		setLocation(800, 10);
		setVisible(true);
	}

>>>>>>> edb4ac32fa8841c79b610fbbe54cef6015015830
	public void managerWindow() {

		setTitle("관리자창");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setLayout(null);

		ImageIcon icon = new ImageIcon("src\\\\images\\\\sejong.png");
		JLabel picLabel = new JLabel(icon);
		picLabel.setBounds(35, 10, 550, 550);
		add(picLabel);

		grid = new JPanel();
		grid.setLayout(new GridLayout(1, 3, 50, 50));
		btn1= new JButton("판매현황");
		grid.add(btn1);
		btn1.addActionListener(this);
		btn2 = new JButton("재고관리");
		grid.add(btn2);
		btn2.addActionListener(this);

		grid.setBounds(60, 600, 500, 80);
		add(grid);

		setSize(650, 900);
		setLocation(0, 10);

		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == btn1) {
			new AdminSale().sale();
		}
		else if (e.getSource() == btn2) {
			new AdminStock().showStock();
		}		

	}


}