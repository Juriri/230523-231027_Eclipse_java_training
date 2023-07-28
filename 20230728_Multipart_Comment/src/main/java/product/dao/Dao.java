package product.dao;

import java.util.ArrayList;
import java.util.List;

import model.Product;

public interface Dao {
	int selectNum();
	
	void insert(Product p);

	List<Product> selectAllById(String s_id);
	
	Product select(int num);
	
	void update(Product p);
	
	void delete(int num);
	
	List<Product> selectAll();
	
	void updateQuantity(int q, int num);
}
