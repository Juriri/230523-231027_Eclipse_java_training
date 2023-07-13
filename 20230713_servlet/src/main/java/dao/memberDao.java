package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import vo.memberVO;

public class memberDao {
	private String jdbc_driver="oracle.jdbc.OracleDriver";
	private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid="hr", pwd = "hr";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;
	
	
	
	public void con() {
		// TODO Auto-generated method stub
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,userid,pwd);
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void discon() {
		// TODO Auto-generated method stub
		try {
			if(rs != null) {
				rs.close();
			}
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMember(memberVO vo) {
		con();
		
		String sql = "insert into member values(?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getName());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getPassword());
			
			pstmt.execute();
			
			discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public memberVO getMember(String searchId) {
		memberVO vo = null;
		con();
		
		String name=null, address=null, password=null;
		
		String sql = "select name, address, password from member where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchId);
			rs=pstmt.executeQuery();
			
			if (rs.next()) {
				name = rs.getString(1);
				address = rs.getString(2);
				password = rs.getString(3);
			
				vo = new memberVO(searchId, name, address, password);
			}
			
			discon();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return vo;
	}
	
	public List<memberVO> findMember(String searchId) {
		memberVO vo = null;
		List<memberVO> arr = new ArrayList<>();
		con();
		
		String id=null, name=null, address=null, password=null;
		
//		String sql = "select name, address, password from member where id = ?";
		String sql = "SELECT id, name, address, password FROM member WHERE id LIKE '%' || ? || '%'";



		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, searchId);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				id = rs.getString(1);
				name = rs.getString(2);
				address = rs.getString(3);
				password = rs.getString(4);
			
				vo = new memberVO(id, name, address, password);
				arr.add(vo);
			}
			
			discon();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return arr;
	}
	
	public void updateMember(memberVO vo) {
		con();
		
		String sql = "update member set name=?, address=? password=? where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getAddress());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getId());
			
			pstmt.execute();
			
			discon();
		} catch(Exception e) {
			e.getStackTrace();
		}
	}
	
	public void deleteMember(String search_id) {
		// TODO Auto-generated method stub
		con();
		
		String sql = "delete member where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search_id);
			pstmt.execute();
			discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<memberVO> SelectAll() {
		// TODO Auto-generated method stub
		List<memberVO> arr = new ArrayList<>();
		memberVO vo = null;
		
		con();
		String sql = "select * from member";
		try {
			pstmt = conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String address = rs.getString(3);
				String password = rs.getString(4);
				
				vo = new memberVO(id, name, address, password);
				arr.add(vo);
			}
			
			discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return arr;
	}
	
	public boolean checkDuplicateId(String userId) {
        boolean isDuplicate = false;
        con();
        
        try {
            String sql = "SELECT COUNT(*) FROM member WHERE id = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, userId);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count > 0) {
                    isDuplicate = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
        
        discon();
        return isDuplicate;
    }

}
