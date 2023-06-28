package dao;

import java.util.List;

import vo.Board;

public interface BoardDao {
	
	void con();
	void discon();
	void BoadInsert(Board board);
	Board BoardSelect(String id);
	void BoardUpdate(Board board);
	void BoardDelete(String id);
	List<Board> BoardSelectAll();

}
