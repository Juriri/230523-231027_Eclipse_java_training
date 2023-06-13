package vo;

import lombok.Data;

@Data
public class Person {
	protected String name, tel, address;

	
	public Person(String name, String tel, String address) {
		super();
		this.name = name;
		this.tel = tel;
		this.address = address;
	}
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", tel=" + tel + ", address=" + address + "]";
	}
}
