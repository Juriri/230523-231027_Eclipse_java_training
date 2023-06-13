package step4;

public class Gobbuk extends Overr{
	public Gobbuk(String name) {
		this.name = name;
		race = "꼬북이";
		age= 0;
		power=10;
		energy=30;
		
		System.out.println("꼬북이가 만들어졌습니다.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("꼬북이 밥먹이기");
		energy++;
		aging();
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("꼬북이 잠재우기");
		energy++;
		aging();
		
	}

	@Override
	public void exercise() {
		// TODO Auto-generated method stub
		System.out.println("꼬북이 운동하기");
		power--;
		aging();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("꼬북이 공격하기");
		energy++;
		aging();
	}
}
