package step3;

public class Car {
	static int scount;
	int count;
	
	Car() {
		System.out.println("Car 생성");
		count++;
		scount++;
	}
	
	public static void main(String[] args) {
		Car car1 = new Car();
		System.out.println(car1.count);
		
		Car car2 = new Car();
		System.out.println(car2.count);
		
		Car car3 = new Car();
		System.out.println("car count: "+car3.count);
		
		System.out.println("Car생성자 count: "+Car.scount);
	}
	
	static {
		System.out.println("static 초기화 블럭");
	}//드라이버 설치 같은 것에 사용

}


