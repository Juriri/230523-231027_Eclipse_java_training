package join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import join.Member;

public class DaoOracleImpl implements Dao {
	private DBConnect db = DBConnect.getInstance();
	private Connection conn = db.getConnection();
	private PreparedStatement pstmt;

	@Override
	public int insertMember(Member m) {
		// TODO Auto-generated method stub
		int line = 0;
		String sql = "insert into member2 values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setString(4, m.getEmail());
			
			line = pstmt.executeUpdate();
			pstmt.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return line;
	}
	
	

	@Override
	public int updateMember(Member m) {
		// TODO Auto-generated method stub
		String sql = "update member2 set pwd=?, name=?, email=? where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getPwd());
			pstmt.setString(2, m.getName());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getId());
			
			int line = pstmt.executeUpdate();
			
			return line;
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		return 0;
	}

	@Override
	public int removeMember(String search_id) {
		// TODO Auto-generated method stub
		String sql = "delete member2 where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search_id);
			int line = pstmt.executeUpdate();
			return line;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean login(String id, String pwd) {
		// TODO Auto-generated method stub
		Member member = memberInfo(id);
		
		try {
			if(member.getPwd().equals(pwd)) {
				return true;
			} else {
				return false;
			}
		}catch(Exception e) {
			e.getStackTrace();
		}
		
		return false;
	}

	@Override
	public Member memberInfo(String search_id) {
		// TODO Auto-generated method stub
		Member member= new Member();
		String id=null, pwd=null, name=null, email=null;
		
		String sql = "select * from member2 where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_id);
			ResultSet rs=pstmt.executeQuery();

			
			if (rs.next()) {
				id = rs.getString(1);
				member.setId(id);
			
				pwd = rs.getString(2);
				member.setPwd(pwd);
				
				name = rs.getString(3);
				member.setName(name);
				
				email = rs.getString(4);
				member.setEmail(email);
			
			}
			pstmt.close();
			return member;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
