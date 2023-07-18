package service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Member;
import model.AddrDao;

public class EventService {
	Connection conn = null;
	PreparedStatement pstmt = null;
	
	private static EventService service;
	public EventService() {}
	public static EventService getInstance() {
		if(service == null) {
			service = new EventService();
		}
		return service;
	}

	
	public void MemberInsert(Member m) {
		
		String sql = "insert into addr values(addr_seq.NEXTVAL, ?, ?, ?, ?)";
		//num, name, tel, address, Postal
		try {
			conn = AddrDao.con();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getTel());
			pstmt.setString(3,m.getAddress());
			pstmt.setString(4,m.getPostal());
		
			pstmt.execute();
			
			AddrDao.discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Member> MemberSelect(String search_name) {
		// TODO Auto-generated method stub
		List<Member> arr = new ArrayList<>();
		Member m= null;
		String name=null, tel=null, address=null, postal=null;
		
		String sql = "select * from addr where name like '%' || ? || '%'";
		try {
			conn = AddrDao.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_name);
			
			ResultSet rs = pstmt.executeQuery();
			rs=pstmt.executeQuery();	
			
			while (rs.next()) {
				int num = rs.getInt(1);
				name = rs.getString(2);
				tel = rs.getString(3);
				address = rs.getString(4);
				postal = rs.getString(5);
			
				m = new Member(num, name, tel, address, postal);
				arr.add(m);
			}
			
			AddrDao.discon();
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return arr;
	}
	
	public Member MemberSelectbyId (int search_id) {
		// TODO Auto-generated method stub
		Member m= null;
		String name=null, tel=null, address=null, postal=null;
		
		String sql = "select * from addr where num = ?";
		try {
			conn = AddrDao.con();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, search_id);
			
			ResultSet rs = pstmt.executeQuery();
			rs=pstmt.executeQuery();	
			
			while (rs.next()) {
				int num = rs.getInt(1);
				name = rs.getString(2);
				tel = rs.getString(3);
				address = rs.getString(4);
				postal = rs.getString(5);
			
				m = new Member(num, name, tel, address, postal);
			}
			
			AddrDao.discon();
	
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return m;
	}
	
	public List<Member> MemberSelectAll() {
		// TODO Auto-generated method stub
		List<Member> arr = new ArrayList<>();
		Member m = null;
		
		String sql = "select * from addr";
		try {
			conn = AddrDao.con();
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				int num = rs.getInt(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				String postal = rs.getString(5);
				
				m = new Member(num, name, tel, address, postal);
				
				arr.add(m);
			}
			
			AddrDao.discon();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return arr;
	}
	
	public boolean MemberUpdate(Member m) {
		List<Member> arr = new ArrayList<>();
		
		String sql = "UPDATE addr SET tel=?, address=?, postal=? WHERE name=?";
		
		try {
			conn = AddrDao.con();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,m.getTel());
			pstmt.setString(2,m.getAddress());
			pstmt.setString(3,m.getPostal());
			pstmt.setString(4,m.getName());
	
			pstmt.execute();
			
			AddrDao.discon();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}
}
