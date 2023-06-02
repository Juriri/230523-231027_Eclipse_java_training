package step10;

public class TestHasA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person p = new Person();
		p.setName("아이유");
		p.setCar(new Car("kia","black"));
		System.out.println(p.getName());
		System.out.println(p.getCar()); //#출력 시 car의 주소값만 나옴
		System.out.println(p.getCar().getModel()); //#car의 주소값을 이용하여 실제의 Car의 model 값 반환
		
		p.getCar().setModel("sm5");
		p.getCar().setColor("white");
		System.out.println(p.getName()+" "+p.getCar().getModel()+" "+p.getCar().getColor());
		//System.out.println(p.getCar().getModel());
	}

}
