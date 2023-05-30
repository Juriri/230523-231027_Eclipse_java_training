package step3;

import java.util.Scanner;

public class grademain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		grade gr = new grade();
		gr.input(sc);
		gr.avg(gr.total(gr.kor, gr.math, gr.eng));
		gr.print();
		
	}

}
