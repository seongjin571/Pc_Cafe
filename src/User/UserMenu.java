package User;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

import Chat.*;
import Admin.AdminGUI;
import dao.*;
import dto.*;


public class UserMenu extends JFrame implements ActionListener, ItemListener{

	private static final long serialVersionUID = 1L;
	JLabel status0, status1, status2, status3, ice_hot, size, shot;
	JPanel background, choice1, choice2, choice3, grid1;
	JButton b[], chat, cancle, pay,logout,change;
	JRadioButton ice, hot, small, tall, large, yes, no;
	ButtonGroup group1, group2, group3;
	User_info u_inf = new User_info();
	int i, b_price=0, price=0, flag=0, b_num;
	String userName, i_h, s_t_l, y_n;

	UserMenu(String str, String userName) {
		super(str);
		this.userName = userName;
		setLayout(null); // 레이아웃 내가 원하는 위치로


		M_button();
		M_bchoice();

		
		chat = new JButton("채팅");
		chat.setActionCommand("chat"); 
		chat.addActionListener(this);
		chat.setBounds(110, 453, 200, 50);// 위치, 크기 설정
		chat.setBackground(new Color(210, 50, 50));// 색상 빨간색
		chat.setFont(new Font("", Font.PLAIN, 17));// 글씨체 설정
		chat.setForeground(new Color(255, 255, 255));// 글씨 하얀색
		chat.setBorderPainted(false);
		add(chat);
	}
	void M_button() {
		
		grid1 = new JPanel();
		status0 = new JLabel();
		status1 = new JLabel();
		status2 = new JLabel();
		status3 = new JLabel();
		grid1.setLayout(new GridLayout(2,5,30,30));
		b = new JButton[10];

		status1.setBounds(500,370,300,80);
		status2.setBounds(500,370,300,80);
		status3.setBounds(500,370,300,80);
		
		b[0] = new JButton("아메리카노");
		b[1] = new JButton("카페라떼");
		b[2] = new JButton("아이스티");
		b[3] = new JButton("진라면");
		b[4] = new JButton("짜파게티");
		b[5] = new JButton("새우깡");
		b[6] = new JButton("홈런볼");
		b[7] = new JButton("누네띠네");
		b[8] = new JButton("건빵");
		b[9] = new JButton("핫도그");//메뉴 버튼 생성
		
		for(i=0;i<10;i++)
			grid1.add(b[i]);
		grid1.setBounds(35, 50, 800, 200);
		add(grid1);

		
		cancle = new JButton("Cancle");
		logout = new JButton("logout");
		change = new JButton("자리이동");
		pay = new JButton("Pay");
		
		cancle.setBounds(490, 450, 100, 50);
		logout.setBounds(350, 450, 100, 50);
		change.setBounds(250, 450, 100, 50);
		pay.setBounds(680, 450, 100, 50);
		
		add(cancle);
		add(pay);
		add(logout);
		add(change);
		
		
		b[0].addActionListener(this);
		b[1].addActionListener(this);
		b[2].addActionListener(this);
		b[3].addActionListener(this);
		b[4].addActionListener(this);
		b[5].addActionListener(this);
		b[6].addActionListener(this);
		b[7].addActionListener(this);
		b[8].addActionListener(this);
		b[9].addActionListener(this);
		
		cancle.addActionListener(this);
		pay.addActionListener(this);
		logout.addActionListener(this);

		
	}
		
	void M_bchoice() {
		flag=3;
		choice1 = new JPanel();
		choice2 = new JPanel();
		choice3 = new JPanel();
		
		group1 = new ButtonGroup();
		ice = new JRadioButton("ICE");
		hot = new JRadioButton("HOT");
		group1.add(ice);
		group1.add(hot);//ice, hot 라디오버튼 생성
		
		group2 = new ButtonGroup();
		small = new JRadioButton("SMALL");
		tall = new JRadioButton("TALL");
		large = new JRadioButton("LARGE");
		group2.add(small);
		group2.add(tall);
		group2.add(large);//s,t,l 라디오버튼 생성
		
		group3 = new ButtonGroup();
		yes = new JRadioButton("YES");
		no = new JRadioButton("NO");
		group3.add(yes);
		group3.add(no);//shot 라디오버튼 생성
		
		ice_hot = new JLabel("ICE / HOT");
		size = new JLabel("SIZE");
		shot = new JLabel("SHOT");//텍스트 설정
		
		ice_hot.setFont(new Font("",Font.BOLD,15));
		size.setFont(new Font("",Font.BOLD,15));
		shot.setFont(new Font("",Font.BOLD,15));//글씨체 설정
		
		hot.addActionListener(this);
		ice.addActionListener(this);
		small.addActionListener(this);
		tall.addActionListener(this);
		large.addActionListener(this);
		yes.addActionListener(this);
		no.addActionListener(this);

	}
	void choice() {

		choice1.add(ice_hot);
		choice1.add(ice);
		choice1.add(hot);//panel에 더하기
		
		choice2.add(size);
		choice2.add(small);
		choice2.add(tall);
		choice2.add(large);//panel에 더하기
		
		choice3.add(shot);
		choice3.add(yes);
		choice3.add(no);//panel에 더하기
		
		choice1.setBounds(100,330,200,30);
		choice2.setBounds(500,330,250,30);
		choice3.setBounds(110,380,200,30);//panel 위치,크기 설정
		
		add(choice1);
		add(choice2);
		add(choice3);//삽입
		
		choice1.repaint();
		choice2.repaint();
		choice3.repaint();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand() == "chat") {
			UserChat clientChat = new UserChat(userName);
			new Thread(clientChat).start();
		}
		else if(e.getSource()==hot) {
			add(status1);
			i_h="";
			s_t_l="";
			status2.setText("");
			status3.setText("");
			status1.setText(status0.getText());
			if(b_num==2) { //아이스티는 ice 만
				status1.setText(status1.getText()+"/ ICE");
				i_h="ice";
			}
			else {
				status1.setText(status1.getText()+"/ HOT");
				i_h="hot";
			}
			status1.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			add(status1);
			
		}
		else if(e.getSource()==ice) {
			add(status1);
			i_h="";
			s_t_l="";
			y_n="";
			status2.setText("");
			status3.setText("");
			status1.setText(status0.getText());
			status1.setText(status1.getText()+"/ ICE");
			status1.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			i_h="ice";
			add(status1);
		} 
		else if(e.getSource()==small) {
			add(status2);
			b_price=0;
			s_t_l="";
			y_n="";
			status3.setText("");
			status2.setText(status1.getText());
			status2.setText(status2.getText()+"/ SMALL");
			if(b_num==1)//카페라떼일 경우
				b_price=1500;
			else
				b_price=1000;
			status2.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			s_t_l="small";
			add(status2);
		}
		else if(e.getSource()==tall) {
			add(status2);
			s_t_l="";
			y_n="";
			b_price=0;
			status3.setText("");
			status2.setText(status1.getText());
			status2.setText(status2.getText()+"/ TALL");
			if(b_num==1)//카페라떼일 경우
				b_price=2000;
			else
				b_price=1500;
			status2.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			s_t_l="tall";
			add(status2);
		}
		else if(e.getSource()==large) {
			add(status2);
			s_t_l="";
			y_n="";
			b_price=0;
			status3.setText("");
			status2.setText(status1.getText());
			status2.setText(status2.getText()+"/ LARGE");
			if(b_num==1)//카페라떼일 경우
				b_price=2500;
			else
				b_price=2000;
			status2.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			s_t_l="large";
			add(status2);
		}
		else if(e.getSource()==yes) {
			add(status3);
			y_n="";
			price = b_price;
			status3.setText(status2.getText());
			if(b_num==2) { //아이스티는 no 샷
				status3.setText(status3.getText()+"/ NO");
				y_n="n";
			}
			else {
				status3.setText(status3.getText()+"/ YES");
				price+=500;
				y_n="y";
			}
			status3.setText(status3.getText()+"/ "+price+"원");
			status3.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			add(status3);
		}
		else if(e.getSource()==no) {
			add(status3);
			y_n="";
			price=b_price;
			status3.setText(status2.getText());
			status3.setText(status3.getText()+"/ NO");
			status3.setText(status3.getText()+"/ "+price+"원");
			status3.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			y_n="n";
			add(status3);
		}
		else if(e.getSource()==pay) {
			for(int i = 0 ; i < 10 ; i++) {
				if((b_num==i)&&(b_num>2)) {
					int p=u_inf.getPrice(userName);
					u_inf.updatePrice(userName, p, price);
					u_inf.updateOrder(b[i].getText(), price, null, null, null);
				}
				else if((b_num==i)&&(b_num<3)) {
					try {
						if(i_h.equals("")||s_t_l.equals("")||y_n.equals("")) throw new Exception();
						int p=u_inf.getPrice(userName);
						u_inf.updatePrice(userName, p, price);
						u_inf.updateOrder(b[i].getText(), price, y_n, s_t_l, i_h);
						}catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "옵션을 전부 선택해 주십시오.");
						}
				}
			}
			
		}
		else if(e.getSource()==cancle) {
			status0.setText("");
			status1.setText("");
			status2.setText("");
			status3.setText("");
			price=0;
			add(status3);
		}
		else if(e.getSource()==logout) {
			UserMain umain = new UserMain();
			u_inf.logout(userName);
			dispose();
		}		
		else if(e.getSource()==b[0]) {
			b_num=0;
			add(status0);
			status0.setText("");
			status1.setText("");
			status2.setText("");
			status3.setText("");
			status0.setText(e.getActionCommand());
			status0.setBounds(500,370,300,80);
			status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			choice();

			add(status0);
		}
		
		else if(e.getSource()==b[1]) {
			b_num=1;
			add(status0);
			status0.setText("");
			status1.setText("");
			status2.setText("");
			status3.setText("");
			status0.setText(e.getActionCommand());
			status0.setBounds(500,370,300,80);
			status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			choice();
			add(status0);
		}
		else if(e.getSource()==b[2]) {
			b_num=2;
			add(status0);
			status0.setText("");
			status1.setText("");
			status2.setText("");
			status3.setText("");
			status0.setText(e.getActionCommand());
			status0.setBounds(500,370,300,80);
			status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			choice();
			add(status0);
		}
		
		else if(e.getSource()==b[3]||e.getSource()==b[4]||e.getSource()==b[5]||e.getSource()==b[6]||e.getSource()==b[7]||e.getSource()==b[8]||e.getSource()==b[9]) {
			add(status0);
			if(e.getSource()==b[3])
				b_num=3;
			else if(e.getSource()==b[4])
				b_num=4;
			else if(e.getSource()==b[5])
				b_num=5;
			else if(e.getSource()==b[6])
				b_num=6;
			else if(e.getSource()==b[7])
				b_num=7;
			else if(e.getSource()==b[8])
				b_num=8;
			else if(e.getSource()==b[9])
				b_num=9;
			status0.setText("");
			status1.setText("");
			status2.setText("");
			status3.setText("");
			if(e.getSource()==b[3]||e.getSource()==b[4]||e.getSource()==b[6]||e.getSource()==b[9]) {
				price=2000;
				status0.setText(e.getActionCommand()+ price+ "원");
			}
			
			else {
				price=1000;
				status0.setText(e.getActionCommand()+ price+ "원");
			}
			status0.setBounds(590,370,300,80);
			status0.setFont(new Font("",Font.PLAIN,17));//글씨체 설정
			add(status0);
			
			if(flag==3) {
				choice1.removeAll();
				choice1.revalidate();
				choice1.repaint();
				choice2.removeAll();
				choice2.revalidate();
				choice2.repaint();
				choice3.removeAll();
				choice3.revalidate();
				choice3.repaint();
			}
		}
		
	}
	
		public void itemStateChanged(ItemEvent e) {
			if(e.getSource()==hot) {
				status2.setText("");
				status3.setText("");
				status1.setText(status0.getText());
				status1.setText(status1.getText()+"/ HOT");
			}
			else if(e.getSource()==ice) {
				status2.setText("");
				status3.setText("");
				status1.setText(status0.getText());
				status1.setText(status1.getText()+"/ ICE");
			}
				
		}
	
			
	
}