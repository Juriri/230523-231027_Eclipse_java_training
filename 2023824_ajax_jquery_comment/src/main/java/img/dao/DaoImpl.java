package img.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import conn.DBConnect;
import model.Img;

public class DaoImpl implements Dao {
	private DBConnect db;

	public DaoImpl() {
		db = DBConnect.getInstance();
	}

	public ArrayList<Img> selectAll() {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Img> data = new ArrayList<Img>();
		String sql = "select * from img order by num";
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt(1);
				String writer = rs.getString(2);
				String pwd = rs.getString(3);
				String title = rs.getString(4);
				String path = rs.getString(5);
				Date u_date = rs.getDate(6);
				
				data.add(new Img(num, writer, pwd, title, path, u_date));
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}

	public void insert(Img img) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "insert into img values(?,?,?,?,?,sysdate)";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, img.getNum());
			pstmt.setString(2, img.getWriter());
			pstmt.setString(3, img.getPwd());
			pstmt.setString(4, img.getTitle());
			pstmt.setString(5, img.getPath());
			
			pstmt.executeUpdate();
			
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
	public int makeNum() {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select seq_img.nextval from dual";
		int resultNum = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				resultNum = rs.getInt(1);
			}
			
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultNum;
	}

	@Override
	public Img select(int num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from img where num=?";
		Img img = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String writer = rs.getString(2);
				String pwd = rs.getString(3);
				String title = rs.getString(4);
				String path = rs.getString(5);
				Date u_date = rs.getDate(6);
				
				img = new Img(num, writer, pwd, title, path, u_date);
			}
			
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return img;
	}

	@Override
	public int delete(int num) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "delete img where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
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
		return num;
	}

	@Override
	public int update(Img img) {
		// TODO Auto-generated method stub
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;

		String sql = "update img set writer=?, pwd=?, title=?, u_date=sysdate where num=?   ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, img.getWriter());
			pstmt.setString(2, img.getPwd());
			pstmt.setString(3, img.getTitle());
			pstmt.setInt(4, img.getNum());
			pstmt.executeUpdate();
			return img.getNum();
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				//  ڿ    ȯ
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}
}
