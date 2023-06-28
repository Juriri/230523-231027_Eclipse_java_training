package service;

import java.util.List;

import dao.BoardDao;
import dao.BoardDaoImpl;
import vo.Board;

public class BoardService {
	private BoardDao dao;
	
	public BoardService() {
		dao  = new BoardDaoImpl();
	}
	
	public void addMember(Board board) {
		// TODO Auto-generated method stub
		dao.BoadInsert(board);
		
	}

	
	public Board getMember(String search_id) {
		// TODO Auto-generated method stub
		
		return dao.BoardSelect(search_id);
	}

	
	public List<Board> getAll() {
		return dao.BoardSelectAll();
	}
	
	public void editMember(Board board) {
		// TODO Auto-generated method stub
		dao.BoardSelect(board.getId());
		dao.BoardUpdate(board);
	}

	
	public void deleteMember(String search_id) {
		// TODO Auto-generated method stub
		dao.BoardSelect(search_id);
		dao.BoardDelete(search_id);
	}
}
