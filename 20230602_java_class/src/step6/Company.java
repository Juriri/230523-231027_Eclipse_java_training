package step6;

public class Company {
	private String name;
	private String address;
	
	Company(String name, String address) {
		this.name = name;
		this.address = address;
	}
	
	@Override
	public String toString() {
		return "회사명 [name= "+ name + ", address=" + address;
	}
	
	public static void main(String[] args) {
		Company c1 = new Company("안랩","판교");
		System.out.println(c1);
		System.out.println(c1.toString());
		
	}
}
