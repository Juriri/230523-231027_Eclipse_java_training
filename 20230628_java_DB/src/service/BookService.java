package service;

import vo.BookVO;

import java.util.List;

import Dao.Dao;
import Dao.DaoImpl;
import exception.BookNotFoundException;


public class BookService {
	private Dao dao;
	
	public BookService() {
		dao  = new DaoImpl();
	}
	
	public void addMember(BookVO book) {
		// TODO Auto-generated method stub
		dao.bookInsert(book);
		
	}

	
	public BookVO getMember(String search_title) {
		// TODO Auto-generated method stub
		
		return dao.bookSelect(search_title);
	}

	
	public List<BookVO> getAll() {
		return dao.bookSelectAll();
	}
	
	public void editMember(BookVO book) {
		// TODO Auto-generated method stub
		dao.bookSelect(book.getTitle());
		dao.bookUpdate(book);
	}

	
	public void deleteMember(String search_title) {
		// TODO Auto-generated method stub
		dao.bookSelect(search_title);
		dao.bookDelete(search_title);
	}
}
