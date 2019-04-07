package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import dto.Food;
import dto.Order;
import dto.Seat;
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
	 
	 PcDao PcDao=null;
	 Order order=null;
	 Food food=null;
	 ArrayList<Seat> table =new ArrayList();
		 
	 
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
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
						result = 1;// id, pw �몮�떎 �씪移�
					}
					else
						result = 2;// id留� �씪移�
				}
			}
			else {
				result = 3;// id, pw �몮�떎 遺덉씪移�
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
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
			 	PcDao=new PcDao();
				order=PcDao.getOrder();
				food=PcDao.getFood(name);
				System.out.println(food);
				
				String[] ingredient=food.getIngredients().split(",");//占쌍뱄옙占쏙옙 占쏙옙占쏙옙占� 占쏙옙搔� 占쏙옙占쏙옙占쏙옙 String占쏙옙 占쏙옙占쏙옙
				int[] count=new int[ingredient.length];
				
				for(int i=0;i<count.length;i++) count[i]=1;
				
				if(food.getSize()==true) {
					if(shot.equals("y")) count[0]++;
					if(size.equals("tall")||size.equals("large")) for(int i=0;i<count.length;i++) count[i]++;
					if(size.equals("large")) for(int i=0;i<count.length;i++)count[i]++;
				}
				
				for(int i=0;i<ingredient.length;i++) {//占쏙옙占� 占쏙옙 1占쏙옙 占싱거놂옙 2占쏙옙 占싱므뤄옙 占썼열占쏙옙 占쏙옙占싱울옙 占쏙옙占쏙옙 占쌥븝옙
					int check=PcDao.useStock(ingredient[i],count[i]);//占쏙옙占� 占쏙옙 占쏙옙 占쏙옙占쏙옙 占쌕울옙占쏙옙
					if(check==0) throw new Exception();
				}
				
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
			
			
		} catch (Exception e) {
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 return result;
	 }
	public int confirmSeat(int num) {
		int result = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "select exist_id from seat where num = ? ";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, num);
			rs = ps.executeQuery();
			if(rs.next()) {
				String exist_id = rs.getString("exist_id");
				if(exist_id.equals(""))
					result = 0;
				else 
					result = -1;// �씠誘� �늻媛� �븠�� �옄由�
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}
	public int updateSeat(String id, int num) {
		int result = 0;
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "update seat set exist_id = ? where num = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, num);
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 return result;
	 }
	

	
	public int logout(String id) {
		int result = 0;
		 try {
			String blank="";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql = "update seat set exist_id = ? where exist_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,blank);
			ps.setString(2, id);
			
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
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		 return result;
	 }	
	
	@SuppressWarnings("finally")
	public ArrayList<Seat> seatload() {
		Seat in=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection(dburl, dbUser, dbpwd);
			String sql= "Select * from seat";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				int id1 = rs.getInt("num");
				String name = rs.getString("exist_id");
				in = new Seat(id1, name);
				table.add(in);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}			
			if(ps!=null) {
				try {
					ps.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}	
			return table;
		}
	}	
}