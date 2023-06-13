package step5;

public class Student extends Person{
	private String stuId;
	
	Student(String name, String tel, String address, String stuID) {
		super(name, tel, address);
		this.stuId = stuID;
	}
	
	public String getStuId() {
		return stuId;
	}
	public String getDeteils() {
		return "학생: " +super.getDeteils()+" stuId: "+stuId;
	}
}