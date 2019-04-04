package Admin;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import dao.PcDao;
import dto.Order;

public class AdminSale extends JFrame implements WindowListener, ActionListener{
	JPanel contentPane, grid1;
	JButton btn1, btn2,btn3;
	JLabel la1, la2, la3;

	public void sale() {
		
		String[] colNames; 
		Object[][] data; 

		setTitle("판매 현황");
		addWindowListener(this);
		setLayout(null);
		contentPane = new JPanel();
		la1 = new JLabel("판매리스트");
		la1.setBounds(35, 5, 100, 50);
		add(la1);
		
		PcDao dao = new PcDao();
		ArrayList<Order> list = dao.getOrderTable();
		
		colNames=dao.getColumnOrder();
		int colCount=colNames.length;

		int rowCount = list.size();
		System.out.println("row: " + rowCount);

		data = new Object[rowCount][colCount];
		for(int r=0;r<rowCount;r++) {
			String[] str1=list.get(r).toString().split(",");
			for (int c = 0; c < colCount; c++) {
				String[] str2=str1[c].split("=");
				data[r][c] = str2[1];
			}
		}

		JTable table = new JTable(data,colNames);
		table.setRowHeight(25);
		JScrollPane j = new JScrollPane(table);
		j.setBounds(35, 50, 900, 250);
		add(j);
	
		la2 = new JLabel("메뉴별 판매량");
		la2.setBounds(35, 300, 100, 50);
		add(la2);
		
		HashMap map = dao.CountOrder();
		
		colNames=new String[]{"이름","판매개수"};
		colCount=colNames.length;

		rowCount = map.size();
		System.out.println("row: " + rowCount);
		
		int r=0;
		data = new Object[rowCount][colCount];
		Set<String> keys = map.keySet(); // 해시맵 map에 있는 모든 키를 Set 컬렉션으로 리턴
		Iterator<String> it = keys.iterator(); // Set의 각 문자열을 순차 검색하는 Iterator 리턴
		while(it.hasNext())  {
		    String key = it.next(); // 키
		    Object value = map.get(key); // 값
		    data[r][0]=key;
		    data[r][1]=value;
		    r++;
		}
		
		
		table = new JTable(data,colNames);
		table.setRowHeight(25);
		j = new JScrollPane(table);
		j.setBounds(35, 350, 900, 150);
		add(j);
		
		la3 = new JLabel();
		la3.setFont(new Font("맑은고딕",Font.BOLD,40));
		la3.setBounds(35, 530, 900, 50);
		add(la3);

		grid1 = new JPanel();
		grid1.setLayout(new GridLayout(1, 3, 100, 100));

		btn1 = new JButton("매출");
		btn1.addActionListener(this);
		btn2 = new JButton("메뉴별판매");
		btn3 = new JButton("판매리스트");

		grid1.add(btn1);
		grid1.add(btn2);
		grid1.add(btn3);

		grid1.setBounds(35, 600, 900, 80);

		add(grid1);

		setSize(1000, 800);
		setLocation(800, 10);
		setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		if (e.getSource() == btn1) {
			int total=new PcDao().getOrderPrice();
			String str="총 매출은 "+total+" 입니다.";
			la3.setText(str);
		}
	}

}
