package step3;

import java.util.Scanner;

public class Calc {
	int num1, num2;
	String op;
	boolean flag = true;
	
	void Input_Data() {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫 번째 숫자 입력: ");
		num1 = sc.nextInt();
		System.out.println("두 번째 숫자 입력: ");
		num2 = sc.nextInt();
		System.out.println("연산 입력: + / - / * / /===종료 시 '0' 입력");
		op = sc.next();
	}
	
	int get_Result(int num1, int num2, String op) {
		this.op = op;
		
		switch(op) {
			case "+": 
				return num1+num2;
			case "-":
				return num1-num2;
			case "*":
				return num1*num2;
			case "/":
				return num1/num2;
			case "0":
				System.out.println("0 입력으로 종료됩니다. ");
				flag = false;
				return 0;
					
		}
		flag = false;
		return 0;
	}
	
	float get_D_Result(int num1, int num2, String op) {
		this.op = op;
		
		switch(op) {
			case "/":
				return (float)num1/num2;
			case "0":
				System.out.println("0 입력으로 종료됩니다. ");
				flag = false;
				return 0;		
		}
		flag = false;
		return 0;
	}

}
