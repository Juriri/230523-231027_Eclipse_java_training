package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import join.DBConnect;
import join.Member;

public class DaoImpl implements Dao {
	private DBConnect db = DBConnect.getInstance();
	private Connection conn = db.getConnection();
	private PreparedStatement pstmt;

	@Override
	public void insert(Board b) {
		// TODO Auto-generated method stub
		String sql = "insert into board2 values(seq_board2.nextval,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, b.getPwd());
			pstmt.setString(3, b.getTitle());
			pstmt.setString(4, b.getCurrentTime());
			pstmt.setString(5, b.getContent());
			
			pstmt.executeUpdate();
			pstmt.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Board select(int num) {
		// TODO Auto-generated method stub
		board.Board board = new Board();
		
		String sql = "select * from board2 where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			ResultSet rs=pstmt.executeQuery();

			if (rs.next()) {
				
				board.setNum(rs.getInt(1));
				board.setWriter(rs.getString(2));
				board.setPwd(rs.getString(3));
				board.setTitle(rs.getString(4));
				board.setCurrentTime(rs.getString(5));
				board.setContent(rs.getString(6));
			
			}
			pstmt.close();
			return board;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return board;
	}

	@Override
	public List selectAll() {
		// TODO Auto-generated method stub
		List<Board> board_arr = new ArrayList<>();
		
		
		String sql = "select * from board2";
		try {
			pstmt = conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();

			while (rs.next()) {
				
				System.out.println("num: "+rs.getInt(1)+"/ writer: "+rs.getString(2)+"/ pwd: "+rs.getString(3)+"/ title: "+rs.getString(4)+"/ time: "+rs.getString(5)+"/ content: "+rs.getString(6));
				
			
			}
			pstmt.close();
			return board_arr;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return board_arr;
	}

	@Override
	public int update(Board b) {
		// TODO Auto-generated method stub
		String sql = "update board2 set pwd=?, title=? where num=? and writer=?";
		int line =0;
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, b.getPwd());
			pstmt.setString(2, b.getTitle());
			pstmt.setInt(3, b.getNum());
			pstmt.setString(4, b.getWriter());
			
			line = pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		return line;
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		if(select(num) != null) {
			board.Board board = select(num);
			
			String sql = "delete board2 where num=? and writer=?";
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setInt(1, board.getNum());
				pstmt.setString(2, board.getWriter());
				pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		} else {
			System.out.println("해당 검색 결과가 없습니다. ");
		}
	}

}
