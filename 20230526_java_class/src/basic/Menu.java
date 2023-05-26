package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] name = new String[3];
		boolean flag = true;
		int i=0,number=0;
		
		while(flag) {
			System.out.println("1.이름 입력: ");
			System.out.println("2.전체 출력: ");
			System.out.println("3.종료: \n");
			
			number = sc.nextInt();
			
			switch(number) {
			case 1: 
				for(i=0; i<3; i++) {
					System.out.println((i+1)+".이름 입력: \n");
					name[i] = sc.next();
				} 	break;
			case 2: 
					System.out.println(Arrays.toString(name));
					break;
			case 3: 
				System.out.println("강제 종료");
					flag = false;
			}
		}
		sc.close();
	}

}
