package step2;

import java.util.HashMap;

public class FriendVO {
	
	private String name, address;
	private int money;
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public int getMoney() {
		return money;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public FriendVO(String name, String address, int money) {
		super();
		this.name = name;
		this.address = address;
		this.money = money;
	}
	@Override
	public String toString() {
		return "FriendVO [name=" + name + ", address=" + address + ", money=" + money + "]";
	}
	
	
}
