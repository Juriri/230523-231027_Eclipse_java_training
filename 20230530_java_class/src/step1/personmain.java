package step1;

public class personmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//person 클래스는 스택에 위치, new 뒤에 힙에 위치 p를 객체 이름(참조 주소값)
		person p =  new person();
		p.a=1;
		p.b=2;
		
		System.out.println(Integer.toString(p.a)+Integer.toString(p.b));
	}

}
