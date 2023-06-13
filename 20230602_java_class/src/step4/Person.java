package step4;


public class Person {
	protected String name,school_num, address;
	int index = 0;
		
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getSchool_num() {
		return school_num;
	}


	public void setSchool_num(String school_num) {
		this.school_num = school_num;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}

	protected void printAll() {
		
		System.out.println("name: "+name + "  / school_num: "+school_num+"  / address: "+address);
	}
}
