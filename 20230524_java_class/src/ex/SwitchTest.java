package ex;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*키보드로 학년 입력받아 작성*/

		Scanner sc = new Scanner(System.in);
		int input_no = sc.nextInt();
		
		switch(input_no) {
		case 1: 
			System.out.println("1학년.");
			break;
		case 2:
			System.out.println("2학년.");
			break;
		case 3:
			System.out.println("3학년.");
			break;
		default:
			System.out.println("오류.");
			
		}
	    
		
				
	sc.close();
	}
}

