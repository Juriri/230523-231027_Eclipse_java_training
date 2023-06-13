package step4;

class Animal{
	
}

class Person extends Animal {
	
}

class Dog extends Animal{
	
	
}
public class TestPoly4 {
	public static void main(String[] args) {
		Animal a = new Person();
		
		if(a instanceof Person) {
			System.out.println("나는 사람이다.");
		} 
		if(a instanceof Dog) {
			System.out.println("나는 개다.");
		}
		if(a instanceof Animal) {
			System.out.println("나는 동물이다.");
		}
	}
}
