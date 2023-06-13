package step3;

public class TestException2 {
	public static void main (String[] agrs) {
		String names[] = {"크리스탈","소지섭","황정민"};
		
		try {
			System.out.println(names[1]);
			System.out.println(names[2]);
			
			String s = null;
			System.out.println(s.length());
			
		} catch(ArrayIndexOutOfBoundsException ae) {
			System.out.println("인덱스 범위 초과!");
			
		} catch(Exception e) {
			//Exception 메세지와 발생 경로를 출력한다.
			e.printStackTrace();
		} 
		
		System.out.println("정상 수행");
		
		System.out.println("====================");
		
		int i=0; 
		 
		try {
			System.out.println(4/i);
			
		} catch(NullPointerException np) {
			System.out.println("null 입력 !!");
			
		}finally {
			System.out.println("finally");
		}
		
		System.out.println("정상 수행");
	}

}
