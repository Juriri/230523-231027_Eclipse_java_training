package product.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conn.DBConnect;
import model.Product;

public class DaoImpl implements Dao {
	
	private DBConnect db;
	
	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	

	public void insert(Product p) {
		// TODO Auto-generated method stub
		
		Connection conn = db.getConnection();
		
		String sql = "insert into shop_product values(?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		
		try {
			//num, name, quantity, price, img, content, s_id
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p.getNum());
			pstmt.setString(2, p.getName());
			pstmt.setInt(3, p.getQuantity());
			pstmt.setInt(4, p.getPrice());
			pstmt.setString(5, p.getImg());
			pstmt.setString(6, p.getContent());
			pstmt.setString(7, p.getS_id());
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

	
	public Product select(int num) {
		// TODO Auto-generated method stub
		ResultSet rs = null;
		Product product = null;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "select * from shop_product where num=? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int r_num = rs.getInt(1);
				String name = rs.getString(2);
				int quantity = rs.getInt(3);
				int price = rs.getInt(4);
				String img = rs.getString(5);
				String content = rs.getString(6);
				String s_id = rs.getString(7);
				
				product = new Product(r_num, name, quantity, price, img, content, s_id);
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

		
		return product;
	}
	
	public List<Product> selectAllById(String s_id) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		ResultSet rs = null;
		List<Product> products = new ArrayList<Product>();
		PreparedStatement pstmt = null;

		String sql = "select * from shop_product where s_id = ?";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, s_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				int quantity = rs.getInt(3);
				int price = rs.getInt(5);
				String img = rs.getString(6);
				String content = rs.getString(7);
				String r_s_id = rs.getString(8);
				
				products.add(new Product(num, name, quantity, price, img, content, r_s_id));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return products;
	}

	

	public void update(Product p) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();

		String sql = "update shop_product set name=?,quantity=?,price=?,content=? where num =?";
		
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, p.getName());
			pstmt.setInt(2, p.getQuantity());
			pstmt.setInt(3, p.getPrice());
			pstmt.setString(4, p.getContent());
			pstmt.setInt(5, p.getNum());
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
		
		String sql = "delete shop_product where num=?";
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

	
	
	
	public int selectNum() {
		// TODO Auto-generated method stub
		
		Connection conn = db.getConnection();
		
		String sql = "select seq_shop_product.nextval from dual";
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		int num = 0;


		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				num = rs.getInt(1);
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
		
		return num;
	}

	
	public List<Product> selectAll() {
		// TODO Auto-generated method stub
		ArrayList<Product> products = new ArrayList<Product>();
		ResultSet rs = null;
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		
		String sql = "select * from shop_product";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				int quantity = rs.getInt(3);
				int price = rs.getInt(4);
				String img = rs.getString(5);
				String content = rs.getString(6);
				String r_s_id = rs.getString(7);
				
				products.add(new Product(num, name, quantity, price, img, content, r_s_id));
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
		
		
		return products;
	}

	
	
	public void updateQuantity(int q, int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = " ";
		try {
			pstmt = conn.prepareStatement(sql);
			
			
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

}
