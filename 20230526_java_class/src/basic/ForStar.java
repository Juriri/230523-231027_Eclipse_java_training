package basic;

import java.util.Scanner;

public class ForStar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("line 수 입력: ");
		int line = sc.nextInt();
		
		for(int i=0; i<line; i++) {
			for(int j=line-i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		System.out.println("====================");
		
		for(int i=0; i<line; i++) {
			for(int k=0; k<i+1; k++) {
				System.out.print(" ");
			}
			for(int j=line-i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
		
		System.out.println("====================");
		
	}

}
