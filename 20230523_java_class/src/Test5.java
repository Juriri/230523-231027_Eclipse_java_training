package step1;

import java.util.Scanner;

public class Test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("숫자 두 개를 입력하세요: ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
	
		System.out.println(num1>=num2? (num1==num2? "같은 수":"첫번째 수 더 큼") :"두번째 수 더 큼");	
		
		sc.close();
		
	}

}
