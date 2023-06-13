package test;

import java.util.Scanner;

import service.Schoolservice;
import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

public class TestSchoolService {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Schoolservice service = new Schoolservice();
		Person p = null;
		boolean flag = true;
		
		String name, tel,address;
		int dept;
		String stuId, subject;
		String search_tel; 
		
		
		while(flag) {
			System.out.println("1. 등록  2. 검색  3.수정  4.삭제  5. 전체출력  6.종료");
			int menu = sc.nextInt();
			
			switch(menu) {
			//1. 등록
				case 1:
					System.out.println("이름 입력: ");
					name = sc.next();
					System.out.println("전화번호 입력: ");
					tel = sc.next();
					System.out.println("주소 입력: ");
					address = sc.next();
					
					System.out.println("1. 교직원   2. 학생   3. 선생님");
					int num = sc.nextInt();
					
					if(num==1) {
						System.out.println("dept 입력: ");
						dept = sc.nextInt();
						p = new Employee(name, tel, address, dept);						
					}else {
						if(num==2) {
							System.out.println("stuId 입력: ");
							stuId = sc.next();
							p = new Student(name, tel, address, stuId);
							
						} else {
							System.out.println("subject 입력: ");
							subject = sc.next();
							p = new Teacher(name, tel, address, subject);
						}
					}
					
					service.addMember(p);
					break;
					
				//2. 검색
				case 2:
					System.out.println("검색할 전화번호 입력: ");
					search_tel = sc.next();
					service.findMemberVO(search_tel);
					break;
					
				//3. 수정	
				case 3:
					System.out.println("수정할 전화번호 입력: ");
					search_tel = sc.next();
					service.updateMember(search_tel,service.findMemberVO(search_tel));
					break;
					
				//4. 삭제
				case 4:
					System.out.println("삭제할 전화번호 입력: ");
					search_tel = sc.next();
					service.deleteMember(search_tel);
					break;
					
					
				case 5:
					System.out.println(service.getMap());
					break;
					
					
				case 6: 
					flag = false;
					break;
			}
		}
	}
}
