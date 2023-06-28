package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;
import vo.Board;

@Data
@NoArgsConstructor
public class BoardDaoImpl implements BoardDao{
	private String jdbc_driver = jdbc_driver="oracle.jdbc.OracleDriver";
	private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid="hr", pwd = "hr";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;

	@Override
	public void con() {
		// TODO Auto-generated method stub
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,userid,pwd);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void discon() {
		// TODO Auto-generated method stub
		try {
			if(rs!=null) {
				rs.close();
			}
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void BoadInsert(Board board) {
		// TODO Auto-generated method stub
		con();
		
		String sql = "insert into board values(?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getId());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContents());
			
			pstmt.execute();
			
			discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Board BoardSelect(String search_id) {
		// TODO Auto-generated method stub
		con();
		Board board= null;
		String id=null, title=null, contents=null;
		
		String sql = "select * from board where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_id);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				id = rs.getString(1);
				title = rs.getString(2);
				contents = rs.getString(3);
			
				board = new Board(id, title, contents);
			}
			
			discon();
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return board;
	}

	@Override
	public void BoardUpdate(Board board) {
		// TODO Auto-generated method stub
		con();
		
		String sql = "update book set title=?, contents=? where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContents());
			pstmt.setString(3, board.getId());
			
			pstmt.execute();
			
			discon();
		} catch(Exception e) {
			e.getStackTrace();
		}
	}

	@Override
	public void BoardDelete(String search_id) {
		// TODO Auto-generated method stub
		con();
		
		String sql = "delete board where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search_id);
			pstmt.execute();
			discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Board> BoardSelectAll() {
		// TODO Auto-generated method stub
		List<Board> arr = new ArrayList<>();
		Board board = null;
		
		con();
		String sql = "select * from board";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String title = rs.getString(2);
				String contents = rs.getString(3);
				
				board = new Board(id, title, contents);
			
				System.out.println(board);
				arr.add(board);
			}
			
			discon();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return arr;
	}

}
