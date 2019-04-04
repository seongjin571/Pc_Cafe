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

public class UserSeat  extends JFrame implements ActionListener{

	JPanel grid2;
	JButton b[], confirm;
	User_info u_inf = new User_info();

	
	int i, num;
	String id;
	
	public UserSeat(){
		super("seat"); //창 이름 Login
		setLayout(null); //레이아웃 내가 원하는 위치로

		
		setSize(900,900);//전체 창 크기 설정
		setBounds(510, 40,900,900);// 위치, 크기 설정
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
		
		b[0].addActionListener(this);
		b[1].addActionListener(this);
		b[2].addActionListener(this);
		b[3].addActionListener(this);
		b[4].addActionListener(this);
		b[5].addActionListener(this);
		b[6].addActionListener(this);
		b[7].addActionListener(this);
		b[8].addActionListener(this);
		confirm.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		 if(e.getSource()==confirm) {
			 
			 int result = u_inf.confirmSeat(num);
			 try {
					if(result==-1) throw new Exception();
					u_inf.updateSeat(id, num);
					dispose();//seat 창 삭제
					UserMenu j3 = new UserMenu("Menu",id);// 새 Menu 창 생성
					j3.setVisible(true);
					j3.setSize(882, 600);//크기 설정
					j3.setLocation(500, 100);//생성될 위치 설정
					j3.addWindowListener(new WindowAdapter() {//x누르면 새창만 종료되게
						public void windowClosing(WindowEvent e) {
							j3.setVisible(false);
							j3.dispose();//Menu 창 종료
						}
					});
					}catch(Exception ex) {
						JOptionPane.showMessageDialog(null, "이미 선택된 자석입니다.");
					}
			 
			 
			 
		}
		 else if(e.getSource()==b[0]||e.getSource()==b[1]||e.getSource()==b[2]||e.getSource()==b[3]||e.getSource()==b[4]||e.getSource()==b[5]||e.getSource()==b[6]||e.getSource()==b[7]||e.getSource()==b[8]) {
				num=Integer.parseInt(e.getActionCommand());//1~9 좌석 넘버 저장
		 }
	}
	public static void main(String[] args)  {
		
		UserSeat s1 = new UserSeat();
		
	}
	
}