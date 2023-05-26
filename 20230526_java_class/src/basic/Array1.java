package basic;

import java.util.Arrays;
import java.util.Scanner;

public class Array1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*다음 배열에 기억된 값 중 , 5보다 큰 수가 몇 개인지 구하시오
		 * 9 1 4 -10 5 12 3 99 8 3
		 */
		boolean flag = true;
		int count = 0;
		int[] arr = new int[10];
		//int[] arr = new int[] {9,1,4,-10,5,12,3,99,8,3};
		Scanner sc = new Scanner(System.in);
		int input;
		
		System.out.println("배열에 들어갈 10개의 숫자를 입력해주세요: ");
		for(int i=0; i<arr.length;i++) {
			System.out.println((i+1)+"번째 수 입력하세요: ");
			arr[i] = sc.nextInt();
		}
		
		int standard = arr[0];
		
		//입력 숫자 배열을 오름차순으로 버블 정렬 시
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > standard)
				count++;
		}
		System.out.println("입력된 숫자의 정렬은 "+Arrays.toString(arr)+"이며, "+standard+" 보다 큰 수의 개수는 "+count+" 입니다. ");
		
		
	}

}
