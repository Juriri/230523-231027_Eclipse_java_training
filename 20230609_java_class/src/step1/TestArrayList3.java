package step1;

import java.util.List;
import java.util.ArrayList;

public class TestArrayList3 {
	
	public static void main(String[] agrs) {
		List<ProductVO> list = new ArrayList<>();
		list.add(new ProductVO("아이폰","애플",200));
		list.add(new ProductVO("갤럭시","삼성",300));
		list.add(new ProductVO("넥서스","삼성",400));
		
		int total=0;
		
		System.out.println("리스트로부터 삼성에서 생성한 제품명 출력"+list);
		
		for(int i=0; i<list.size(); i++) {
			
			if(list.get(i).getMaker().equals("삼성")) {
				System.out.println(list.get(i));
			}
			System.out.println("전체 가격 출력");
			total += list.get(i).getPrice();
		}
		
		System.out.println("가격의 총합은 "+total);
		
	}

}
