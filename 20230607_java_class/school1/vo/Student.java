package vo;

public class Student extends Person{
	
	private int stuId;

	public Student(String name, String tel, String address, int stuId) {
		super(name, tel, address);
		// TODO Auto-generated constructor stub
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return super.toString() + "stuId: "+stuId;
	}
	
}
