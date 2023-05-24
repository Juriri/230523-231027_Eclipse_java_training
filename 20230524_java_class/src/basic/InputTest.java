package basic;
import java.util.Scanner;
//자동 util 추가는 cnt+shift+m

public class InputTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		//nextLine()) 한글 잘 깨짐, null값과 space 값 입력
	    
		
		System.out.println("이름 입력: ");
		String name = sc.next();
		System.out.println("이름 : " + name);
		
		sc.close();
		
	}

}
