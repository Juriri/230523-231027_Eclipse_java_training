package step1;

public class TestPerson {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		
		String new_name = "새이름";
		int new_money = 1000;
		
		p.setName(new_name);
		p.setMoney(new_money);
		System.out.println(p.getName()+", "+p.getMoney());
	}

}
