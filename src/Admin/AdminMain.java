package Admin;

import dao.*;
import Chat.*;
import dto.*;

import java.io.IOException;
import java.util.*;


public class AdminMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*String menu="���̽�Ƽ";//메뉴가 주문되었다고 가정
		PCDao PCDao=new PCDao();
		Food food=PCDao.getFood(menu);
		System.out.println(food);
		String[] ingredient=food.getIngredients().split(",");
		for(int i=0;i<ingredient.length;i++) {
			PCDao.useStock(ingredient[i]);
		}*/
		
		AdminGUI window=new AdminGUI();
		window.managerWindow();
		AdminChat adminChat = new AdminChat();
//		adminChat.serverStart();
	}

}
