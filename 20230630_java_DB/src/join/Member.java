package join;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Member {
	String id;
	String pwd;
	String name;
	String email;

}
