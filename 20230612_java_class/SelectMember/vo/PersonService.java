package vo;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class PersonService {
	private HashMap map = new HashMap();
	
	//동일한 전화번호가 있을 경우,멤버를 추가하지 않음 -> 전화번호 key, Person 계열 객체가 value
	
	//등록
	public void addMember(Person p) {
		
			if(!map.containsKey(p.getTel())) {
				map.put(p.getTel(), p);
			}
			else {
				System.out.println(p.getTel()+ "동일한 번호가 존재하여 추가 불가!");
			}
		
	}

	//전체출력
	public void printAll() {
		Iterator it = map.values().iterator();
		
		while(it.hasNext()) {
			//Iterator 생성 코드로 컬렉션의 iterator 메서드는 호출한 컬렉션 요소에 연결된 Iterator를 반환한다.
			System.out.println(it.next());
		}

	}
	
	
	//검색
	public Person findMemberVO(String tel) {
		
		System.out.println(tel+" 전화번호를 검색합니다. ");
		Person p = (Person) map.get(tel); //키 값이 tel인 hashmap에서 value를 p에 반환
		
		if(!map.containsKey(p.getTel())) {
			System.out.println("해당 번호를 가진 사람이 없습니다. ");
		}
		else {
			System.out.println("사람 검색 완료: "+ p);
		
		}
		
		
		return p;
	}
	
	//삭제
	public void deleteMember(String tel) {
		
		System.out.println(tel+" 전화번호인 사람의 정보를 삭제합니다. ");
		Person p = (Person) map.get(tel);
		 
		if(!map.containsKey(p.getTel())) {
			System.out.println("해당 번호를 가진 사람이 없습니다. ");
		}
		else {
			map.remove(tel);
		
		}
	}
	
	//수정
	public void updateMember(String search_tel, Person p) {
		Scanner sc = new Scanner(System.in);
		String tel = null;
		
		System.out.println(search_tel+" 전화번호 사람의 정보를 수정합니다. ");
		 
		if(!map.containsKey(p.getTel())) {
			System.out.println("해당 번호를 가진 사람이 없습니다. ");
		}
		else {
			map.remove(search_tel);  //수정하려면 먼저 삭제 후 값 수정
			System.out.println("수정할 전화번호 입력: ");
			tel = sc.next();
			p.setTel(tel);
			map.put(tel, p);
		}
		//System.out.println("정보 수정 완료: "+map);
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PersonService service = new PersonService();
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
					System.out.println(service.map);
					break;
					
					
				case 6: 
					flag = false;
					break;
			}
		}
	}		
}
