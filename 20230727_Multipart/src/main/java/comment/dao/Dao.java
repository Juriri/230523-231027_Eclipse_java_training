package comment.dao;

import java.util.List;

import model.Comment;

public interface Dao {
	
	void insert(Comment comment);
	
	Comment select(int num);
	
	void update(Comment p);
	
	void delete(int num);
	
	List<Comment> selectAllByP_num(int product_num);
	
}
