package vo;
import lombok.Data;

@Data
public class StuMember extends Member{
	private int stuId;
	
	public StuMember(String Id, String Contents, int stuId) {
		super(Id, Contents);
		// TODO Auto-generated constructor stub
		this.stuId = stuId;
	}

}
