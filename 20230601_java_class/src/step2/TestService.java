package step2;

import java.util.Scanner;
import vo.AddressService;
//import vo.ProductService;
import vo.address;

public class TestService {
	
	public static void main(String[] args) {
		boolean flag=true;
		int menu_num=0;
		Scanner sc = new Scanner(System.in);
		AddressService as = new AddressService();
		//ProductService ps = new ProductService();
		
		String name = null;
		String tel=null;
		String address=null;
		
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
				System.out.println("전화번호: ");
				tel= sc.next();
				System.out.println("주소: ");
				address = sc.next();
				
				as.addPerson(new address(name,tel,address));
				break;
			
			case 2:
				as.printAll();
				break;
			case 3:
				System.out.println("찾을 사람의 이름 입력: ");
				name = sc.next();
				as.findPerson(name);
				break;
			case 4:
				System.out.println("수정할 사람의 이름 입력: ");
				name = sc.next();
				as.editPerson(name);
				
			case 5:
				flag = false;
				break;
				}
		}
	}
}

