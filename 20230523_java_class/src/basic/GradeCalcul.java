package basic;

import java.util.Scanner;

public class GradeCalcul {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String number = sc.nextLine();
		//int number = sc.nextInt();
	    int score = Integer.parseInt(number);
		
	    if (score > 100)
	    	System.out.println("점수 입력 오류, 100이상");
	    else if(score >=90)
			System.out.println("A 등급 획득");
		else if(score >=70)
			System.out.println("B 등급 획득");
		else
			System.out.println("낙제");
	    
	    
	    int score2 = sc.nextInt();
	    
	    //음수 양수
	    String str1 = "양수입니다.";
	    String str2 = "음수입니다.";
	    String str3= "0 입니다."; 
	    
	    System.out.println(score2>=0? (score2==0? str3 : str1) : str2);
	    
	   /* if(score2< 0)
	    	System.out.println("입력하신 숫자 " + score2+"는 음수입니다. ");
	    else if(score2 >0)
	    	System.out.println("입력하신 숫자 " + score2+"는 양수입니다. ");
	    else
	    	System.out.println("입력하신 숫자 " + score2+"는 0. "); */
	    
	}

}
