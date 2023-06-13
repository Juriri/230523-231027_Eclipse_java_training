package service;

import java.util.Scanner;
import java.util.Set;

import vo.MemberVO;
import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class MemberService {
		List<MemberVO> list = new ArrayList<>();
		
		//멤버 등록 (중복된 아이디는 등록불가)
		public void addMember(String id, String name, String tel, String address) {
			
			Set<String> ids = new HashSet<>();
			
			for(int i=0; i<list.size(); i++) {
				ids.add(list.get(i).getId());
			}
			
			
			if(!ids.contains(id)) {
					list.add(new MemberVO(id, name, tel, address));
			}
			else {
				System.out.println("아이디 중복 중복, 멤버 추가가 취소됩니다. ");
			}
		}

		//전체출력
		public void printAll() {
			System.out.println(list);
		}
		
		
		//검색
		public MemberVO findMemberVO(String name) {
			
			int index;
			MemberVO vo = null;
			
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
			MemberVO vo = new MemberVO();
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
	
	
	
	public static void main (String[] agrs) {
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		String id, name, tel, address;
		
		MemberService service = new MemberService();
		
		while(flag) {
			System.out.println("1. 등록  2. 검색  3.수정  4.삭제  5. 전체출력  6.종료");
			int menu = sc.nextInt();
			
			switch(menu) {
				case 1:
					System.out.println("아이디 입력: ");
					id = sc.next();
					System.out.println("이름 입력: ");
					name = sc.next();
					System.out.println("번호 입력: ");
					tel = sc.next();
					System.out.println("주소 입력: ");
					address = sc.next();
					
					service.addMember(id, name, tel, address);
					break;
					
					
				case 2:
					System.out.println("검색할 이름 입력: ");
					name = sc.next();
					service.findMemberVO(name);
					break;
					
					
				case 3:
					System.out.println("삭제할 이름 입력: ");
					name = sc.next();
					service.updateMember(name);
					break;
					
					
				case 4:
					System.out.println("수정할 이름 입력: ");
					name = sc.next();
					service.deleteMember(name);
					break;
					
					
				case 5:
					service.printAll();
					break;
					
					
				case 6: 
					flag = false;
					break;
			}
		}
	}
	

}
