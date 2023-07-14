package service;
import step1.BookVo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dao.bookDao;

public class service {
	private static service service_instance;
	public service() {}
	public static service getInstance() {
		if(service_instance == null) {
			service_instance = new service();
		}
		return service_instance;
	}
	
	public void BookInsert(BookVo vo) {
		// TODO Auto-generated method stub
		bookDao.con();
		Connection conn = bookDao.conn;
		PreparedStatement pstmt = bookDao.pstmt;
		ResultSet rs=bookDao.rs;
		
		
		String sql = "insert into book values(?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getNum());
			pstmt.setString(2, vo.getAuthor());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4,vo.getPublisher());
			pstmt.setString(5,vo.getContent());
		
			pstmt.execute();
			
			bookDao.discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public BookVo BookSelect(String search_title) {
		// TODO Auto-generated method stub
		bookDao.con();
		Connection conn = bookDao.conn;
		PreparedStatement pstmt = bookDao.pstmt;
		ResultSet rs=bookDao.rs;
		
		BookVo vo= null;
		String author=null, title=null, publisher=null, content=null;
		
		String sql = "select * from book where title = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_title);
			rs=pstmt.executeQuery();	
			
			if (rs.next()) {
				int num = rs.getInt(1);
				author = rs.getString(2);
				title = rs.getString(3);
				publisher = rs.getString(4);
				content = rs.getString(5);
			
				vo = new BookVo(num, author, title, publisher, content);
			}
			
			bookDao.discon();
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return vo;
	}
	
	
	
	public List<BookVo> BookSelectAll() {
		// TODO Auto-generated method stub
		List<BookVo> arr = new ArrayList<>();
		BookVo vo = null;
		
		bookDao.con();
		Connection conn = bookDao.conn;
		PreparedStatement pstmt = bookDao.pstmt;
		ResultSet rs=bookDao.rs;
		
		String sql = "select * from book";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String author = rs.getString(2);
				String title = rs.getString(3);
				String publisher = rs.getString(4);
				String content = rs.getString(5);
				
				vo = new BookVo(num, author, title, publisher, content);
				
				arr.add(vo);
			}
			
			bookDao.discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return arr;
	}

}
