package step1;

public class OP4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10, b=20;
		
		//&&
		System.out.println(a==10 && b==20); // true 출력
		System.out.println(a>10 && b==20); //  false 출력
		System.out.println(a==10 && b==10); // false 출력
		
		//||
		System.out.println(a==10 || b==20); // true 출력
		System.out.println(a>10 || b==20); //  true 출력
		System.out.println(a==10 || b==10); // true 출력
	}

}
