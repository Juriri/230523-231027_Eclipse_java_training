package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OracleDao implements Dao {
	
	public Connection conn = null;
	public PreparedStatement pstmt = null;
	public Statement stmt = null;
	ResultSet rs = null;
	
	private static OracleDao instance = new OracleDao();

	private OracleDao() {
	}

	public static OracleDao getDao() {
		return instance;
	}
	
	@Override
	public boolean con() {
		// TODO Auto-generated method stub
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
		return true;
	}

	@Override
	public void discon() {
		// TODO Auto-generated method stub
		try {
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
			if (rs != null)
				rs.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void insert(Member m) {
		// TODO Auto-generated method stub
		con();
		String sql = "insert into event (num, id, email, pwd) values (event_seq.nextval, ?, ?, ?)";
	
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPwd());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
	}

	@Override
	public ArrayList<Member> getAll() {
		// TODO Auto-generated method stub
		con();
		String sql = "select * from event";
		ArrayList<Member> list = new ArrayList<>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String email = rs.getString(3);
				String pwd = rs.getString(4);
				Member m =new Member(num, id, email, pwd); 
				
				list.add(m);
			}
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		} finally {
			discon();
		}
		return list;
	}

	@Override
	public Member getMember(int search_num) {
		// TODO Auto-generated method stub
		con();
		Member m = null;
		
		String sql = "select * from event where num = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, search_num);
			ResultSet rs = pstmt.executeQuery();
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				int num = rs.getInt(1);
				String id = rs.getString(2);
				String email = rs.getString(3);
				String pwd = rs.getString(4);
				
			
				m = new Member(num, id, email, pwd);
			}
			
		} catch (Exception e) {
			System.out.println(e);
			
		} finally {
			discon();
		}
		return m;  
	
	}
	
	@Override
	public void update(Member m) {
		// TODO Auto-generated method stub
		con();
		String sql = "update event set email=?, pwd=? where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPwd());
			pstmt.setInt(3, m.getNum());
			pstmt.execute();;
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		con();
		String sql = "delete from event where num=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.execute();
			
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			discon();
		}
	}

}
