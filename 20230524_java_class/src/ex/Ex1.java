package ex;

import java.util.Scanner;

public class Ex1 {
/*키보드로 입력받아
 * 점수 91~100 수
 * 점수 81~90  우
 * 점수 71 ~80 미
 * 점수 61 ~70 양
 * 점수 60이하  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int input_no = sc.nextInt();
		
		if(input_no >= 91 && input_no <=100) {
			System.out.println("수.");
		}else {
			
			if(input_no >= 81) {
				System.out.println("우.");	
			}else if(input_no >= 71) {
				System.out.println("미.");
			}else if(input_no >= 61) {
				System.out.println("양.");
			}else  {
				System.out.println("가.");
			}
		}
		
	sc.close();
	}

}
