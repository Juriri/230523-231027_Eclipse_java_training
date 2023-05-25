package ex2;
//피카추 키우기 게임
import java.util.Scanner;

public class Pikachu_game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int HP=10, exp=0, level=0;
		int input_num=0;
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		while(flag) {

			System.out.println("\n===피카츄 키우기===\n \n1.활동하기\n2.잠자기\n3.먹기\n4.상태확인\n");
			input_num = sc.nextInt();
			
			switch(input_num) {
			//활동하기
			case 1:
				if(HP<=0) {
					System.out.println("피곤한 상태로 활동 불가, 피카츄 죽음");
					flag = false;
				} else {
					HP--;
					exp++;
					if(exp>=5) {
						level +=1;
						exp = 0;
					}
					System.out.println("피카츄 활동 완료\n"+"HP: "+HP+"  경험치: "+exp+" level: "+level);
				}
				break;
			//잠자기
			case 2:
				HP++;
				System.out.println("피카츄 잠자기 완료\n"+"HP: "+HP+" 경험치: "+exp+" level: "+level);
				break;
			//먹기
			case 3:
				HP++;
				System.out.println("피카츄 먹기 완료\n"+"HP: "+HP+" 경험치: "+exp+" level: "+level);
			//상태확인
			case 4:
				System.out.println("피카츄 상태 확인\n"+"HP: "+HP+" 경험치: "+exp+" level: "+level);
			}
		}
		
	}

}
