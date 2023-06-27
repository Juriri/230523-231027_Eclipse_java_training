package vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class member {
	private String id;
	private String name; 
	private String tel;
	private String address;
	private int type;
}
