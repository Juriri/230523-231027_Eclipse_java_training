package boarddao;

import java.util.List;
import boardvo.Board;

public interface BoardDao {

	void BoadInsert(Board board);
	Board BoardSelect(String id);
	void BoardUpdate(Board board);
	void BoardDelete(String id);
	List<Board> BoardSelectAll();
}
