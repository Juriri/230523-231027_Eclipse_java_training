package project;

public class Main_date_cal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cal_Date dates = new Cal_Date();
		
		//출발, 목적 날짜 입력
		Cal_Date.getStartDate();
		Cal_Date.getEndDate();
		
		//시간 계산 클래스 함수 호출
		System.out.println(dates.calDate());
		
		
	}
}
