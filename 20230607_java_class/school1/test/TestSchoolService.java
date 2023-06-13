package test;

import vo.Employee;
import vo.Student;
import vo.Teacher;
import service.SchoolService;


public class TestSchoolService {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Employee em = new Employee("em1", "010","판교", 111);
		
		Student st = new Student("stu1","011","구리",112);

		Teacher te = new Teacher("te1","012","영등포","수학");
		
		//캐스팅 업캐스팅 다운캐스팅
		
		SchoolService service = new SchoolService();
//		service.setGroup(em);
//		service.setGroup(st);
//		service.setGroup(te);
		
//		
//		//ArrayList 출력
//		System.out.println("========Person List=========: ");
//		service.printAll();
//		System.out.println("============================: ");
//		//사람 추가
//		System.out.println("ArrayList 추가: ");
//		service.addPerson(new Student("stu2","019","잠실",132));
//		service.printAll();
//		System.out.println("============================: ");
//		//주소 출력 
//		System.out.println("ArrayList 주소 출력: ");
//		service.printByAddress();
//		System.out.println("============================: ");
		
	}

}
