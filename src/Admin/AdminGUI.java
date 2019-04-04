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
	JPanel contentPane, grid;
	JButton btn1, btn2,btn3;
	JLabel la1, la2, la3;
	
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