package dto;


public class Order {
	private String name;
	private int price;
	private String shot;
	private String size;
	private String tem;
   
   public Order(){}
   
   public Order(String name,int price,String shot,String size,String tem){
	   this.name=name;
	   this.price=price;
	   this.shot=shot;
	   this.size=size;
	   this.tem=tem;
   }
   public String getName() {
      return name;
   }
   public int getPrice() {
	  return price;
   }
   public String getShot() {
	  return shot;
   }
   public String getSize() {
	  return size;
   }
   public String getTem() {
	  return tem;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   public void setPrice(int price) {
	  this.price = price;
   }
   public void setShot(String shot) {
	  this.shot = shot;
   }
   public void setSize(String size) {
	  this.size = size;
   }
   public void setTem(String tem) {
	  this.tem = tem;
   }
  
   public String toString() {
      return "name = " + name +", price = "+price+", shot = "+shot+", size = "+size+", tem = "+tem;
   }

}