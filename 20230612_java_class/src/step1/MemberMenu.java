package step1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private int menu;
	boolean flag = true;
	private String menuStr = "1. 추가  2. 검색  3. 수정  4. 삭제  5.전체출력  6.데이터초기화  7.종료";
	ArrayList<Member> data  = null;
	
	public void menuProcess(ArrayList<Member> data) {
		
		//int idx=0;
		
		while(flag) {
			System.out.println(menuStr);
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				data.add(infoInput());
				break;
			case 2:
				//search(data);
				printMember(data.get(search(data)));
				break;
			case 3:
				editMember(data);
				break;
			case 4:
				delMember(data);
				break;
			case 5:
				System.out.println(data);
				break;
			case 6:
				data.removeAll(data);
				break;
			case 7:
				flag = false;
				break;
			}
		}
	}
	
	public Member infoInput() {
		System.out.println("이름: ");
		String name  = sc.next();
		
		System.out.println("전화번호: ");
		String tel  = sc.next();
		
		System.out.println("주소: ");
		String address  = sc.next();
		
		
		return new Member(name, tel,address);
	}
	
	public int search(ArrayList<Member> data) {
		System.out.println("이름: ");
		String name  = sc.next();
		
		for(int i=0; i<data.size(); i++)
		{
			if(data.get(i).getName().equals(name)) {
				return i;
			}
		}
		return 0;
	}

	
	public void editMember(ArrayList<Member> data) {
		int idx = search(data);
		
		
		System.out.println("수정 전화번호: ");
		String tel  = sc.next();
		
		System.out.println("수정 주소: ");
		String address  = sc.next();

		
		data.set(idx, new Member(data.get(idx).getName(), tel, address));
		
	}
	
	public void delMember(ArrayList<Member> data) {
		int idx = search(data);
		
		data.remove(idx);
		
	}
	
	public void printMember(Member m) {
		System.out.println(m);
		
	}
}
