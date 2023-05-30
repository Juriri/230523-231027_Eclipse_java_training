package step6;

public class Person {
		//String subject ="";
		//생성자 매개변수 String 추가
		Person(String subject) {
			System.out.println(subject + "공부하다");
		}
		
		int wake(int num) {
			System.out.println(num*num);
			return num*num;
		}
		
		String order(int price) {
			String str = "가격은 "+Integer.toString(price) +" 입니다. ";
			return str;
		}

}
