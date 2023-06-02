package vo;


public class Product {
	private String name=null, co=null, company=null, cus=null;

	public Product(String name, String co, String company, String cus) {
			this.name = name;
			this.co = co;
			this.company = company;
			this.cus = cus;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCus() {
		return cus;
	}

	public void setCus(String cus) {
		this.cus = cus;
	}
	
	public String toString() {
		String result =null;
		
		System.out.println("");
		return result;
	}
}
