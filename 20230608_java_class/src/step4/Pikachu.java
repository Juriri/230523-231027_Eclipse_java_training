package step4;

public class Pikachu extends Overr{
	public int cnt;
	
	public Pikachu(String name) {
		this.name = name;
		race = "피카츄";
		age= 0;
		power=20;
		energy=10;
		cnt=0;
		System.out.println("피카츄가 만들어졌습니다.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("피카츄 밥먹이기");
		energy++;
		aging();
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("피카츄 잠재우기");
		energy++;
		aging();
		
	}

	@Override
	public void exercise() {
		// TODO Auto-generated method stub
		System.out.println("피카츄 운동하기");
		power--;
		aging();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("피카츄 공격하기");
		energy++;
		aging();
	}
}