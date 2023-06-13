package step7;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class TestList2 {

	public static void main(String[] args) {
		
		List<FriendVO> list = new ArrayList<>();
		
		list.add(new FriendVO("이름1",1));
		list.add(new FriendVO("이름2",2));
		list.add(new FriendVO("이름3",3));
		list.add(new FriendVO("이름4",4));
		list.add(new FriendVO("이름5",5));
		list.add(new FriendVO("이름6",6));
		list.add(new FriendVO("이름7",7));
		
		System.out.println(list);
		
		//이름만 출력
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		
		
		
	}
}
