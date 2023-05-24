package ex2;

import java.util.Scanner;
import java.util.ArrayList;

public class WhileTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = true;
		int input_num=0;
		Scanner sc = new Scanner(System.in);
		
		/* 배열로 입력받으려면 주석해제
		ArrayList<String> IDs = new ArrayList<>();
		ArrayList<String> Names = new ArrayList<>();
		ArrayList<String> Address = new ArrayList<>();
		*/
		
		String id="",name="",addr="";
		//String str = "";
		
		while(flag) {
			System.out.println("1.등록\n2.전체출력\n3.종료");
			input_num = sc.nextInt();
			
			
			switch(input_num) {
				case 1:
				//아이디
				System.out.println("아이디를 입력하세요: ");
				id = sc.next();
				//IDs.add(str);
				
				//이름
				System.out.println("이름 입력하세요: ");
				name = sc.next();
				//Names.add(str);
				
				//주소
				System.out.println("주소를 입력하세요: ");
				addr = sc.next();
				//Address.add(str);
				break;
				
			case 2:
				System.out.println("[등록결과]\n"+"아이디: "+id+" 이름: "+name+" 주소: "+addr);
				break;
				
			case 3:
				System.out.println("종료합니다.");
				flag = false;
				break;
			}
		}
	}

}
