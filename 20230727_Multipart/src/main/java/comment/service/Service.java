package comment.service;

import java.util.List;

import model.Comment;


public interface Service {
	void add(Comment comment);
	List<Comment> selectAllByP_num(int product_num);
	Comment getComment(int num);
	void editComment(Comment comment);
	void delComment(int num);
}
