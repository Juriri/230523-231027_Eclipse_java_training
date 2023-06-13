package step2;

class A {
	
}

class B {
	
}

class Service {
	public void pass(A a) {
	}
	
	public void pass(B b) {
		
	}
}
public class TestPoly2 {
	public static void main(String[] args) {
		
		Service s = new Service();
		s.pass(new A());
		s.pass(new B());
		
	}
}
