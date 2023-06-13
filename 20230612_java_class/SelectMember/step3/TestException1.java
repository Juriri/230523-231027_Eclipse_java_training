package step3;

public class TestException1 {
	public static void main(String[] args) {
		String str = "abc";
		
		
		try {
			//Exception이 발생될 것으로 예상되는 코드블럭
			
			System.out.println("수행 여부 확인");
			
		} catch(NullPointerException e) {
			System.out.println("수행불가");
		}
		
		System.out.println("정상 종료: length는 "+str.length());
		
	}

}
