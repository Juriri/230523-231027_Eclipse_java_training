package basic;

import java.util.Scanner;

/*과제
 * 세개의 숫자를 입력받아 가장 작은 수 찾기
 */

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input_num1, input_num2, input_num3;
		int Max = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("첫 번째 숫자 입력: ");
		input_num1 = sc.nextInt();
		System.out.println("두 번째 숫자 입력: ");
		input_num2 = sc.nextInt();
		System.out.println("세 번째 숫자 입력: ");
		input_num3 = sc.nextInt();
		
		//1. 첫 번째 > 두 번째 || 세 번째 
		if(input_num1>input_num2) {
			Max = input_num1>=input_num3? input_num1:input_num3;
		//2. 두 번째 	
		} else {
			Max = input_num2>=input_num3? input_num2:input_num3;
		}
		System.out.println("가장 큰 숫자는 "+Max+" 입니다.\n");
	}

}
