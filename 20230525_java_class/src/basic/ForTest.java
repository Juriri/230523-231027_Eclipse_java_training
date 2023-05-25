package basic;

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
		for(int i=1; i<=100; i++) {
			System.out.print(" 3*"+i+" = "+(3*i));
			
			if((i%10)==0)
				System.out.println();
		}
		System.out.println("==============================");
		
		//짝수 계산
		int count=0;
		
		for(int i=1; i<=100; i++) {
			if((i%2)==0) {
				System.out.print(i+", ");
				count++;
			}
		}
		System.out.println("짝수의 개수는 "+count+" 입니다.\n");
	}

}
