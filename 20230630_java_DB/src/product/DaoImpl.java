package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import board.Board;
import join.DBConnect;

public class DaoImpl implements Dao {
	private DBConnect db = DBConnect.getInstance();
	private Connection conn = db.getConnection();
	private PreparedStatement pstmt;
	@Override
	public void insert(Product p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Product selectByNum(int num) {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	public Product selectByName(String name) {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		
		return null;
	}
	@Override
	public void update(Product p) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		
	}

	
}
