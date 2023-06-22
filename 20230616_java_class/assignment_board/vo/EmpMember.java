package vo;
import lombok.Data;

@Data
public class EmpMember extends Member{
	private String dept;
	
	public EmpMember(String Id, String Contents, String dept) {
		super(Id, Contents);
		// TODO Auto-generated constructor stub
		this.dept=dept;
	}
}
