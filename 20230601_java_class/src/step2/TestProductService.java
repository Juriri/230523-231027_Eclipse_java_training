package step2;

import java.util.Scanner;

import vo.ProductService;
import vo.Product;

public class TestProductService {	
	public static void main(String[] args) {
		boolean flag=true;
		int menu_num=0;
		Scanner sc = new Scanner(System.in);
		ProductService ps = new ProductService();
		
		String name, co, company, cus;
		
		while(flag) {
			System.out.println("1. 등록");
			System.out.println("2. 전체출력");
			System.out.println("3. 검색");
			System.out.println("4. 수정");
			System.out.println("5. 종료");
		
			menu_num = sc.nextInt();
		
			switch(menu_num) {
			case 1:
				System.out.println("이름: ");
				name = sc.next();
				System.out.println("제조사: ");
				co= sc.next();
				System.out.println("회사명: ");
				company = sc.next();
				System.out.println("거래처: ");
				cus = sc.next();
				
				ps.addPerson(new Product(name,co, company, cus));
				
				break;
			
			case 2:
				ps.printAll();
				break;
			case 3:
				System.out.println("찾을 사람의 이름 입력: ");
				name = sc.next();
				ps.findPerson(name);
				break;
			case 4:
				System.out.println("수정할 사람의 이름 입력: ");
				name = sc.next();
				ps.editPerson(name);
				break;
			case 5:
				flag = false;
				break;
				}
		}
	}
}

