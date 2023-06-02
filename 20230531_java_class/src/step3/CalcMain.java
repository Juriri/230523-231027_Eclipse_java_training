package step3;

public class CalcMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calc cal = new Calc();
		
		while(cal.flag) {
		cal.Input_Data();
		if(cal.op.equals("/")) {
			//나눗셈 연산자이면 return float형 반환 함수 호출
			System.out.println("\n연산결과는 : "+cal.get_D_Result(cal.num1, cal.num2, cal.op));
		} else {
			System.out.println("\n연산결과는 : "+cal.get_Result(cal.num1, cal.num2, cal.op));
			}
		}
	}

}
