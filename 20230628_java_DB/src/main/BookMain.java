package main;

import java.util.Scanner;

import service.BookService;
import vo.BookVO;
import exception.BookNotFoundException;

public class BookMain {
	public static void main(String[] args) throws BookNotFoundException{
		BookService service = new BookService();
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		
		String id=null, author=null, title=null, publisher=null;
		int price = 0;
		String search_title = null;
		
		while(flag) {
			System.out.println("1. 책 등록  2. 책 title 검색  3. 전체 출력  4.title 검색 후 책 정보 수정   5.책 삭제  6.종료");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				
				System.out.println("id 입력: ");
				id = sc.next();
				
				System.out.println("author 입력: ");
				author = sc.next();
				
				System.out.println("title 입력: ");
				title = sc.next();
				
				System.out.println("publisher 입력: ");
				publisher = sc.next();
				
				System.out.println("price 입력: ");
				price = sc.nextInt();
				
				service.addMember(new BookVO(id, author, title, publisher, price));
				break;
				
			case 2:
				//search(data);
				System.out.println("검색할 title 입력: ");
				search_title = sc.next();
				
				System.out.println(service.getMember(search_title));
				break;
			case 3:
				//전체 검색
				System.out.println("전체 출력 결과: ");
				service.getAll();
				break;
			case 4:
				//수정
				System.out.println("검색할 id 입력: ");
				id = sc.next();
					
				System.out.println("수정할 author 입력: ");
				author = sc.next();
				
				System.out.println("수정할 title 입력: ");
				title = sc.next();
				
				System.out.println("수정할 publisher 입력: ");
				publisher = sc.next();
				
				System.out.println("수정할 price 입력: ");
				price = sc.nextInt();
				
				BookVO book = new BookVO(id,author,title,publisher,price);
				service.editMember(book);
				break;
			case 5:
				//삭제
				System.out.println("검색할 title 입력: ");
				search_title = sc.next();
				
				service.deleteMember(search_title);
				
				break;
	
			case 6:
				//종료
				flag = false;
				break;
			}
		}
	}
}
