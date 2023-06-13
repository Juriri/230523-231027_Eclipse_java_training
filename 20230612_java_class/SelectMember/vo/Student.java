package vo;

import lombok.Data;

@Data
public class Student extends Person{
	private String stuId;

	public Student() {
		
	}
	public Student(String name, String tel, String address, String stuId) {
		super(name, tel, address);
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + "," + ", getName()=" + getName()
				+ ", getTel()=" + getTel() + ", getAddress()=" + getAddress() + "]";
	}


}
