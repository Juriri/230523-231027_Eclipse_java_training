package step5;

public class ZooService {
	
	public void printall(Animal a) {
		if(a instanceof Person) { //다운캐스팅, 즉 a라는 변수가 Animal 타입을 밑으로 내려 p에 저장한다.
			Person p = (Person) a;
			p.ticketing();
			
		}
		a.eat();
		a.play();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZooService zoo = new ZooService();
		
		System.out.println("===========");
		zoo.printall(new Monkey());
		System.out.println("===========");
		zoo.printall(new Person());
		System.out.println("===========");
		zoo.printall(new Tiger());
	}

}
