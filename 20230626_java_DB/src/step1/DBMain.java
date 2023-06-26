package step1;

import java.util.ArrayList;
import java.util.Scanner;


public class DBMain {
	public static void main(String[] agrs) {
		
		DB db = new DB();
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		String id=null, password=null, name=null, address=null;
		String search_name=null;
		
		while(flag) {
			System.out.println("1. 등록  2. 명단확인  3. 검색   4. 종료");
			String menu_num = sc.next();
			
			switch(menu_num) {
			case "1":
				System.out.println("insert 구문 입력입니다. ");
				System.out.println("1. book_writer 입력: ");
				String book_writer = sc.next();
				System.out.println("2. book_name 입력: ");
				String book_name = sc.next();
				System.out.println("3. book_price 입력: ");
				int book_price = sc.nextInt();
				
				db.bookInsert(book_writer, book_name, book_price);
				break;
			case "2":
				System.out.println(db.bookPrint());
				break;
			case "3":
				System.out.println("책 이름을 입력하세요. ");
				search_name = sc.next();
				db.search(search_name);
				break;
			case "4":
				flag = false;
				break;
			default: 
				System.out.println("숫자 입력 오류입니다. 다시 입력하세요: ");
			}
		}
	}

}
