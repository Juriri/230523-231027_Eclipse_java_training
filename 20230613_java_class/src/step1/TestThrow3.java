package step1;

public class TestThrow3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		try {
			MyDate date = new MyDate("31");
			//System.out.println(date.getDay(null));
			
		}catch(DateException e) {
			System.out.println(e.getMessage());
		}
	}

}
