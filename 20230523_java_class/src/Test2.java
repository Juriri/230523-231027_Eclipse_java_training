package step1;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input_no;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("정수를 입력하세요 : ");
		input_no = sc.nextInt();
		
		if (input_no > 0)
			System.out.println("음수입니다.");
		else {
			if(input_no==0) 
				System.out.println("0 이군요");
			else
				System.out.println("0 보다 작다");
		}
		sc.close();
	}

}
