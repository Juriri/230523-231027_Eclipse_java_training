package step3;

import java.util.Scanner;

public class grade {
	String name;
	int kor,eng,math;
	int total;
	float avg;
	
	void input(Scanner sc) {
		System.out.println("이름을 입력하세요: ");
		name = sc.next();
		System.out.println("국어 점수 입력하세요: ");
		kor = sc.nextInt();
		System.out.println("영어를 입력하세요: ");
		eng = sc.nextInt();
		System.out.println("수학을 입력하세요: ");
		math = sc.nextInt();
	}
	
	int total(int kor, int math, int eng) {
		total = kor+math+eng;
		return total;
	}
	
	void avg(int total) {
		avg = (float) total / 3;
	}
	
	void print() {
		System.out.println("국어 / 영어 / 수학 / 총점은 "+kor+", "+math+", "+math+", "+total);
		System.out.println(name+"의 평균 점수는 "+avg+"입니다. ");
	}

}
