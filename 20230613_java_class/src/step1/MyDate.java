package step1;

public class MyDate {
	//날짜는 1일부터 31일까지만 가능합니다. 
	private String day;
	
	public MyDate(String day) throws DateException {
	//정수형 변환
	//연산을 위해 정수형으로 변환
	int i = Integer.parseInt(day);

	if(i<1 || i>31) {
		throw new DateException("날짜는 1일부터 31일까지만 가능합니다. ");
	}
	}

}
