package Admin;

import dao.*;
import Chat.*;
import dto.*;

import java.io.IOException;
import java.util.*;


public class AdminMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		/*String menu="���̽�Ƽ";//�޴��� �ֹ��Ǿ��ٰ� ����
		PCDao PCDao=new PCDao();
		Food food=PCDao.getFood(menu);
		System.out.println(food);
		String[] ingredient=food.getIngredients().split(",");//�ֹ��� ������ ��Ḧ ������ String�� ����
		for(int i=0;i<ingredient.length;i++) {//��� ���� 1�� �̰ų� 2�� �̹Ƿ� �迭�� ���̿� ���� �ݺ�
			PCDao.useStock(ingredient[i]);//��� ���� �� ���� �ٿ���
		}*/
		
		AdminGUI window=new AdminGUI();
		window.managerWindow();
		AdminChat adminChat = new AdminChat();
//		adminChat.serverStart();
	}

}
