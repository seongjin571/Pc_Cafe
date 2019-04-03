package User;

import java.util.*;
import Chat.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.border.*;

import dao.*;
import dto.*;

public class UserSeat  extends JFrame{

	JPanel grid2;
	JButton b[], confirm;
	
	int i;
	public UserSeat(){
		super("seat"); //창 이름 Login
		setLayout(null); //레이아웃 내가 원하는 위치로

		
		setSize(900,900);//전체 창 크기 설정
		setBounds(700, 40,900,900);// 위치, 크기 설정
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x눌렀을 때 종료
		setResizable(false);//창 크기 고정
		
		grid2 = new JPanel();
		grid2.setLayout(new GridLayout(3,3,100,100));

		b = new JButton[10];
		b[0] = new JButton("1");
		b[1] = new JButton("2");
		b[2] = new JButton("3");
		b[3] = new JButton("4");
		b[4] = new JButton("5");
		b[5] = new JButton("6");
		b[6] = new JButton("7");
		b[7] = new JButton("8");
		b[8] = new JButton("9");//메뉴 버튼 생성
		//b[0].setFont(new Font("",Font.PLAIN,30));
		
		for(i=0;i<9;i++)
			grid2.add(b[i]);
		grid2.setBounds(95, 50, 700, 700);
		add(grid2);

		confirm = new JButton("확인");
		confirm.setBounds(340,800,210,50);
		add(confirm);
	}
	
	public static void main(String[] args)  {
		
		UserSeat s1 = new UserSeat();
		
	}
	
}
