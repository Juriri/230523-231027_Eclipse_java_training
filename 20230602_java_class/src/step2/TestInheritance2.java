package step2;


class GrandParent{
	GrandParent(){
		System.out.println("Grandparent 객체 생성");
		
	}
}

class Parent extends GrandParent {
	Parent(){
		System.out.println("Parent 객체 생성");
	}
}

class Child extends Parent{
	Child(){
		System.out.println("Child 객체 생성");
	}
}

public class TestInheritance2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Child();
	}

}

