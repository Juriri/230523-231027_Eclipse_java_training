package boardservice;

import java.util.ArrayList;
import java.util.List;

import boarddao.BoardDao;
import boardvo.Board;
import DBcon.dbcon;

public class BoardService implements BoardDao{

	@Override
	public void BoadInsert(Board board) {
		// TODO Auto-generated method stub
		dbcon.con();
		
		String sql = "insert into board values(?,?,?)";
		try {
			dbcon.pstmt = dbcon.conn.prepareStatement(sql);
			
			dbcon.pstmt.setString(1, board.getId());
			dbcon.pstmt.setString(2, board.getTitle());
			dbcon.pstmt.setString(3, board.getContents());
			
			dbcon.pstmt.execute();
			
			dbcon.discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Board BoardSelect(String Search_id) {
		// TODO Auto-generated method stub
		dbcon.con();
		Board board= null;
		String id=null, title=null, contents=null;
		
		String sql = "select * from board where id = ?";
		try {
			dbcon.pstmt = dbcon.conn.prepareStatement(sql);
			dbcon.pstmt.setString(1, Search_id);
			dbcon.rs=dbcon.pstmt.executeQuery();
			
			if (dbcon.rs.next()) {
				id = dbcon.rs.getString(1);
				title = dbcon.rs.getString(2);
				contents = dbcon.rs.getString(3);
			
				board = new Board(id, title, contents);
			}
			
			dbcon.discon();
			dbcon.pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return board;
	}

	@Override
	public void BoardUpdate(Board board) {
		// TODO Auto-generated method stub
		dbcon.con();
		
		String sql = "update book set title=?, contents=? where id=?";
		
		try {
			dbcon.pstmt = dbcon.conn.prepareStatement(sql);
			
			dbcon.pstmt.setString(1, board.getTitle());
			dbcon.pstmt.setString(2, board.getContents());
			dbcon.pstmt.setString(3, board.getId());
			
			dbcon.pstmt.execute();
			
			dbcon.discon();
		} catch(Exception e) {
			e.getStackTrace();
		}
		
	}

	@Override
	public void BoardDelete(String search_id) {
		// TODO Auto-generated method stub
		dbcon.con();
		
		String sql = "delete board where id=?";
		try {
			dbcon.pstmt = dbcon.conn.prepareStatement(sql);
			
			dbcon.pstmt.setString(1, search_id);
			dbcon.pstmt.execute();
			dbcon.discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Board> BoardSelectAll() {
		// TODO Auto-generated method stub
		List<Board> arr = new ArrayList<>();
		Board board = null;
		
		dbcon.con();
		String sql = "select * from board";
		try {
			dbcon.pstmt = dbcon.conn.prepareStatement(sql);
			dbcon.rs=dbcon.pstmt.executeQuery();
			
			while(dbcon.rs.next()) {
				String id = dbcon.rs.getString(1);
				String title = dbcon.rs.getString(2);
				String contents = dbcon.rs.getString(3);
				
				board = new Board(id, title, contents);
			
				System.out.println(board);
				arr.add(board);
			}
			
			dbcon.discon();
			dbcon.pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return arr;
	}

}
