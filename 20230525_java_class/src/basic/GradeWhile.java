package basic;

import java.util.Scanner;

public class GradeWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score=111;
		Scanner sc = new Scanner(System.in);
		
		while(score<0 || score>100) {
			System.out.println("점수를 입력하세요: (0-100)");
			score = sc.nextInt();
			
			if(score >=90) {
					System.out.println("A 등급 획득");
			} else {
				if(score >=80)
					System.out.println("B 등급 획득");
				else if(score >=70)
					System.out.println("C 등급 획득");
				else
					System.out.println("당신은 낙제");
		    }
		}
		sc.close();
	}
}
