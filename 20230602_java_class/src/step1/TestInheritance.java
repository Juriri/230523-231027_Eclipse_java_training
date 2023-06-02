package step1;


class Animal{ //extend Object(생략되었음)
	int age=1;
	
	Animal() {
		System.out.println("먹다.-부모 클래스 생성");	
	}
	
	protected void eat() {
		System.out.println("먹다.");
	}
	
}

class Person extends Animal{ 
	public void study() {
		System.out.println("공부하다.");
	}
	
}


public class TestInheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p= new Person();
		p.study(); //자식 클래스 메소드
		p.eat(); //부모 클래스 메소드
		
	}

}
