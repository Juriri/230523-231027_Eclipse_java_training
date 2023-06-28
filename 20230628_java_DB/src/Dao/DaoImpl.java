package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BookVO;
import exception.*;


public class DaoImpl implements Dao {

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
	public void bookInsert(BookVO book) {
		// TODO Auto-generated method stub
		
				con();
				
				String sql = "insert into book values(?,?,?,?,?)";
				try {
					pstmt = conn.prepareStatement(sql);
					
					pstmt.setString(1, book.getId());
					pstmt.setString(2, book.getAuthor());
					pstmt.setString(3, book.getTitle());
					pstmt.setString(4, book.getPublisher());
					pstmt.setInt(5, book.getPrice());
					
					pstmt.execute();
					
					discon();
				} catch(Exception e) {
					e.printStackTrace();
				}
		
	}

	@Override
	public BookVO bookSelect(String search_title) {
		// TODO Auto-generated method stub
		con();
		BookVO book = null;
		String sql = "select * from book where title = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_title);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				String id = rs.getString(1);
				String author = rs.getString(2);
				String title = rs.getString(3);
				String publisher = rs.getString(4);
				int price = rs.getInt(5);
			
				book = new BookVO(id,author, title, publisher, price);
			} else {
				throw new BookNotFoundException("해당 title의 책 검색 결과가 없습니다. ");
			}
			
			discon();
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}

	@Override
	public void bookUpdate(BookVO book) {
		// TODO Auto-generated method stub
		con();
		
		String sql = "update book set author=?, title=?, publisher=?, price=? where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, book.getAuthor());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getPublisher());
			pstmt.setInt(4, book.getPrice());
			pstmt.setString(5, book.getId());
			
			pstmt.execute();
			
			discon();
		} catch(SQLException e) {
			e.getStackTrace();
		}
	}

	@Override
	public void bookDelete(String search_title) {
		// TODO Auto-generated method stub
		con();
		
		String sql = "delete book where title=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search_title);
			pstmt.execute();
			discon();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<BookVO> bookSelectAll() {
		// TODO Auto-generated method stub
		List<BookVO> arr = new ArrayList<>();
		BookVO book = null;
		con();
		String sql = "select * from book";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String author = rs.getString(2);
				String title = rs.getString(3);
				String publisher = rs.getString(4);
				int price = rs.getInt(5);
				
				book = new BookVO(id,author, title, publisher, price);
				System.out.println(book);
				arr.add(book);
			}
			
			discon();
			pstmt.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		return arr;
	}

	

}
