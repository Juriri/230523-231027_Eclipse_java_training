package basic;

public class TestArray1 {
	public static void main(String[] args) {
		int[] ages = new int[3];
		
		System.out.println(ages[0]);
		System.out.println("================");
		
		int[] salary = new int[3];
		salary[0] = 100;
		salary[1] = 200;
		salary[2] = 300;
		
		int sum = 0;
		for (int i=0; i<salary.length; i++) {
			sum += salary[i];
		}
		System.out.println("총합은 "+sum+"입니다. ");
	
	}
}
