package step4;

public class PersonMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Professor pr = new Professor();
		pr.setName("교수1");
		pr.setSchool_num("1234");
		pr.setAddress("addr_1234");
		pr.setSubject("수학,영어");
		pr.printAll();
		pr.print_subject();
		
		System.out.println("=========================");
		Staff st = new Staff();
		st.setName("스탭1");
		st.setSchool_num("5678");
		st.setAddress("addr_5678");
		st.setJob("staff");
		st.printAll();
		st.print_job();

	}

}
