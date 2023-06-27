package vo;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Employee extends member{


	private String job;

	public Employee(String id, String name, String tel, String address, int type, String job) {
		super(id, name, tel, address, type);
		// TODO Auto-generated constructor stub
		this.job = job;
	}

	@Override
	public String toString() {
		return "Employee [job=" + job + ", Id=" + getId() + ", Name=" + getName() + ", Tel=" + getTel()
				+ ", Address=" + getAddress() + ", Type=" + getType();
	}
}
