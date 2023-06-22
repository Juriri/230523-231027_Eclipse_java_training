package step1;

import java.util.Scanner;

public class ContMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cont c = new Cont();
		
		Scanner sc = new Scanner(System.in);
		int i;
		boolean flag = true;
		
		while(flag) {
			System.out.println("1. 일기  2. 쓰기  3. 종료");
			i= sc.nextInt();
			switch(i) {
			case 1:
				c.read();
				
				break;
			case 2:
				c.write();
				break;
			case 3:
				flag=false;
				break;
				
			}
		}
	}

}
