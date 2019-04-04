package Admin;

import dao.*;
import Chat.*;
import dto.*;

import java.io.IOException;
import java.util.*;


public class AdminMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		AdminGUI window=new AdminGUI();
		window.managerWindow();
		AdminChat adminChat = new AdminChat();
//		adminChat.serverStart();
	}

}
