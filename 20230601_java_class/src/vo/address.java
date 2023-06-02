package vo;

public class address {
	private String address = null;
	private String tel = null;
	private String name = null;
	
	public address(String name, String tel, String address) {
		this.address = address;
		this.tel = tel;
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
