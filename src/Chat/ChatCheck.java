package Chat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ChatCheck {
	public static void main(String[] args) {
		
		Scanner in=new Scanner(System.in);
		String a;
		String return_str;
		string_checker ck = new string_checker();
		a=in.next();
		return_str=ck.check(a);
		System.out.println(return_str);
	}
}
class string_checker{
	
	private static ArrayList<String> filter=new ArrayList<String>();
	static {
		filter.add("�ù�");
		filter.add("��ģ");
		filter.add("����");
		filter.add("����");
		
	}
	public String check(String input) {
		Iterator<String> it=filter.iterator();
		while(it.hasNext()) {
			String str=it.next();
			if(input.contains(str)) {
				input=input.replace(str, "*");		
			}
		}	
		return input;
	}
}
