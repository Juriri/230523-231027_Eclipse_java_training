package step7;


public class TestPoly8 {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee em = new Employee("1234","user1","서울시",1000);
//		private String empId;
//		private String name;
//		private String address;
//		private int salary;
		
		Engineer eg = new Engineer("1234","user2","서울시",2000,"skill",1000);
//		private String skill;
//		private int bonus;

//		private String dept;
		Manager mg = new Manager("1234","user3","판교",3000,"dept");
		
		//캐스팅 업캐스팅 다운캐스팅
		Employee group[] = {em, eg, mg};
		
		HrService service = new HrService();
		service.printAll(group);
		
		//문자열과 객체 배열 비교 
		service.printByAddress("판교",group);
		service.printAnnualSalary(group);
	}

}
