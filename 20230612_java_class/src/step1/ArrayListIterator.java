package step1;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> str_arr = new ArrayList<>();
		str_arr.add("aaa");
		str_arr.add("bbb");
		str_arr.add("ccc");
		
		Iterator<String> i = str_arr.iterator();
		
		while(i.hasNext()) {
			//Iterator 생성 코드로 컬렉션의 iterator 메서드는 호출한 컬렉션 요소에 연결된 Iterator를 반환한다.
			System.out.println(i.next());
		}

	}

}
