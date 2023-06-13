package step2;

import java.util.HashMap;
import java.util.Set;

public class TestMap2 {
	public static void main(String[] agrs) {
		//HashMap<String, String> map = new HashMap();
		HashMap map = new HashMap();
		
		map.put("a", new FriendVO("손연재", "태릉", 200));
		map.put("b", new FriendVO("크리스탈", "태릉", 200));
		map.put("c", new FriendVO("소지섭", "태릉", 200));
		
		FriendVO vo = (FriendVO) map.get("c");
		System.out.println(vo);
		
		Set set = map.keySet();	
		System.out.println(set);
	}
}
