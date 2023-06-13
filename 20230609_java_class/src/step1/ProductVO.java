package step1;


public class ProductVO {
	
	private String name, maker;
	
	private int price;
	public ProductVO(String name, String maker, int price) {
		super();
		this.name = name;
		this.maker = maker;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public String getMaker() {
		return maker;
	}
	public int getPrice() {
		return price;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMaker(String maker) {
		this.maker = maker;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", maker=" + maker + ", price=" + price + "]";
	}
	
	
	

}
