package step3;

import java.util.Scanner;

public class grademain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		grade[] gr = new grade[3];
		Scanner sc = new Scanner(System.in);
		
		String name;
		int kor,eng, math, total=0, sum=0;
		float avg;
		
		for(int i=0; i<gr.length; i++) {
			gr[i] = new grade();
			System.out.println("이름 입력: ");
			gr[i].name = sc.next();
			System.out.println("국어 입력: ");
			gr[i].kor = sc.nextInt();
			System.out.println("수학 입력: ");
			gr[i].math = sc.nextInt();
			System.out.println("영어 입력: ");
			gr[i].eng = sc.nextInt();
			gr[i].total = gr[i].kor + gr[i].eng +gr[i].math;
			gr[i].avg = (float)gr[i].total / gr.length;
		}
		
		for(int i=0; i<gr.length; i++) {
			System.out.println((i+1)+"번째 학생 " + gr[i].name+"의 총합과 평균은 "+gr[i].total+", " +gr[i].avg);
		}
	}
}
