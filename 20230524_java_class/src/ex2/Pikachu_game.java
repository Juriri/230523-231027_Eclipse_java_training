package ex2;

import java.util.Scanner;

public class Pikachu_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int HP=3, tired=3, hungry=3;
		int input_num=0;
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		while(flag) {
			System.out.println("\n피카츄\n \n1.활동하기\n2.잠자기\n3.먹기\n");
			
			input_num = sc.nextInt();
			switch(input_num) {
			case 1:
				if(HP<=0 || tired<=0) {
					System.out.println("피곤한 상태로 활동 불가, 피카츄 죽음");
					flag = false;
				} else {
					HP--;
					hungry--;
					System.out.println("피카츄 활동 완료\n"+"HP: "+HP+"  피곤함: "+tired+" 배고픔: "+hungry);
				}
				break;
			case 2:
				tired++;
				System.out.println("피카츄 잠자기 완료\n"+"HP: "+HP+" 피곤함: "+tired+" 배고픔: "+hungry);
				break;
			case 3:
				HP++;
				hungry++;
				System.out.println("피카츄 먹기 완료\n"+"HP: "+HP+" 피곤함: "+tired+" 배고픔: "+hungry);
			}
		}
		
	}

}
