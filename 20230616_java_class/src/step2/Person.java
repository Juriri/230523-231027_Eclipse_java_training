package step2;

import java.io.Serializable;
import lombok.Data;

@Data
public class Person implements Serializable{
	
	private String name;
	private transient String password; //직렬화 대상에서 제외시키는 제어자
	private String address;
	
	public Person(String name, String password, String address) {
		super();
		this.name = name;
		this.password = password;
		this.address = address;
	}
	
	

}
