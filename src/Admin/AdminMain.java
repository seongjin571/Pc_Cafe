package Admin;

import dao.*;
import Chat.*;
import dto.*;

import java.io.IOException;
import java.util.*;

public class AdminMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
<<<<<<< HEAD
<<<<<<< HEAD
=======

		/*String menu="아이스티";//메뉴가 주문되었다고 가정
		PCDao PCDao=new PCDao();
		Food food=PCDao.getFood(menu);
		System.out.println(food);
		String[] ingredient=food.getIngredients().split(",");
		for(int i=0;i<ingredient.length;i++) {
			PCDao.useStock(ingredient[i]);
		}*/
>>>>>>> edb4ac32fa8841c79b610fbbe54cef6015015830
		
		AdminGUI window=new AdminGUI();
=======

		AdminGUI window = new AdminGUI();
>>>>>>> fa6db2b2a0312b1b9c906e309fb1a9ad19994737
		window.managerWindow();
		AdminChat adminChat = new AdminChat();
//		adminChat.serverStart();
	}

}
