package basic;

import java.util.Scanner;

public class ForTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		
		for(int i=1; i<=10; i++) {
			sum+=i;
			System.out.print(i+", ");
		}
		System.out.println("총합은 "+sum+" 입니다.");
		
		System.out.println("==============================");
		
		//3단 곱셈
		sum = 1;
		System.out.println("3단 구구단 시작");
		for(int i=1; i<=100; i++) {
			System.out.print(" 3*"+i+"="+(3*i)+"\t");
			
			if((i%10)==0)
				System.out.println();
		}
		System.out.println("==============================");
		
		//짝수 계산
		int count=0;
		
		for(int i=1; i<=100; i++) {
			if((i%2)==0) {
				//System.out.print(i+", ");
				count++;
			}
		}
		System.out.println("1-100까지 짝수의 개수는 "+count+" 입니다.\n");
		System.out.println("==============================");
		
		//짝수의 총합 계산
/*		sum=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("목표 숫자 입력: ");
		int input_num = sc.nextInt(); 
		 
		for(int i=1; i<=input_num; i++) {
			if ((input_num%2)==0) {
				sum += i;
			}
		}
		
		System.out.println("입력하신 숫자까지 짝수의 총합은 : "+sum);
		System.out.println("==============================");
*/		
		
		int num= 1;
		sum=0;
		Scanner sc = new Scanner(System.in);
		
		while(num!=0) {
			System.out.println("입력하신 숫자까지의 총합을 계산합니다.\n숫자를 입력하세요. (0 입력시 종료됨.)");
			num = sc.nextInt();
			
			sum+=num;
			System.out.println("총합은 :  "+sum);
			
			if(sum >100) {
				System.out.println("총합이 "+sum+"으로 100을 초과하여 자동 종료됩니다. ");
				num=0;
			}
			
		}
		
		System.out.println("==============================");
		
		
		num= 1;
		sum=0;
		
		while(num!=-999) {
			System.out.println("입력하신 숫자까지의 총합을 계산합니다.\n숫자를 입력하세요. (-999 입력시 종료됨.)");
			num = sc.nextInt();
			
			sum+=num;
			System.out.println("총합은 :  "+sum);
			
			if(sum >100) {
				System.out.println("총합이 "+sum+"으로 100을 초과하여 자동 종료됩니다. ");
				num=0;
			}
			
		}
		
		System.out.println("==============================");
	}

}
