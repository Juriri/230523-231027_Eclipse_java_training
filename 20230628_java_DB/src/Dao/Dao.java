package Dao;


import java.util.ArrayList;
import java.util.List;

import exception.BookNotFoundException;
import vo.BookVO;

public interface Dao {
	
	void con();
	void discon();
	void bookInsert(BookVO book);
	BookVO bookSelect(String id);
	void bookUpdate(BookVO book);
	void bookDelete(String id);
	List<BookVO> bookSelectAll();

}


