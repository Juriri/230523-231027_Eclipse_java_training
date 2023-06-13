package step5;

public class Person {
	private String name, tel, address;
	
	Person(String name, String tel, String address){
		this.name = name;
		this.tel = tel;
		this.address = address;
		
	}

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
	
	public String getDeteils() {
		return "이름: "+name+"   전화번호: "+tel+"   주소: "+address;
	}
	
}
