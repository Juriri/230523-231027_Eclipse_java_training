package comment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.Comment;
import model.Product;

public class DaoImpl implements Dao {
	
	private DBConnect db;
	
	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	

	public void insert(Comment comment) {
		// TODO Auto-generated method stub
		
		Connection conn = db.getConnection();
		
		String sql = "insert into shop_comment values(seq_comment.nextval,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
		
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getProduct_num());
			pstmt.setString(2, comment.getUser_id());
			pstmt.setString(3, comment.getUser_comment());
	
			pstmt.executeUpdate();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	
	public Comment select(int num) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Comment comment = null;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "select * from shop_comment where comment_num=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int r_num = rs.getInt(1);
				int product_num = rs.getInt(2);
				String user_id = rs.getString(3);
				String user_comment = rs.getString(4);
			
				comment = new Comment(r_num, product_num, user_id, user_comment);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
		return comment;
	}



	public void update(Comment comment) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();

		String sql = "update shop_comment set user_comment=? where comment_num =? and product_num=? and user_id=?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment.getUser_comment());
			pstmt.setInt(2, comment.getComment_num());
			pstmt.setInt(3, comment.getProduct_num());
			pstmt.setString(4, comment.getUser_id());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}

	public void delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		
		String sql = "delete shop_comment where num=?";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	

	
	public List<Comment> selectAllByP_num(int product_num) {
		// TODO Auto-generated method stub
		List<Comment> list = new ArrayList<Comment>();
		ResultSet rs = null;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "select * from shop_comment where product_num = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,product_num);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int comment_num = rs.getInt(1);
				int r_product_num = rs.getInt(2);
				String user_id = rs.getString(3);
				String user_comment = rs.getString(4);
				
				list.add(new Comment(comment_num, r_product_num, user_id, user_comment));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return list;
	}



}
