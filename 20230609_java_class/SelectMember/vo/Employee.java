package vo;
import lombok.Data;

@Data
public class Employee extends Person {
	private int dept;

	
	public Employee() {
		
	}
	public Employee(String name, String tel, String address, int dept) {
		super(name, tel,address);
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [dept=" + dept + ", toString()=" + super.toString() + ", getName()=" + getName()
				+ ", getTel()=" + getTel() + ", getAddress()=" + getAddress() + ", hashCode()=" + hashCode()
				+ ", getClass()=" + getClass() + "]";
	}
	

}
