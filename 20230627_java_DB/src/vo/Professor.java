package vo;

import lombok.*;

@Data
@NoArgsConstructor
public class Professor extends member{
	private String dept;

	public Professor(String id, String name, String tel, String address, int type, String dept) {
		super(id, name, tel, address, type);
		// TODO Auto-generated constructor stub
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Professor [dept=" + dept + ", Id=" + getId() + ", Name=" + getName() + ", Tel="
				+ getTel() + ", Address=" + getAddress() + ", Type=" + getType();
	}
}
