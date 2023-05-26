package basic;
import java.util.Scanner;
import java.util.Arrays;

public class Array2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*다음 배열에 기억된 값 중 , 5보다 큰 수가 몇 개인지 구하시오
		 * 9 1 4 -10 5 12 3 99 8 3
		 */
		int count = 0;
		int[] arr = new int[10];
		int[] order = new int[10];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("배열에 들어갈 10개의 숫자를 입력해주세요: ");
		
		for(int i=0; i<arr.length;i++) {
			System.out.println((i+1)+"번째 수 입력하세요: ");
			arr[i] = sc.nextInt();
			order[i] = arr[i];
		}
		
		System.out.println("입력된 숫자는 "+Arrays.toString(arr)+"입니다.");
		int standard = arr[0];
		
		//입력 숫자 배열을 오름차순으로 버블 정렬 시
		for(int i=0; i<order.length; i++) {
			for(int j=0; j<order.length-1; j++) {
				if(order[j] > order[j+1]) {
					int temp = order[j];
					order[j] = order[j+1];
					order[j+1] = temp;
				}
			}
		}
		for(int i=0; i<order.length; i++) {
			if(order[i] > standard)
				count++;
		} 
		int Max =order[9];
		System.out.println("오름차순 정렬 완료 값 "+Arrays.toString(order)+"이며, "+standard+" 보다 큰 수의 개수는 "+count+" 입니다. ");
		System.out.println(Arrays.toString(arr)+"가장 큰 수는 "+Max+" 이며, 해당 위치는 "+(Arrays.binarySearch(arr, Max)+1)+" 번째 숫자입니다. ");
		
	}

}
