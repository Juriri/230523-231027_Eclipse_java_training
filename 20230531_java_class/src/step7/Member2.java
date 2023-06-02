package step7;

public class Member2 {
	String name;
	String tel;
	String address;
	
	public Member2(String anme, String tel, String address) {
		super();
		this.name = anme;
		this.tel = tel;
		this.address = address;
	}
	
	void print() {
		System.out.println(name+tel+address);
	}

}
