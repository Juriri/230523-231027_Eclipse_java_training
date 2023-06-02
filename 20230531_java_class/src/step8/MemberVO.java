package step8;

public class MemberVO {
	//전역변수는 클래스 블럭에서 벗어나지 않도록 막아둔다.
	//vo 또는 dto(data를 찍어내기 위한 클래스에 활용됨.)
	private String id,password;
	private int money;
	
	public MemberVO(String id, String password, int money) {
		super();
		this.id = id;
		this.password = password;
		this.money = money;
	}
	
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}

}
