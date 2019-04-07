package dto;

public class Seat {
	   private int num;
	   private String exist_id;
	   public Seat(){     
	   }
	   public Seat(int num, String exist_id){
		      this.num = num;
		      this.exist_id = exist_id;
	   }
	   public int getnum() {
		   return num;
	   }
	   public String getexist_id() {
		   return exist_id;
	   }
	   public void setnum(int num) {
		   this.num = num;
	   }
	   public void setexist_id(String exist_id) {
		   this.exist_id = exist_id;
	   }
	   public String toString() {
		   return "num = " + num + ", exist_id = " + exist_id ;
	   }	   
}
