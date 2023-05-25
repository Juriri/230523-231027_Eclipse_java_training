package project;

import java.util.Scanner;

public class Get_date {
	static int year, month, date;
	static String input_str = "";
	
	void Input_date() {
		//boolean flag = true;	
		//Get_date d = new Get_date();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("날짜를 입력하세요:  형식 -> 0000/00/00");
		input_str=sc.next();
		
		year = Integer.parseInt(input_str.substring(0,4));
		month = Integer.parseInt(input_str.substring(5,7));
		date = Integer.parseInt(input_str.substring(8,10));
		
	}

}
