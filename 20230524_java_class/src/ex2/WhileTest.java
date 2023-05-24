package ex2;

import java.util.Scanner;

public class WhileTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int i=10;
	
	while(i>0) {
		
		System.out.println(i);
		i--;
	}
	//1~100 
	i=1;
	int sum=0;
	
	//for: 정해진 횟수를 반복
	//while: 횟수가 가변일 때 사용.
	while(i<=100) {
		sum += i;
		i++;
	}
	
	System.out.println("sum: "+sum);
	
	
	//사용자가 입력한 숫자들의 합, 입력 횟수 무제한.
	boolean flag = true;
	Scanner sc = new Scanner(System.in);
	int count=0;
	sum=0;
	int input_num=0;
	
	while(flag) {
		System.out.println("숫자 입력해주세요 (종료하려면 0 입력)");
		input_num = sc.nextInt();
		
		if(input_num == 0) {
			flag = false;
			System.out.println("강제종료");
			}
		sum+=input_num;
		count++;
		
		System.out.println("숫자합."+sum+"입력횟수."+count);
		}
	}
}
