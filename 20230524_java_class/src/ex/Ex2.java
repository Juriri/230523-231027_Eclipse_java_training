package ex;

import java.util.Scanner;

/* 4, 6, 9, 11월: 30일
 * 2: 28일
 1,3,5,7,8,10,12월: 31일*/

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.println("월 입력하세요: \n");
		int month = sc.nextInt();
		
//		switch(month) {
//		case 4,6,9,11 :
//			System.out.println("30일 입니다.");
//			break;
//		case 2 :
//			System.out.println("28일 입니다.");
//			break;
//		case 1,3,5,7,8,10,12 :
//			System.out.println("31일 입니다.");
//			break;
//		default:
//			System.out.println("오류.");
//		
//		}
		
		if(month==4 || month==6 || month==9 || month==11 ) {
			System.out.println("30일.");
		}else {
			if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12) {
				System.out.println("31일.");
			}else if(month == 2) {
				System.out.println("28일.");
			}else {
				System.out.println("오류.");
			}
		}
	}

}
