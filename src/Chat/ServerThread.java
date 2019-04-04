package Chat;

import java.awt.BorderLayout;
import java.awt.Font;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

class ServerThread extends JFrame implements Runnable, ActionListener, WindowListener {

	private static final long serialVersionUID = 1L;
	// 멤버변수로 선언
	JButton but_input;
	JTextArea textArea;
	JTextField textInput;
	JLabel name;
	Font f1;
	private Socket socket;
	private BufferedReader in = null;
	private PrintWriter out = null;
//	private String userIP = socket.getInetAddress().toString();F

	ServerThread(Socket client) {
		this.socket = client;
	}

	// 오버라이딩일 경우 throw 불가.
	public void run() {
		setSize(550, 620);
		setLocation(100, 180);
		f1 = new Font("돋움", Font.BOLD, 30);
		addWindowListener(this);
		setTitle("SeJong Pc Cafe");
		JPanel panel = new JPanel();
		name = new JLabel("SeJong Pc Cafe 관리자 채팅방");
		name.setFont(f1);
		JPanel panel2 = new JPanel();
		textArea = new JTextArea(30, 40);
		textInput = new JTextField(30);
		textInput.registerKeyboardAction(this, "input", KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED);
		but_input = new JButton("입력");
		but_input.setActionCommand("input");
		but_input.addActionListener(this);
		panel2.add(name);
		panel.add(textArea);
		panel.add(textInput);
		panel.add(but_input);
		add(panel2, BorderLayout.NORTH);
		add(panel);
		setVisible(true);
		try {
			service();
		} catch (IOException e) {
			System.out.println("** 님 접속 종료.");
		} finally {
			try {
				closeAll();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void service() throws IOException {
//	 chatStart();
		textArea.append("클라이언트가 접속되었습니다.\n");
		in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		out = new PrintWriter(socket.getOutputStream(), true);
		String str = null;
		while (true) {
			str = in.readLine();
			if (str == null) {
				System.out.println( "님이 연결을 종료했습니다.");
				break;
			}
			System.out.println( "님: " + str);
			out.println(str);
		}
	}

	public void closeAll() throws IOException {
		if (out != null)
			out.close();
		if (in != null)
			in.close();
		if (socket != null)
			socket.close();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//	string_checker ck = new string_checker();
		String s;
		String in_str, return_str = null;
		in_str = textInput.getText();
//	return_str=ck.check(in_str);
		s = "관리자 : " + in_str;
		if (e.getActionCommand() == "input") {
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
}
