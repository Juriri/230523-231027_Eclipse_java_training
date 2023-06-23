package service;

import step3.DB;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import vo.Member;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DBService {

	private String sql = "";
	DB db = new DB();	
	
	ArrayList<String> arr_str = new ArrayList<>();
	Scanner sc = new Scanner(System.in);
	
	
	public void enroll(String id, String password, String name, String address) throws SQLException {
		try {
			db.con();
			
			String insert_sql = "insert into member(id,password,name,address) values(?,?,?,?)";
			db.pstmt = db.conn.prepareStatement(insert_sql);
			
			Member member  = new Member(id, password, name, address);
			
			db.pstmt.setString(1, member.getId());
			db.pstmt.setString(2, member.getPassword());
			db.pstmt.setString(3, member.getName());
			db.pstmt.setString(4, member.getAddress());
			db.pstmt.execute();
		
			db.pstmt.close();
			db.conn.close();
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public ArrayList<Member> list() {
		ArrayList<Member> result_arr= new ArrayList<>();
		try {
			db.con();
			
			String select_sql = "select id,password,name,address from member";
			db.pstmt = db.conn.prepareStatement(select_sql);
			db.rs=db.pstmt.executeQuery(select_sql);
			
			//select sql 출력
			while(db.rs.next()) {
				
				String id = db.rs.getString(1);
				String password = db.rs.getString(2);
				String name = db.rs.getString(3);
				String address = db.rs.getString(4);
				
				result_arr.add(new Member(id,password,name,address));
			}
			
			db.rs.close();
			db.pstmt.close();
			db.conn.close();
		
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return result_arr;
	}
	
	public String update(String name) throws SQLException {
		ArrayList<Member> new_arr= list();
		
		for(int i=0; i<new_arr.size(); i++) {
			if(new_arr.get(i).getName().equals(name)) {
				System.out.println("해당 이름을 찾았습니다: ");
				
				System.out.println("수정할 id를 입력해주세요: ");
				String new_id = sc.next();
				System.out.println("수정할 password 를 입력해주세요: ");
				String new_password = sc.next();
				System.out.println("수정할 address 를 입력해주세요: ");
				String new_address = sc.next();
				
				try {
					db.con();
					String update_sql = "update member set id=?, password=?, address=? where name = ?";		
				
					db.pstmt = db.conn.prepareStatement(update_sql);

					db.pstmt.setString(1, new_id);
					db.pstmt.setString(2, new_password);
					db.pstmt.setString(3, new_address);
					db.pstmt.setString(4, name);
					
					int result = db.pstmt.executeUpdate();
					
					db.pstmt.close();
					
					
				} catch(Exception e) {
					System.out.println(e.toString());
				} finally {
					db.conn.close();
				}

				return "수정을 완료하였습니다. ";
			}
		}
		
		return "해당 이름의 검색 결과가 없습니다.";
		
	}
	
	public String search(String name) {
		ArrayList<Member> new_arr= list();
		
		for(int i=0; i<new_arr.size(); i++) {
			if(new_arr.get(i).getName().equals(name)) {
				System.out.println("name: "+name+"->  "+"id: "+new_arr.get(i).getId()+" password: "+new_arr.get(i).getPassword()+" address: "+new_arr.get(i).getAddress());
				return "검색을 완료하였습니다. ";
			}
		}
		
		return "해당 이름의 검색 결과가 없습니다.";
	}
	
	public String delete(String name) throws SQLException {
		ArrayList<Member> new_arr= list();
		
		for(int i=0; i<new_arr.size(); i++) {
			if(new_arr.get(i).getName().equals(name)) {
				System.out.println("해당 이름을 찾았습니다: ");
				
				try {
					db.con();
					String delete_sql = "delete from member where name = ?";		
				
					db.pstmt = db.conn.prepareStatement(delete_sql);
					db.pstmt.setString(1, name);
					
					int result = db.pstmt.executeUpdate();
					
					db.pstmt.close();
					
					
				} catch(Exception e) {
					System.out.println(e.toString());
				} finally {
					db.conn.close();
				}

				return "수정을 완료하였습니다. ";
			}
		}
		return "해당 이름의 검색 결과가 없습니다.";
	}
}
