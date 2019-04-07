package Chat;

import java.awt.BorderLayout;
import java.awt.Color;
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
import java.net.ServerSocket;
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

public class AdminChat extends JFrame implements WindowListener {
	private static final long serialVersionUID = 1L;
	JButton but_input;
	JTextArea textArea;
	JTextField textInput;
	JLabel name;
	Font f1;
	static ServerSocket serverSocket = null;
	static Socket client = null;
	static PrintWriter out;
	static BufferedReader in;
	static String inputLine, outputLine;

	public AdminChat() throws IOException {
		System.out.println("서버 시작!!");
		try {
			serverSocket = new ServerSocket(3000);
			while (true) {
				client = serverSocket.accept();
				Runnable chatting = new ServerThread(client);
				Thread t = new Thread(chatting);

				t.start();
			}
		} catch (IOException e) {
			System.out.println("해당 포트 번호에 연결할 수 없습니다!");
		} finally {
			if (client != null) {
				client.close();
			}

			if (serverSocket != null) {
				serverSocket.close();
			}
			System.out.println("**서버 종료**");
		}
		
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub

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
