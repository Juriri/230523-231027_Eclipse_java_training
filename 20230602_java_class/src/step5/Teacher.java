package step5;

public class Teacher extends Person {
	private String subject;
	
	Teacher(String name, String tel, String address, String subject) {
		super(name, tel, address);
		this.subject = subject;
	}
	
	
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getDeteils() {
		return "선생님: "+ super.getDeteils()+" subject: "+subject;
	}
}