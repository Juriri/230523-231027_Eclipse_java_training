package vo;

import lombok.Data;

@Data
public class Teacher extends Person{
	private String subject;

	public Teacher(String name, String tel, String address, String subject) {
		super(name, tel, subject);
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [subject=" + subject + ","+ "getName()=" + getName()
				+ ", getTel()=" + getTel() + ", getAddress()=" + getAddress() + "]";
	}
	
	

}
