package board.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import db.DBConnect;
import model.Board;

public class DaoImpl implements Dao {
	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	@Override
	public void insert(Board b) {
		// TODO Auto-generated method stub
		Connection conn = null;

		
		String sql = "insert into board values(seq_board.nextval,?,?,?,?) ";

		PreparedStatement pstmt = null;
		try {
			
			conn = db.getConnection();
			// 현재 시간을 java.time.LocalDate로 가져옵니다.
			LocalDateTime currentDateTime = LocalDateTime.now();
			Timestamp timestamp = Timestamp.valueOf(currentDateTime);
			// 원하는 출력 형식으로 포맷팅
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String formattedDateTime = sdf.format(timestamp);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getWriter());
			pstmt.setString(2, formattedDateTime);
			pstmt.setString(3, b.getTitle());
			pstmt.setString(4, b.getContent());

			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public Board select(int num) {
		// TODO Auto-generated method stub

		Connection conn = null;
		ResultSet rs = null;
		Board b = null;

		
		String sql = "select * from board where num = ?";
		PreparedStatement pstmt = null;
		try {
			
			conn = db.getConnection();

			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int id = rs.getInt(1);
				String writer = rs.getString(2);
				String w_date = rs.getString(3);
				String title = rs.getString(4);
				String content = rs.getString(5);
				
				b = new Board(id, writer, w_date, title, content);
				
			}
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return b;
	}
	
	

	@Override
	public List<Board> selectAll() {
		// TODO Auto-generated method stub

		Connection conn = null;
		ResultSet rs = null;
		List<Board> list = new ArrayList<Board>();

		
		String sql = "select * from board";
		PreparedStatement pstmt = null;
		try {
			
			conn = db.getConnection();

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
		

			while(rs.next()) {
				int id = rs.getInt(1);
				String writer = rs.getString(2);
				String w_date = rs.getString(3);
				String title = rs.getString(4);
				String content = rs.getString(5);
				
				list.add(new Board(id, writer, w_date, title, content));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				if (rs != null) {
					rs.close();
				}
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		
		return list;
	}

	@Override
	public void update(Board b) {
		// TODO Auto-generated method stub

		Connection conn = null;

		
		String sql = "update board set title=?, content=? where num=?";

		PreparedStatement pstmt = null;
		try {
			
			conn = db.getConnection();

			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNum());
			
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub

		Connection conn = null;

		
		String sql = "delete board where num = ?";

		PreparedStatement pstmt = null;
		try {
			
			conn = db.getConnection();

			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
