package basic;

public class TestArray2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//전체 성적을 합하기 위한 정수형의 sum의 변수 선언
		//평균값을 구하기 위한 실수형의 변수 선언 30명
		
		int[] es = new int[30];
		float average;
		int i=0, sum=0;
		
		for(i=0, sum=0; i<30; i++) {
			es[i] = i;
			sum += es[i];
		}
		
		average = sum/30;
		System.out.println("전제 성적과 평균은 "+sum+" / "+average);
	}

}
