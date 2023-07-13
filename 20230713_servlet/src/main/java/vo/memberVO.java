package vo;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class memberVO {
	private String id;
	private String name;
	private String address;
	private String password;

}
