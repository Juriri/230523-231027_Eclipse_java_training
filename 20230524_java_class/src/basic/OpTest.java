package basic;
public class OpTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//타입이 같으면 여러 변수를 한 줄에 같이 선언하는 것이 가
		int a = 5, b=2, c=0;
		c=a/b;
		System.out.println(a/b);
		
		c=a%b;
		System.out.println(a%b);
		
		//b는 연산자보다 a값이 먼저 대입되어 6,5 출
		a=5;
		b=0;
		b=a++;
		System.out.println("a:"+a+"\nb:"+b);
		

		a=5;
		b=0;
		b=++a;
		System.out.println("\na:"+a+"\nb:"+b);
		
		a=10;
		a+=1;
		System.out.println("\na:"+a);
		
		a=10;
		a*=2;
		System.out.println("\na:"+a);
	
		
	}

}
