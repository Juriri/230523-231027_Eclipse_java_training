package board.service;

import java.util.ArrayList;
import java.util.List;

import model.Board;
import board.dao.Dao;
import board.dao.DaoImpl;


public class ServiceImpl implements Service {
	private Dao dao;

	public ServiceImpl() {
		this.dao = new DaoImpl();
	}

	@Override
	public void writeBoard(Board board) {
		// TODO Auto-generated method stub
		dao.insert(board);
	}

	@Override
	public Board getBoard(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> getAll() {
		// TODO Auto-generated method stub
		return dao.selectAll();
	}

	@Override
	public void editBoard(Board board) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delBoard(int num) {
		// TODO Auto-generated method stub
		
	}

	

}
