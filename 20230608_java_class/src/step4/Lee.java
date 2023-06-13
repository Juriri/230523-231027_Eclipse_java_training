package step4;

public class Lee extends Overr{
	public int cnt;
	
	public Lee(String name) {
		this.name = name;
		race = "leesagnhae";
		age= 0;
		power=15;
		energy=20;
		cnt=0;
		System.out.println("이상해가 만들어졌습니다.");
	}

	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("이상해 밥먹이기");
		energy++;
		aging();
		
	}

	@Override
	public void sleep() {
		// TODO Auto-generated method stub
		System.out.println("이상해 잠재우기");
		energy++;
		aging();
		
	}

	@Override
	public void exercise() {
		// TODO Auto-generated method stub
		System.out.println("이상해 운동하기");
		power--;
		aging();
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("이상해 공격하기");
		energy++;
		aging();
	}
}
