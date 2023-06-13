package vo;

import java.util.Scanner;

import java.util.Set;

import service.MemberService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import vo.Person;
import vo.Employee;
import vo.Student;
import vo.Teacher;;

public class PersonService {
	
	List<Person> list = new ArrayList<>();
	
	public void addMember(String name, String tel, String address) {
		
		Set<String> ids = new HashSet<>();
		
		for(int i=0; i<list.size(); i++) {
			ids.add(list.get(i).getName());
		}
		
		
		if(!ids.contains(name)) {
				list.add(new Person(name, tel, address));
		}
		else {
			System.out.println("이름 중복 중복, 멤버 추가가 취소됩니다. ");
		}
	}

	//전체출력
	public void printAll() {
		System.out.println(list);
	}
	
	
	//검색
	public Person findMemberVO(String name) {
		
		int index;
		Person vo = null;
		
		System.out.println(name+" 이 이름 사람을 검색합니다. ");
		 
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(name)) {
				index = i;
				vo = list.get(i);
			}
		}
		
		System.out.println("사람 검색 완료: "+vo);
		
		return vo;
	}
	
	public void deleteMember(String n) {
		int index=-1;
		
		System.out.println(n+" 이 이름 사람의 정보를 삭제합니다. ");
		 
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(n)) {
				index = i;
			}
		}
		
		if(index == -1) {
			System.out.println("해당 이름을 가진 사람의 정보가 없습니다. 삭제불가");
		}
		else {
			list.remove(index);
		}
	}
	
	//수정
	public void updateMember(String n) {
		int index=-1;
		Scanner sc = new Scanner(System.in);
		Person vo = new Person();
		String name, tel, address;
		
		System.out.println(n+" 이 이름 사람의 정보를 수정합니다. ");
		 
		
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getName().equals(n)) {
				index = i;
			}
		}
		
		if(index == -1) {
			System.out.println("해당 이름을 가진 사람의 정보가 없습니다. 수정불가");
		}
		else {
			System.out.println("수정할 이름을 입력하세요 : ");
			name = sc.next();
			System.out.println("수정할 번호를 입력하세요 : ");
			tel = sc.next();
			System.out.println("수정할 주소를 입력하세요 : ");
			address = sc.next();
			
			
			list.get(index).setName(name);
			list.get(index).setTel(tel);
			list.get(index).setAddress(address);
			
			System.out.println("정보 수정 완료: "+list.get(index));
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PersonService service = new PersonService();
		Person p = null;
		boolean flag = true;
		
		String name, tel,address;
		int dept;
		String stuId, subject;
		String search_name; 
		
		
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
					
					service.list.add(p);
					
					break;
					
				//2. 검색
				case 2:
					System.out.println("검색할 이름 입력: ");
					search_name = sc.next();
					service.findMemberVO(search_name);
					break;
					
				//3. 수정	
				case 3:
					System.out.println("수정할 이름 입력: ");
					search_name = sc.next();
					service.updateMember(search_name);
					break;
					
				//4. 삭제
				case 4:
					System.out.println("삭제할 이름 입력: ");
					search_name = sc.next();
					service.deleteMember(search_name);
					break;
					
					
				case 5:
					System.out.println(service.list);
					break;
					
					
				case 6: 
					flag = false;
					break;
			}
		}
	}		
}
