package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.User;
import Admin.*;


public class User_info {
	
	private static String dburl = "jdbc:mysql://localhost/java_study?characterEncoding=UTF-8&serverTimezone=UTC";
	
	private static String dbUser = "java";
	private static String dbpwd = "wkqktmxjel";
	
	 User u = null;
	 Connection conn = null;
	 PreparedStatement ps = null;
	 ResultSet rs = null;
	 
	public int compareID(String id) {
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "select u_id from user_inf";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				String u_id = rs.getString("u_id");
				if(u_id.equals(id))
					return -1;
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
		 return 0;
	 }
	public void addMember(User u) {

		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "insert into user_inf value(?,?,?,0)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getU_id());
			ps.setString(2, u.getU_pw());
			ps.setString(3, u.getU_email());
			result = ps.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	public int login(String id, String pw) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "select u_id, u_pw from user_inf where u_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
		//	ps.setString(2, pw);
			if(rs.next()) {
				String u_id = rs.getString("u_id");
				String u_pw = rs.getString("u_pw");
				if(u_id.equals(id)) {
					if(u_pw.equals(pw)) {
						result = 1;// id, pw �Ѵ� ��ġ
					}
					else
						result = 2;// id�� ��ġ
				}
			}
			else {
				result = 3;// id, pw �Ѵ� ����ġ
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}
	public int getPrice(String id) {
		 int price =0;
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "select u_price from user_inf where u_id = ? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if(rs.next()) {
				price = rs.getInt("u_price");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 
		 return price;
	 }	
	public int updatePrice(String id, int price1, int price2) {
		 price1+=price2;
		int result = 0;
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "update user_inf set u_price ="+price1+" where u_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			result = ps.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 return result;
	 }

	public int updateOrder(String name, int price, String shot, String size, String tem) {
		int result = 0;
		 try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
				String sql = "insert into ordertable value(?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.setInt(2, price);
				ps.setString(3, shot);
				ps.setString(4, size);
				ps.setString(5, tem);
				result = ps.executeUpdate();
//				AdminMain(); //����
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 return result;
	 }
	
}