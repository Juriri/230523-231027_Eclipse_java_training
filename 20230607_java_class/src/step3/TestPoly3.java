package step3;


class Animal {
	public void eat() {
		System.out.println("먹다");
	}
	
}

class Person extends Animal {
	//메서드 오버라이딩
	public void eat() {
		System.out.println("사람이 식당에서 먹다");
	}
	
}

class Dog extends Animal{
	//메서드 오버라이딩
	public void eat() {
		System.out.println("개가 사료를 먹다.");
	}
}

class Tiger extends Animal {
	public void eat() {
		System.out.println("호랑이가 생닭을 먹는다");
	}
}


class ZooService {
	//Animal의 계층 구조 형성으로 다형성 지원
	//Animal 타입의 변수에 다양한 자식 객체를 처리할 수 있다.
	public void pass(Animal a) {
		a.eat(); //동일한 eat()라는 메세지로 다양한 형태의 수행이 가능하다.
	}
}

public class TestPoly3 {
	public static void main(String[] args) {
		ZooService zoo = new ZooService();
		
		zoo.pass(new Person());
		zoo.pass(new Dog());
		zoo.pass(new Tiger());
	}
}
