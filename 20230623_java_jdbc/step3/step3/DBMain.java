package step3;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import service.DBService;
import vo.Member;

public class DBMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		DBService service = new DBService();
		
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		String id=null, password=null, name=null, address=null;
		String search_name=null;
		
		while(flag) {
			System.out.println("1. 등록  2. 명단확인  3. 검색   4. 수정  5. 삭제  6. 종료");
			String menu_num = sc.next();
			
			switch(menu_num) {
			case "1":
				System.out.println("insert 구문 입력입니다. ");
				System.out.println("1. id 입력: ");
				id = sc.next();
				System.out.println("2. password 입력: ");
				password = sc.next();
				System.out.println("3. name 입력: ");
				name = sc.next();
				System.out.println("4. address 입력: ");
				address = sc.next();
				
				service.enroll(id, password, name, address);
				break;
			case "2":
				ArrayList<Member> result_arr = service.list();
				for(int i=0; i<result_arr.size(); i++)
					System.out.println(result_arr.get(i));
				break;
			case "3":
				System.out.println("검색 이름을 입력하세요. ");
				search_name = sc.next();
				System.out.println(service.search(search_name));
				break;
			case "4":
				System.out.println("수정 이름을 입력하세요. ");
				search_name = sc.next();
				System.out.println(service.update(search_name));
				break;
			case "5":
				System.out.println("삭제할 이름을 입력하세요. ");
				search_name = sc.next();
				service.delete(search_name);
				break;
			case "6":
				flag = false;
				break;
			default: 
				System.out.println("숫자 입력 오류입니다. 다시 입력하세요: ");
			}
		}
	}

}
