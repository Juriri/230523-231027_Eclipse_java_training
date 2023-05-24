package ex;

import java.util.Scanner;

public class EI2 {
	public static void main(String[] args) {
		
		System.out.println("숫자 두 개를 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		float num1 = sc.nextInt();
		float num2 = sc.nextInt();
		
		System.out.println("연산자 한 개를 입력하세요: +, -,  *,  / ");
		String str = sc.next();
		
		switch(str) {
		//덧셈 or 뺄셈 or 곱셈 or 나눗셈.
		case "+":
			System.out.println(Math.round(num1+num2));
			break;
		case "-":
			System.out.println(Math.round(num1-num2));
			break;
		case "*":
			System.out.println(Math.round(num1*num2));
			break;
		case "/":
			System.out.println(num1/num2);
			break;
		default: 
			System.out.println("입력값 오류입니다. ");}
		
		sc.close();
}

}

