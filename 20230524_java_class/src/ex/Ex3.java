package ex;

import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하여주세요: ");
		int score = sc.nextInt();
		//score = score / 10;
		
		switch(score/10) {
		case 10,9:
			System.out.println("A학점입니다..");
			break;
		case 8:
			System.out.println("B학점입니다..");
			break;
		case 7:
			System.out.println("C학점입니다..");
			break;
		case 6:
			System.out.println("D학점입니다..");
			break;
		default: 
			System.out.println("낙점입니다..");
			
		}
	sc.close();
	}

}
