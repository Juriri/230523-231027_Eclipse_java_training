package service;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public interface Service {
	void add(Product p);
//	ArrayList<Product> getProductsById(String s_id);
	Product getProduct(int num);
	void editProduct(Product p);
	void delProduct(int num);
	int makeNum();
	List<Product> getProductAll();
	Product editQuantity(int q, int num);
}
