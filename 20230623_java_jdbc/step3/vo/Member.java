package vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	String id;
	String password;
	String name;
	String address;
	
	
	@Override
	public String toString() {
		return id + " "+ password + " "+ name + " "+ address;
	}
	
	
}
