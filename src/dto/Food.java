package dto;

public class Food {
   private String name;
   private String ingredients;
   private boolean size;
   public Food(){
      
   }
   public Food(String name, String ingredients,boolean size){
      this.name = name;
      this.ingredients=ingredients;
      this.size=size;
   }
   public String getName() {
      return name;
   }
   public String getIngredients() {
	      return ingredients;
   }

   public boolean getSize() {
	   return size;
   }
   
   public void setName(String name) {
      this.name = name;
   }
   public void setIngredients(String ingredients) {
	      this.ingredients = ingredients;
   }
   public void setSize(boolean size) {
	      this.size = size;
   }
   public String toString() {
      return "name = " + name +", ingredient = "+ingredients+", size = "+size;
   }

}