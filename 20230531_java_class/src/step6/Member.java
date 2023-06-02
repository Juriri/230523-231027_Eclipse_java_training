package step6;

public class Member {
	String name;
	String tel;
	String address;
	
	Member(){
		name="no name";
		tel="no tel";
		address="no address";
		
	}
	
	Member(String name){
		this.name=name;
		tel="";
		address="";
	}
	Member(String name, String tel, String address){
		this.name=name;
		this.tel=tel;
		this.address=address;
	}
	void print() {
		System.out.println(name);
		System.out.println(tel);
		System.out.println(address);
		
	}
}
