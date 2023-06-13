package service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import vo.Person;

public class Schoolservice {
	private HashMap map = new HashMap();
	
	//동일한 전화번호가 있을 경우,멤버를 추가하지 않음 -> 전화번호 key, Person 계열 객체가 value
	
	public HashMap getMap() {
		return this.map;
	}
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
}
