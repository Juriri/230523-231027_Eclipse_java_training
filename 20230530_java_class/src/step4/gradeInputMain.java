package step4;

import java.util.Scanner;

public class gradeInputMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		gradeInput[] gr = new gradeInput[3];
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<gr.length; i++) {
			gr[i] = new gradeInput();
			gr[i].input(sc);
			gr[i].avg(gr[i].total(gr[i].kor, gr[i].math, gr[i].eng));
			gr[i].print();	
		}
	}

}
