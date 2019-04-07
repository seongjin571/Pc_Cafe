package Chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class UserChat extends JFrame implements ActionListener, Runnable, WindowListener {
	private static final long serialVersionUID = 1L;
	JButton but_input;
	JTextArea textArea;
	JTextField textInput;
	JLabel name;
	JPanel panel, panel2;
	Font f1, f2;
	int seatNum;
	static PrintWriter out = null;
	static BufferedReader in = null;
	Socket socket = null;
	GridBagLayout Gbag = new GridBagLayout();
	GridBagConstraints gbc1;

	public UserChat(int seatNum) {
		this.seatNum = seatNum;
		setSize(550, 620);
		setLocation(1000, 180);
		f1 = new Font("돋움", Font.BOLD, 30);
		f2 = new Font("돋움", Font.PLAIN, 18);
		addWindowListener(this);
		setTitle("SeJong Pc Cafe");
		panel = new JPanel();
		name = new JLabel("SeJong Pc Cafe 채팅방");
		name.setFont(f1);
		panel2 = new JPanel();
		textArea = new JTextArea(23, 35);
		textArea.setFont(f2);
		JScrollPane scroll = new JScrollPane(textArea);
		textInput = new JTextField(30);
		textInput.setFont(f2);
		textInput.registerKeyboardAction(
				this, "input", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),JComponent.WHEN_FOCUSED);
		but_input = new JButton("입력");
		but_input.setActionCommand("input");
		but_input.addActionListener(this);
		panel2.add(name);
		panel.add(scroll);
		panel.add(textInput);
		panel.add(but_input);
		panel2.setBackground(new Color(255, 80, 80, 255));
		panel.setBackground(new Color(255, 80, 80, 255));

		add(panel2, BorderLayout.NORTH);
		add(panel);
		setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) { // client to Server
		string_checker ck = new string_checker();
		if (e.getActionCommand() == "input") {
			String in_str, return_str = null;
			in_str = textInput.getText();
			return_str = ck.check(in_str);
			String s = seatNum + "번 손님: " + return_str;
			textArea.append(s + " " + nowTime() + "\n");
			out.println(s);
			textInput.setText("");
		}
		
	}

	public String nowTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH시 mm분 ss초");
		LocalDateTime time = LocalDateTime.now();
		String nowTime = " [" + time.format(formatter) + "]";
		return nowTime;

	}

	@Override
	public void run() {

		// TODO Auto-generated method stub
		try {
			socket = new Socket("localhost", 3000);
			out = new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			textArea.append("채팅을 시작합니다. 욕설은 삼가해주세요.\n");
			out.println(seatNum + "번 손님이 입장하셨습니다.");
		} catch (UnknownHostException e) {
			System.err.println("localhost에 접근할 수 없습니다.");
		} catch (IOException eg) {
			eg.printStackTrace();
			textArea.append("연결에 실패하였습니다. 관리자에게 문의하세요.");
		}
		String fromServer;
		try {
			String return_str;
			string_checker ck = new string_checker();// d
			while (!(fromServer = in.readLine()).equals("k121313231")) {
				return_str=ck.check(fromServer);
				String s = return_str + " " + nowTime() + "\n";
				textArea.append(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.close();
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		System.exit(0);
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		out.println("<<"+seatNum+"번 손님이 채팅방에 나가셨습니다>>");
		out.println("k121313231");
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}
}