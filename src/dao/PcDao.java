package dao;

import java.sql.*;
import java.util.*;

import javax.swing.JOptionPane;


import dto.*;

public class PcDao{
	private static String dburl = "jdbc:mysql://localhost/java_study?characterEncoding=UTF-8&serverTimezone=UTC";
	 private static String dbUser = "java";
	 private static String dbpasswd = "wkqktmxjel";

	   Food food = null;
	   Stock stock=null;
	   Connection conn = null;
	   PreparedStatement ps = null;
	   ResultSet rs = null;
	   String[] ingredient;
	   Order order=null;
	   ResultSetMetaData meta;
	   
	   public Food getFood(String menu) {
		   
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,ingredients,size from food where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, menu);
			rs=ps.executeQuery();
			while (rs.next()) {
				String name=rs.getString("name");
				String ingredients=rs.getString("ingredients");
				boolean size=rs.getBoolean("size");
				
				ingredient=ingredients.split(",");
				
				food=new Food(name,ingredients,size);
			}
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   
			   
		   }
		   return food;
	   }
	   public Order getOrder() {
		   String name = "";
		   String shot = "";
		   String size = "";
		   String tem = "";
		   int price = 0;
		   
		   try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,price,shot,size,tem from ordertable";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				name=rs.getString("name");
				price=rs.getInt("price");
				shot=rs.getString("shot");
				size=rs.getString("size");
				tem=rs.getString("tem");
			}
			order=new Order(name,price,shot,size,tem);
			
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   
			   
		   }
		   return order;
	   }

	   public int useStock(String ingredient,int num) {
		   
		   int count=0;
		   int result=0;
		   
		   
		   try {
<<<<<<< HEAD
			count=checkStock(ingredient);
			//¿Á∑·¿« ¿Á∞Ì ºˆ∏¶ ∆ƒæ«
			if(count-num<0) {
				JOptionPane.showMessageDialog(null, "«∞¿˝µ«æ˙Ω¿¥œ¥Ÿ.");
				throw new Exception();
=======
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,count from stock where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, ingredient);
			rs=ps.executeQuery();
			while (rs.next()) {count=rs.getInt("count");}
			//Ïû¨Î£åÏùò Ïû¨Í≥† ÏàòÎ•º ÌååÏïÖ
			if(count-num<0) {
				JOptionPane.showMessageDialog(null, "Ïû¨Í≥†Í∞Ä Î∂ÄÏ°±Ìï©ÎãàÎã§.");
				return 0;
>>>>>>> edb4ac32fa8841c79b610fbbe54cef6015015830
			}
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "update stock set count="+ (count-num) + " where name=?";
			ps= conn.prepareStatement(sql);
			ps.setObject(1, ingredient);
			result=ps.executeUpdate();
            
			
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   
			   
		   }
		   return result;
	   }
	   
	   public int checkStock(String ingredient) {
		   int count=0;
		    try {
			   
		    	Class.forName("com.mysql.cj.jdbc.Driver");
				conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
				String sql= "select name,count from stock where name=?";
				ps= conn.prepareStatement(sql);
				ps.setObject(1, ingredient);
				rs=ps.executeQuery();
				while (rs.next()) {count=rs.getInt("count");}

            //¿Á∑·¿« ¿Á∞Ì ºˆ∏¶ «— ∞≥ ¡Ÿ¿”
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   }
			   return count;
			   
		   }

	   
	   public ArrayList getStock() {
		   ArrayList<Stock> list=new ArrayList<>();
		    try {
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,count from stock";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				 int count=rs.getInt("count");
				 stock=new Stock(name,count);
				 list.add(stock);
			}

            //Ïû¨Î£åÏùò Ïû¨Í≥† ÏàòÎ•º Ìïú Í∞ú Ï§ÑÏûÑ
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   }
		    return list;
	   }
	   
	   public String[] getColumnOrder() {
		   
		   String[] colNames=null;
		   
		    try {
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,price,shot,size,tem from ordertable";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			meta=rs.getMetaData();
			
			int colCount=meta.getColumnCount();
			
			colNames=new String[colCount];
			
			for(int i=0;i<colCount;i++) {
				colNames[i]=meta.getColumnName(i+1);
			}

            //¿Á∑·¿« ¿Á∞Ì ºˆ∏¶ «— ∞≥ ¡Ÿ¿”
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   }
		    return colNames;
	   }
	   
	   public ArrayList getOrderTable() {
		   ArrayList<Order> list=new ArrayList<>();
		    try {
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,price,shot,size,tem from ordertable";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				int price=rs.getInt("price");
				String shot=rs.getString("shot");
				String size=rs.getString("size");
				String tem=rs.getString("tem");
				
				order=new Order(name,price,shot,size,tem);
				list.add(order);
			}

            //¿Á∑·¿« ¿Á∞Ì ºˆ∏¶ «— ∞≥ ¡Ÿ¿”
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   }
		    return list;
	   }
	   public int getOrderPrice() {
		   int total=0;
		    try {
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,price,shot,size,tem from ordertable";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				int price=rs.getInt("price");
				total+=price;
			}

            //¿Á∑·¿« ¿Á∞Ì ºˆ∏¶ «— ∞≥ ¡Ÿ¿”
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   }
		    return total;
	   }

	   public HashMap CountOrder() {
		   HashMap<String,Integer> map=new HashMap<>();
		    try {
			   
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn=DriverManager.getConnection(dburl,dbUser,dbpasswd);
			String sql= "select name,count(*) from ordertable group by name";
			ps= conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				String name=rs.getString("name");
				int count=rs.getInt("count(*)");
				
				map.put(name,count);
			}

            //¿Á∑·¿« ¿Á∞Ì ºˆ∏¶ «— ∞≥ ¡Ÿ¿”
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		   finally {
			   if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   if(ps!=null)
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   if(conn!=null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		   }
		    return map;
	   }
}