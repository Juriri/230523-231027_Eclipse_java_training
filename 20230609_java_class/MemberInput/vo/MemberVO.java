package vo;
 
import lombok.Data;

@Data

public class MemberVO {
	//id, 이름, 전화번호, 주소
	private String id, name, tel, address;
	
	public MemberVO() {
		
	}
	public MemberVO(String id, String name, String tel, String address) {
		super();
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.address = address;
		
	}

}
