package comment.service;

import java.util.List;

import model.Comment;
import comment.dao.Dao;
import comment.dao.DaoImpl;


public class ServiceImpl implements Service {
	private Dao dao;

	public ServiceImpl() {
		this.dao = new DaoImpl();
	}

	public void add(Comment comment) {
		// TODO Auto-generated method stub
		dao.insert(comment);
	}

	public List<Comment> selectAllByP_num(int product_num) {
		// TODO Auto-generated method stub
		return dao.selectAllByP_num(product_num);
	}

	public Comment getComment(int num) {
		// TODO Auto-generated method stub
		return dao.select(num);
	}

	public void editComment(Comment p) {
		// TODO Auto-generated method stub
		dao.update(p);
		
	}

	public void delComment(int num) {
		// TODO Auto-generated method stub
		dao.delete(num);
	}


}
