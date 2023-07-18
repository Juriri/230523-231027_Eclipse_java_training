<<<<<<< HEAD
package model;

public class Member {
	int num;
	String name;
	String tel;
	String address;
	String Postal;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostal() {
		return Postal;
	}
	public void setPostal(String postal) {
		Postal = postal;
	}
	public Member(String name, String tel, String address, String postal) {
		super();
		
		this.name = name;
		this.tel = tel;
		this.address = address;
		Postal = postal;
	}
	
	public Member(int num, String name, String tel, String address, String postal) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.address = address;
		Postal = postal;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + ", address=" + address + ", Postal=" + Postal
				+ "]";
	}
	
	
}
=======
package model;

public class Member {
	int num;
	String name;
	String tel;
	String address;
	String Postal;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostal() {
		return Postal;
	}
	public void setPostal(String postal) {
		Postal = postal;
	}
	public Member(String name, String tel, String address, String postal) {
		super();
		
		this.name = name;
		this.tel = tel;
		this.address = address;
		Postal = postal;
	}
	
	public Member(int num, String name, String tel, String address, String postal) {
		super();
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.address = address;
		Postal = postal;
	}
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", tel=" + tel + ", address=" + address + ", Postal=" + Postal
				+ "]";
	}
	
	
}
>>>>>>> refs/remotes/origin/main
