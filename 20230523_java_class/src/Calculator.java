package step1;

import java.util.Scanner;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("숫자 두 개를 입력하세요: ");
		float num1 = sc.nextInt();
		float num2 = sc.nextInt();
		
		System.out.println("연산자 한 개를 입력하세요: +, -,  *,  / ");
		String str = sc.next();
		
		//덧셈 or 뺄셈
		if (str.equals("+") || str.equals("-")) {
			System.out.println(str.equals("+")? Math.round(num1+num2):Math.round(num1-num2));
		}
		
		//곱셈
		else if (str.equals("*")) {
			System.out.println(Math.round(num1*num2));
		}
		
		//나눗셈 소수점 7번재자리까지 출력됨
		else if (str.equals("/")) {
			System.out.println(num1/num2);
		}
		
		//연산자 예외
		else {
			System.out.println("입력값 오류입니다. ");
		}
		sc.close();
	}

}
