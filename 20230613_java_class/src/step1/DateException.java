package step1;

public class DateException extends Exception {
	public DateException(String message) {
		super(message);
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		
		return "오류입니다.";
	}

}
