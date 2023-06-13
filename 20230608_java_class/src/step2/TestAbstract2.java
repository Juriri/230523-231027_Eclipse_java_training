package step2;



abstract class Vehicle {//추상클래스
	public void go() {
		System.out.println("go");
	}
	
	public abstract void fuel(); //추상 method
	
}

class Truck extends Vehicle {
	
	@Override
	public void fuel() {
		System.out.println("경유 주입");
	}
}

public class TestAbstract2 {
	public static void main(String[] agrs) {
	
		Vehicle v = new Truck();
		v.go();
		v.fuel();
	}
}
