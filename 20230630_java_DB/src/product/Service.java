package product;

import java.util.List;

public interface Service {
	void addProduct(Product p);

	Product getByNum(int num);

	Product getByName(String name);

	List getAll();

	void editProduct(Product p);

	void delProduct(int num);
}
