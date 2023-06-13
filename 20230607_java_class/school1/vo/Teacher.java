package vo;

public class Teacher extends Person{

	private String subject; 
	
	public Teacher(String name, String tel, String address, String subject) {
		super(name, tel, address);
		// TODO Auto-generated constructor stub
		this.subject = subject;
	}
	
	@Override
	public String toString() {
		return super.toString() + "subject: "+subject;
	}
	

}
