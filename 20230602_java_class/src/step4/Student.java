package step4;



public class Student extends Professor{
	private String job;
	
	public String st_print_job() {
		
		return " job: "+job; 
		
	}
	
	public void print_subject() {
		Professor pr = new Professor();
		System.out.println("이름  "+name+"의 수강하는 과목은 "+pr.getSubject());
	}
}
