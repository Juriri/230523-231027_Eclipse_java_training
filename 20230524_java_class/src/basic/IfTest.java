package basic;

public class IfTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 5;
		
		if(a==3) {
			System.out.println("a는 3");
		}
		
		if(a==5) {
			System.out.println("a는 5이다.");
		}
		
		String name = "aaa";
		if(name.equals("aaa")) {
			System.out.println("이름이 같다.");
		}
		
		
		//짝수 홀수 구
		int num = 2;
		
		if(num%2 == 0) {
			System.out.println("짝수.");
		}else {
			System.out.println("홀수.");
		}
		
		
		int x=3;
		if(x==1) {
			System.out.println("x는 1");
		}else if(x==2) {
			System.out.println("x는 2");
		}else if(x==3) {
			System.out.println("x는 3");
		}else if(x==4) {
			System.out.println("x는 4");
		}else {
			System.out.println("범위 밖의 값.");
		}
	
	}

}
