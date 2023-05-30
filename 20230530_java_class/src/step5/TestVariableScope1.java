package step5;

public class TestVariableScope1 {
	int i;
	//인스턴스 변수 i를 가르킨다.
	void test1() {
		System.out.println("test"+i);
		
	}
	
	void test2(){
		int i=1;
		System.out.println("test2 지역 변수 " +i);
		System.out.println("test2 인스턴스 변수 " +this.i);
	}
	
	void test3(int i) {
		System.out.println("test3 지역 변수" +i);
		this.i = i;
		System.out.println("test3 인스턴스 변수" +this.i);
	}
}
