package step2;

import java.util.Scanner;

public class product {
	String name;
	int Co;
	int price;
	
	void input(Scanner sc) {
		System.out.println("name 입력: ");
		name=sc.next();
		System.out.println("Co 입력: ");
		Co=sc.nextInt();
		System.out.println("가격 입력: ");
		price = sc.nextInt();
	}
	
	void print() {
		System.out.println("name: "+name+" Co: "+Co+" price: "+price);
	}
}
