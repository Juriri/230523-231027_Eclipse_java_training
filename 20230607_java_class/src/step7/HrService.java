package step7;

public class HrService {

	//toString()을 오버라이딩 했으므로 객체의 내용을 출력
	public void printAll(Employee[] group) {
		for(int i=0; i<group.length; i++) {
			System.out.println(group[i].toString());
		}
		
	}
	
	//address만 출력
	public void printByAddress(String address, Employee[] group) {
		for(int i=0; i<group.length; i++) {
			if( group[i].getAddress().equals(address)) {
				System.out.println(address+"와 동일한 검새결과: "+group[i].getName()+" / "+group[i].getAddress());
			}
		}
	}
	
	//연봉
	//자식 객체를 부모 타입이 참조 가능 (다형성)
	//모드 employee의 자식이다. 그러므로 employee로 받는다.
	public void printAnnualSalary(Employee[] group) {
		for(int i=0; i<group.length; i++) {
			System.out.println(group[i].getSalary());
		}
	}
}
