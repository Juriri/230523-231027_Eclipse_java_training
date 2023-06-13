package step2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class TestMap1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i;
		Map<String, String> map = new HashMap<>();
		
		map.put("name","aaa");
		map.put("tel","bbb");
		map.put("address","ccc");
		
		System.out.println("name key 값 검색 후 출력: ");
		System.out.println(map.containsKey("name"));
		
		Object[] keys = map.keySet().toArray();
		System.out.println("key 값 전체 출력: "+keys);
		for(i=0; i<keys.length; i++) {
			System.out.println((String)keys[i]);
		}
		
		System.out.println("key 값 전체 출력: "+keys);
		for(i=0; i<keys.length; i++) {
			System.out.println((String)keys[i]);
		}
	
		
		
	}
}
