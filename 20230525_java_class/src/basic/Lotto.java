package basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> array = new ArrayList<>();
		int[] select_int = new int[6];
		int[] buble_int = new int[6];
		Random random = new Random();
		
		//랜덤숫자 선언
		int random_Num = 0;
		//랜덤숫자 갯수 지정 (로또번호 6개)
		int random_length = 6;
		
		//1~45까지 6개의 로또번호 난수 생성
		for(int i=0; i<random_length; i++) {
			random_Num = random.nextInt(45)+1;
			
			//배열에 해당 난수가 없으면, 즉 중복이 아니면 새 난수 배열에 추가
			if(!array.contains(random_Num)) {
				array.add(random_Num);	
				select_int[i]+= random_Num;
				buble_int[i] += random_Num;
			}
			//중복이면 i-1하여 다시 반복
			else if (array.contains(random_Num)) {
				i--;
			}
		}
		
		//이중 for문 사용하여 선택 정렬
		int temp = 0;
		for(int i=0; i<select_int.length; i++) {
			for(int j=i+1; j<select_int.length; j++) {
				if(select_int[i] > select_int[j]) {
					temp = select_int[i];
					select_int[i] = select_int[j];
					select_int[j] = temp;
				}
			}
		}
		
		//이중 for문 사용하여 버블 정렬		
		temp=0;
		for(int i=0; i<buble_int.length; i++) {
			for(int j=0; j<buble_int.length-1; j++) {
				if(buble_int[j] > buble_int[j+1]) {
					temp = buble_int[j];
					buble_int[j] = buble_int[j+1];
					buble_int[j+1] = temp;
				}
			}
		}
		System.out.print("<오름차순, 이중 for문의 선택정렬>:  ");
		for(int i=0; i<select_int.length; i++) {
			System.out.print(select_int[i]+", ");
		}
		System.out.println("");
		
		System.out.print("<오름차순, 이중 for문의 버블정렬>:  ");
		for(int i=0; i<buble_int.length; i++) {
			System.out.print(buble_int[i]+", ");
		}
		System.out.println("");
		
		
		//오름차순 정렬
		Collections.sort(array);
		System.out.println("(오름차순 배열) 로또 번호는 "+array+" 입니다. ");
			
		//내림차순 정렬
		Collections.sort(array,Collections.reverseOrder());
		System.out.println("(내림차순 배열) 로또 번호는 "+array+" 입니다. ");
		}

}
