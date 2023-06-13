package service;

import vo.Employee;
import vo.Person;
import vo.Student;
import vo.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class SchoolService {
	private ArrayList<Person> group = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	private boolean flag = true;
	
	public SchoolService() {
		while(flag) {
			System.out.println("1. 등록  2. 출력  3.종료");
			int num = sc.nextInt();
			
			switch(num) {
			case 1:
				System.out.println("학생, 선생님, 교직원 중 맞는 이름 입력:  ");
				String str = sc.next();
				if(str.equals("학생")) {
					System.out.println("이름 입력: ");
					String name = sc.next();
					System.out.println("번호 입력: ");
					String tel = sc.next();
					System.out.println("주소 입력: ");
					String address = sc.next();
					System.out.println("학생 숫자 입력: ");
					int stuId = sc.nextInt();
					setGroup(new Student(name, tel, address, stuId));
					break;
				}
				
				else if(str.equals("선생님")) {
					System.out.println("이름 입력: ");
					String name = sc.next();
					System.out.println("번호 입력: ");
					String tel = sc.next();
					System.out.println("주소 입력: ");
					String address = sc.next();
					System.out.println("과목 입력: ");
					String subject = sc.next();
					setGroup(new Teacher(name, tel, address, subject));
					break;
				}
				
				else {
					System.out.println("이름 입력: ");
					String name = sc.next();
					System.out.println("번호 입력: ");
					String tel = sc.next();
					System.out.println("주소 입력: ");
					String address = sc.next();
					System.out.println("dept 입력: ");
					int dept = sc.nextInt();
					setGroup(new Employee(name, tel, address, dept));
					break;
				}
			case 2:
				printAll();
				break;
			case 3: 
				flag = false;
				break;
			}
		}
		
	}
	
	public void setGroup(Person p) {
		group.add(p);
	}

	
	public void printAll() {
		for(int i=0; i<group.size(); i++) {
			System.out.println(group.get(i).toString());
		}
		
	}
	
	//사람 추가
	public void addPerson(Person p) {
		group.add(p);
		
	}
	

}
