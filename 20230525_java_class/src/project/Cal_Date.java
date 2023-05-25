package project;

import java.util.ArrayList;
import java.util.Arrays;

public class Cal_Date {
	
	static int start_date,end_date;
	static int start_month,end_month;
	static int start_year,end_year;

	ArrayList<Integer> month_long = new ArrayList<>(Arrays.asList(1,3,5,7,8,10,12));
	ArrayList<Integer> month_medium = new ArrayList<>(Arrays.asList(4,6,9,11));
	ArrayList<Integer> month_short = new ArrayList<>(Arrays.asList(2));
	
	public static void getStartDate() {
		Get_date start_d = new Get_date();
		start_d.Input_date();
		start_year = Get_date.year;
		start_month = Get_date.month;
		start_date = Get_date.date;
		
		//System.out.println("입력한 출발 날짜: "+start_year+" "+start_month+" "+start_date+" ");
	}
	
	public static void getEndDate() {
		Get_date end_d = new Get_date();
		end_d.Input_date();
		end_year = Get_date.year;
		end_month = Get_date.month;
		end_date = Get_date.date;
		
		//System.out.println("입력한 목적 날짜: "+end_year+" "+end_month+" "+end_date+" ");
	}
	
	public String calDate() {		
		int year_result=0, month_result=0, date_result=0;
		//int total_date=0;
		
		System.out.println("\n입력한 시작날짜 출력: "+start_year+"년 "+start_month+"월 "+start_date+"일 ");
		System.out.println("입력한 종료날짜 출력: "+end_year+"년 "+end_month+"월 "+end_date+"일\n");
		
		year_result = end_year - start_year;
		month_result = end_month - start_month;
		date_result = end_date - start_date;
		
		if(date_result < 0) {
			//홀수달일 시 31일
			if(month_long.contains(month_result)){ 
				date_result += 31;
				month_result -= 1;
			} else {
				//짝수 (2월 제외) 일 시 30일
				if(month_medium.contains(month_result)) {
					date_result += 30;
					month_result -= 1;
				}
				//2월을 28일로 계산
				else {
					date_result += 28;
					month_result -= 1;
				}
				
			}
		}
		
		if(month_result < 0) {
			month_result +=12;
			year_result -=1;
		}
		
		/*date 계산 미완
		if(month_long.contains(month_result)) {
			total_date = (year_result * 365) + (month_result * 31) + (date_result);
		} else if(month_medium.contains(month_result)) {
			total_date = (year_result * 365) + (month_result * 30) + (date_result);
		} else {
			total_date = (year_result * 365) + (month_result * 28) + (date_result);
		}*/
		
		return "두 날짜의 차이 계산 결과: "+year_result+"년 "+month_result+"개월 "+ date_result+"일 입니다. ";
		
	}

}
