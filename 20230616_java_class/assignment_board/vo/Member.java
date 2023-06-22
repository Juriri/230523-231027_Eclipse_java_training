package vo;

import java.io.Serializable;
import lombok.Data;

@Data
public class Member implements Serializable{

	private String Id;
	private String Contents;

	public Member(String Id, String Contents) {
		super();
		this.Id = Id;
		this.Contents = Contents;
	}

}
