package vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student extends member{
	private String stuId;

	public Student(String id, String name, String tel, String address, int type, String stuId) {
		super(id, name, tel, address, type);
		// TODO Auto-generated constructor stub
		this.stuId = stuId;
	}

	@Override
	public String toString() {
		return "Student [stuId=" + stuId + ", Id=" + getId() + ", Name=" + getName() + ", Tel="
				+ getTel() + ", Address=" + getAddress() + ", Type=" + getType();
	}
}
