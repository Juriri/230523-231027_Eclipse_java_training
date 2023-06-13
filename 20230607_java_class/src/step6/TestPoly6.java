package step6;

class Vehicle {
	public int num;
	public void go() {
		System.out.println("움직이다.");
	}
}


class Car extends Vehicle {
	public void go() {
		System.out.println("자동차가 움직이다.");
	}
}

class Airplane extends Vehicle {
	public int air_num;
	public void fly() {
		System.out.println("비행기가 날다");
	}

}


public class TestPoly6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//다형성이 적용되므로 Vehicle 부모 타입의 배열에 
		Vehicle vh[] = {new Vehicle(), new Car(), new Airplane()};
		
		for(int i=0; i<vh.length; i++) {
			vh[i].go();
			System.out.println(vh[i].num);
			if(vh[i] instanceof Airplane) { //다운캐스팅
				Airplane a = (Airplane) vh[i];
				a.fly();
				System.out.println(a.air_num);
			}
			
		}
	}

}
