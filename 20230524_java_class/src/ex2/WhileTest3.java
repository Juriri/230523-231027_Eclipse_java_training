 package ex2;

import java.util.Scanner;

public class WhileTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = true;
		int input_num=0;
		float num1=0, num2=0;
		
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			System.out.println("1.더하기\n2.뺄셈\n3.곱셈\n4.나눗셈\n5.종료");
			input_num = sc.nextInt();
			
			if(input_num == 1) {
				System.out.println("첫 번째 숫자 입력: ");
				num1 = sc.nextInt();
				System.out.println("두 번째 숫자 입력: ");
				num2 = sc.nextInt();
				System.out.println("\n연산결과: "+(int)num1+"+"+(int)num2+"="+Math.round(num1+num2));
				
			} else {
				if(input_num == 2) {
					System.out.println("첫 번째 숫자 입력: ");
					num1 = sc.nextInt();
					System.out.println("두 번째 숫자 입력: ");
					num2 = sc.nextInt();
					System.out.println("\n연산결과: "+(int)num1+"-"+(int)num2+"="+Math.round(num1-num2));
					
				} else {
					if(input_num == 3) {
						System.out.println("첫 번째 숫자 입력: ");
						num1 = sc.nextInt();
						System.out.println("두 번째 숫자 입력: ");
						num2 = sc.nextInt();
						System.out.println("\n연산결과: "+(int)num1+"*"+(int)num2+"="+Math.round(num1*num2));
					} else if(input_num == 4){
						System.out.println("첫 번째 숫자 입력: ");
						num1 = sc.nextInt();
						System.out.println("두 번째 숫자 입력: ");
						num2 = sc.nextInt();
						System.out.println("\n연산결과: "+(int)num1+"/"+(int)num2+"="+(num1/num2));	
					}
					else {
						System.out.println("강제종료합니다.");
						flag = false;
					}
						
				}
			}
		}
	}
}
