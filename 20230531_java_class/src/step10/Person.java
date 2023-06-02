package step10;

public class Person {
	private String name;
	//Car 객체의 주소값을 담기 위해서 car을 선언하고
	//참조형 데이터 타입은 클래스 명이 된다.
	private Car car;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	
	
	
}
