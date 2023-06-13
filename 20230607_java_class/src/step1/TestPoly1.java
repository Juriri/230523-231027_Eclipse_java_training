package step1;

class Person extends Animal{
	public void eat() { //오버라이딩
		System.out.println("사람이 수저로 먹다. ");
	}
	
	public void study() {
		System.out.println("사람이 공부하다.  ");
	}
}

class Dog extends Animal{
	public void eat() { //오버라이딩
		System.out.println("개가 사료를 먹다. ");
		
	}
	
	public void bark() {
		System.out.println("개가 왕왕짓다.  ");
	}
}


public class TestPoly1 {
	public static void main(String[] args) {
		Animal a = new Person(); //객체는 부모생성자 Person을 따라감 , 업캐스팅
		a.sleep(); //부모로 부터 상속받은 메서드 호출가능
		a.eat(); //메서드 오버라이딩되어 자신의 메서드 호출
		//a.study(); 참조변수가 부모 타입이므로 인식 불가
		Person p = (Person) a; //객체 캐스팅 (다운캐스팅)
		p.study();
		
		Animal a2 = new Dog();
		a2.sleep();
		a2.eat();
		//a2.bark();
	}
}