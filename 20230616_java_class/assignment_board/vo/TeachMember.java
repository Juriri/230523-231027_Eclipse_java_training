package vo;
import lombok.Data;

@Data
public class TeachMember extends Member{

	private String subject;
	
	public TeachMember(String Id, String Contents, String subject) {
		super(Id, Contents);
		// TODO Auto-generated constructor stub
		this.subject = subject;
	}

}
