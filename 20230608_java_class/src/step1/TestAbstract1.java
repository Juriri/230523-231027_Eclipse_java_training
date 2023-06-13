package step1;
//abstract method 하나 이상 가지고 있으면 그 클래스는 abstract class로 선언되어야한다.
abstract class Parent {

	public void eat() {
		System.out.println("먹다");
	}
	
	//abstract method는 구현부가 없다. 
	//자식 클래스가 abstract가 되어야한다. (객체생성 안됨)
	
	public abstract void study();
		
		
}

class Child extends Parent {

	@Override
	public void study() {
		// TODO Auto-generated method stub
		System.out.println("공부하다");
	}
	
}

public class TestAbstract1 {
	
	public static void main(String[] args) {
		
		Child c = new Child();
		System.out.println("=====Child class======");
		c.eat();
		c.study();
		
		System.out.println("=====다형성 class======");
		Parent p1 = new Child();
		p1.eat();
	}
}