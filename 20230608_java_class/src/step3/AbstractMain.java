package step3;

public class AbstractMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		GrandParent g = new Child();
		
		g.name = "grand papa";
		g.age = 90;
		g.print();
		g.test();
		
		System.out.println("============grand papa============종료");
		
		Child c = new Child();
		
		c.name = "child";
		c.age = 20;
		c.print();
		c.test();
		
		System.out.println("============child============종료");
		
	}

}
