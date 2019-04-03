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



public class UserMain extends JFrame {

	private static final long serialVersionUID = 1L;
	JLabel lb1, la1, la2, la3, la4, status;
	JTextField id, pw;
	JPanel idPanel, paPanel, loginPanel;
	JButton b1, b2;
	JTextArea content;
	KeyListener keyListener;
	User_info u_inf = new User_info();
	Image img = null;
	
	public UserMain() {
		super("Login"); //â �̸� Login
		setLayout(null); //���̾ƿ� ���� ���ϴ� ��ġ��

//		picture();
		
		idpw();
		
		Button();
		
		setSize(650,900);//��ü â ũ�� ����
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);//x������ �� ����
		setResizable(false);//â ũ�� ����
	}
	
	void picture() {
		
		try {
			File sourceimage = new File("src\\images\\sejong.png");
			img = ImageIO.read(sourceimage);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//�׸����� ��������
			
		la4 = new JLabel(new ImageIcon(img));
		la4.setBounds(35, 10, 550, 550);
		add(la4);// �׸� ����
		
	}
	void idpw(){
		
		idPanel = new JPanel();
		paPanel = new JPanel();
		la3 = new JLabel("  ID ");
		la3.setFont(new Font("",Font.BOLD, 26));
		la2 = new JLabel("PW ");
		la2.setFont(new Font("",Font.BOLD, 26));//ID, PW ���� ����

		id = new JTextField(13);
		id.setFont(new Font("",Font.BOLD, 20));
		pw = new JPasswordField(13);//�Է½� �ܷ� �Էµ�
		pw.setFont(new Font("",Font.BOLD, 20));//id, pw �Է� â ���� ����
		
		idPanel.add(la3);
		idPanel.add(id);
		idPanel.setBounds(80, 620, 300, 80);
		add(idPanel);// ID���ڿ� �ڽ� ����

		paPanel.add(la2);
		paPanel.add(pw);
		paPanel.setBounds(80, 690, 300, 60);
		add(paPanel);// PW���ڿ� �ڽ� ����

		
	}
	void Button() {
		
		b1 = new JButton("LOGIN");
		b2 = new JButton("JOIN");//LOGIN, JOIN ��ư ����
		
		b1.setBounds(430,615,100,125);
		b2.setBounds(250,770,120,40);
		add(b1);
		add(b2);//LOGIN, JOIN ��ư ���� �� ����
		
		status = new JLabel();// id+pw ������ label;
		
		b1.addActionListener(new ActionListener() {//login��ư Ŭ���� �߻��ϴ� �׼�����	
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj1 = e.getSource();
				if((JButton) obj1 == b1) {// login��ư�� ������
					int n =u_inf.login(id.getText(),pw.getText());
					if(n == 2)
						status.setText("pw�� Ȯ�����ֽʽÿ�");
					else if(n == 3)
						status.setText("id�� Ȯ�����ֽʽÿ�");
					else if(n == 1) {
						dispose();//login â ����
						
						UserMenu j3 = new UserMenu("Menu",id.getText());// �� Menu â ����
						j3.setVisible(true);
						j3.setSize(882, 600);//ũ�� ����
						j3.setLocation(500, 100);//������ ��ġ ����
						j3.addWindowListener(new WindowAdapter() {//x������ ��â�� ����ǰ�
							public void windowClosing(WindowEvent e) {
								j3.setVisible(false);
								j3.dispose();//Menu â ����
							}
						});
					}
				}
			}
		});	
		
		status.setBounds(240, 820, 150, 40);
		status.setHorizontalAlignment(JTextField.CENTER);//�������
		add(status);// id+pw �� status ���� �� ����
		
		b2.addActionListener(new ActionListener() {//join��ư Ŭ���� �߻��ϴ� �׼�
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Object obj2 = e.getSource();
				
				if((JButton) obj2 == b2) {// join��ư�� ������
					UserJoin j2 = new UserJoin("Join");// �� join â ����
					j2.setVisible(true);
					j2.setSize(550, 620);//ũ�� ����
					j2.setLocation(500, 100);//������ ��ġ ����
					j2.addWindowListener(new WindowAdapter() {//x������ ��â�� ����ǰ�
						public void windowClosing(WindowEvent e) {
							j2.setVisible(false);
							j2.dispose();//Join â ����
						}
					});
				}
			}
		});
		
	}
	
	public static void main(String[] args)  {
		UserMain j1 = new UserMain();
		
		
	}

	
}