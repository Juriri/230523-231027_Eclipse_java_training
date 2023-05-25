package basic;

import java.util.Scanner;
import java.util.ArrayList;

//어떤 수를 나누어떨어지게 하는 수를 그 약수라고 하며, 입력된 숫자의 약수를 구하고 집합에 정리하
public class DivisorWhile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag = true;
		int devide = 2;
		
		Scanner sc = new Scanner(System.in);
		//약수 집합 생성
		ArrayList<Integer> array = new ArrayList<>();
		//약수 1 삽입
		array.add(1);
		
		System.out.println("약수를 구할 숫자를 입력하라.");
		int input_no = sc.nextInt();

		while(flag && input_no != 1) {
					//1. 약수가 아닐 때 나눔수 증가
					if((input_no % devide) != 0) {
						devide++;
						//나눔수가 입력수까지 도달하면 반복문 종료
						if(devide == input_no) {
							array.add(devide);
							flag  = false;
						}
					}
					//2.약수일 때 배열에 삽입
					else if (input_no % devide == 0) {
						array.add(devide);
						//나눔수 증가
						devide++;
					}
		}
		System.out.println("약수는 "+array+"입니다. \n");
	}

}
