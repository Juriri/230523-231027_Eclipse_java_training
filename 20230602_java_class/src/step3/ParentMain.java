package step3;

public class ParentMain {

	public static void main(String[] args) {
		Parent p = new Parent();
		p.name = "부모";
		p.age = 50;
		
		System.out.println("Parent name: "+p.getName());
		System.out.println("money: "+p.getMoney());
		System.out.println("==========================");
		
		Child c = new Child();
		c.name = "자식";
		c.age = 29;
		
		c.printParentInfo();
		c.pirntInfo();
	}

}
