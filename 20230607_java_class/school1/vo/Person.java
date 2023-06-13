package vo;

import java.util.Arrays;

public class Person {
	
	private String name, tel, address;


	public String getName() {
		return name;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public Person(String name, String tel, String address) {
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	@Override
	public String toString() {
		return "name=" + name + ", tel=" + tel + ", address=" + address + " ";
	}

	
	
}
