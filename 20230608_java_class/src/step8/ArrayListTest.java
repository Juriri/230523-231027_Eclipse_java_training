package step8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<String> a1 = new ArrayList<>();
		
		for(int i=0; i<10; i++) {
			a1.add(i+"숫자");
		}
		
		System.out.println(a1);
		
		
		//해당 문자를 가진 위치 출력
		System.out.println("검색할 문자열 입력: ");
		String str = sc.next();
		
		int index=0;
		if(a1.contains(str)) {
			index = a1.indexOf(str);
			System.out.println((index+1)+"번째 자리에 있는 문자열-> " + a1.get(index));
		}
		
		
		//해당 문자를 가진 위치 출력 후 삭
		System.out.println("검색할 문자열 입력: ");
		str = sc.next();
				
		index=0;
		if(a1.contains(str)) {
			System.out.println("수정할 문자열 입력: ");
			String str2 = sc.next();
			a1.set(a1.indexOf(str), str2);
		}
		System.out.println(a1);
	}
}
