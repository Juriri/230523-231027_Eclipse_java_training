package step4;

import java.util.Scanner;

public class Addr {
	String name="", tel="", addr="";
	static Scanner sc = new Scanner(System.in);
	
	void register() {
	
			System.out.println("사람 이름 입력: ");
			name = sc.next();
			System.out.println("전화번호 입력: ");
			tel = sc.next();
			System.out.println("주소 입력: ");
			addr= sc.next();
	}
	
	boolean search(String str2) {
			if(name.equals(str2)) {
				return true;
			}
			else {
				return false;
			}
	}
	
	void print() {
			System.out.println("사람 이름: "+name+" 전화번호: "+tel+" 주소: "+addr);
	}
}
