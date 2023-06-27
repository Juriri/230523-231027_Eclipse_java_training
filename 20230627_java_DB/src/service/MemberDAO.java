package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vo.*;

public class MemberDAO implements Dao{
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
			pstmt.close();
			conn.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void insertMember(member mem) {
		// TODO Auto-generated method stub
		//instanceof : 객체가 어떤 클래스인지, 어떤 클래스를 상속받았는지 확인하는데 사용하는 연산자
		con();
		
		String sql = "insert into school values(?,?,?,?,?,?)";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getId());
			pstmt.setString(2, mem.getName());
			pstmt.setString(3, mem.getTel());
			pstmt.setString(4, mem.getAddress());
			pstmt.setInt(5, mem.getType());
			
			
			
			if(mem instanceof Employee) {
				pstmt.setString(6, ((Employee)mem).getJob());
			} else {
				if(mem instanceof Professor) {
					pstmt.setString(6, ((Professor)mem).getDept());
				} else if(mem instanceof Student) {
					pstmt.setString(6, ((Student)mem).getStuId());
				} else {
					System.out.println("instanceof 오류 발생");
				}
			}
			pstmt.execute();
			discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public member selectMember(String search_id) {
		// TODO Auto-generated method stub
		con();
		member mem = null;
		String sql = "select * from school where id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search_id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				int type = rs.getInt(5);
				String etc = rs.getString(6);
				
				if(rs.getInt("type")==1) {
					mem = new Employee(id, name, tel, address, type, etc);
				} else if(rs.getInt("type")==2) {
					mem = new Professor(id, name, tel, address, type, etc);
					
				} else if(rs.getInt("type")==3) {
					mem = new Student(id, name, tel, address, type, etc);
				} else {
					System.out.println("잘못된 type 확인됨: ");
				}
			}
			
			discon();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return mem;
	}

	@Override
	public List<member> Allselect(int search_type) {
		// TODO Auto-generated method stub
		List<member> arr = new ArrayList<>();
		
		con();
		String sql = "select * from school where type = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, search_type);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String tel = rs.getString(3);
				String address = rs.getString(4);
				int type = rs.getInt(5);
				String etc = rs.getString(6);
				
				if(rs.getInt("type")==1) {
					arr.add(new Employee(id, name, tel, address, type, etc));
				} else if(rs.getInt("type")==2) {
					arr.add(new Professor(id, name, tel, address, type, etc));
					
				} else if(rs.getInt("type")==3) {
					arr.add(new Student(id, name, tel, address, type, etc));
				} else {
					System.out.println("잘못된 type 확인됨: ");
				}
			}
			
			discon();
			pstmt.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return arr;
	}

	@Override
	public void update(member mem) {
		// TODO Auto-generated method stub
		con();
		
		String sql = "update school set name=?, tel=?, addr=?, etc=? where id=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mem.getName());
			pstmt.setString(2, mem.getTel());
			pstmt.setString(3, mem.getAddress());
			
			if(mem.getType() == 1) {
				pstmt.setString(4, ((Employee)mem).getJob());
			} else if(mem.getType() == 2) {
				pstmt.setString(4, ((Professor)mem).getDept());
			} else if(mem.getType() == 3) {
				pstmt.setString(4, ((Student)mem).getStuId());
			} else {
				System.out.println("잘못된 type입니다. ");
			}
			pstmt.setString(5, mem.getId());
			
			pstmt.execute();
			discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String search_id) {
		// TODO Auto-generated method stub
		con();
		
		String sql = "delete school where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, search_id);
			pstmt.execute();
			discon();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

}
