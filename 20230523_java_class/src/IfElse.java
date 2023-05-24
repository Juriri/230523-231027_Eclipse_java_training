package step1;
import java.util.*;

public class IfElse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();	
		boolean flag = false;
		
		
		if (num1 > num2) 
			System.out.println("첫 번째 숫자 " + num1+"이 " +num2+"보다 큽니다. ");
		
		else 
			System.out.println("두 번째 숫자 " + num2+"이 " +num1+"보다 큽니다. ");
		
		
		int num3 = sc.nextInt();
		int num4 = sc.nextInt();
		
		if (num3==10 && num4>=20)
			System.out.println("조건을 만족함");
		
		else 
			System.out.println("조건을 만족하지 않음");
	}

}
