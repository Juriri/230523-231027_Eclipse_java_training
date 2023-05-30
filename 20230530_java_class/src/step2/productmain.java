package step2;


public class productmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		product p = new product(); //p는 힙의 주소값을 참조한다.
		p.name ="라면";
		p.Co=10101;
		p.price=1000;
		
		System.out.println(p.name);
		System.out.println(p.Co);
		System.out.println(p.price);
		
	}

}
