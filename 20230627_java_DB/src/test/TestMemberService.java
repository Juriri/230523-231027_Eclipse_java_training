package test;

import java.util.Scanner;

import service.MemberService;
import vo.*;

public class TestMemberService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String id=null, name=null, tel=null, address=null, etc=null;
		int type = 0;
		String[] tag = {"","job","dept","school"}; // job=employees, dept=professor, school=student
		String search_id = null;
		
		Scanner sc = new Scanner(System.in);
		boolean flag =true;
		
		MemberService service = new MemberService();
		
		while(flag) {
			System.out.println("1. 제품등록  2. 제품검색  3. 전체검색  4.수정   5.삭제  6.종료");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				
				System.out.println("그룹 선택  1. 교직원  2.교수  3.학생 ");
				type = sc.nextInt();
				
				System.out.println("id 입력: ");
				id = sc.next();
				
				System.out.println("name 입력: ");
				name = sc.next();
				
				System.out.println("tel 입력: ");
				tel = sc.next();
				
				System.out.println("address 입력: ");
				address = sc.next();
				
				System.out.println("tag[type] 입력: ");
				etc = sc.next();
				
				
				switch(type) {
				case 1:
					service.addMember(new Employee(id, name, tel, address, type, etc));
					break;
				case 2:
					service.addMember(new Professor(id, name, tel, address, type, etc));
					break;
				case 3:
					service.addMember(new Student(id, name, tel, address, type, etc));
					break;
				default: 
					System.out.println("입력값 오류");
					
				}
				break;
				
			case 2:
				//search(data);
				System.out.println("검색할 id 입력: ");
				search_id = sc.next();
				System.out.println(service.getMember(search_id));
				break;
			case 3:
				//전체 검색
				System.out.println("전체 타입입력 1.교직원  2.교수  3.학생 ");
				int search_type = sc.nextInt();
				System.out.println(service.print(search_type));
				break;
			case 4:
				//수정
				System.out.println("검색 id 입력: ");
				search_id = sc.next();
				if(service.getMember(search_id) != null) {
					String new_etc=null;
					
					System.out.println("수정할 이름 입력: ");
					name = sc.next();
					System.out.println("수정할 tel 입력: ");
					tel = sc.next();
					System.out.println("수정할 address 입력: ");
					address = sc.next();
					
					int cmp_type = service.getMember(search_id).getType();
					
					switch(cmp_type) {
					
					case 1:
						System.out.println("수정할 job 입력: ");
						new_etc = sc.next();
						service.editMember(new Employee(search_id, name, tel, address, cmp_type, new_etc));
						break;
					case 2:
						System.out.println("수정할 dept 입력: ");
						new_etc = sc.next();
						service.editMember(new Professor(search_id, name, tel, address, cmp_type, new_etc));
						break;
					case 3:
						System.out.println("수정할 stuId 입력: ");
						new_etc = sc.next();
						service.editMember(new Student(search_id, name, tel, address, cmp_type, new_etc));
						break;
					default: 
						System.out.println("해당 id를 가진 검색 결과없음: ");
						break;
					}
					
				}
				else
					System.out.println("해당 id를 가진 검색 결과없음: ");
				
				break;
			case 5:
				//삭제
				System.out.println("검색할 id 입력: ");
				search_id = sc.next();
				service.deleteMember(search_id);
				break;
	
			case 6:
				//종료
				flag = false;
				break;
			}
		}
	}
}
