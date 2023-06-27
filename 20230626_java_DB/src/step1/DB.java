package step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import lombok.Data;


@Data
public class DB {


	private String jdbc_driver = jdbc_driver="oracle.jdbc.OracleDriver";
	private String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String userid="hr", pwd = "hr";
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;
	
	

	
	public void con() throws SQLException, ClassNotFoundException {
		
		try {
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url,userid,pwd);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void discon() {
		try {
			if(rs!=null) {
				rs.close();
			}
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void bookInsert(String book_name, String book_writer, int book_price){
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,userid,pwd);
			
			String insert_sql = "insert into book(book_name, book_writer, book_price) values(?,?,?)";
			pstmt = conn.prepareStatement(insert_sql);
			
			pstmt.setString(1, book_name);
			pstmt.setString(2, book_writer);
			pstmt.setInt(3, book_price);
			pstmt.execute();
		
			//discon();
			pstmt.close();
			conn.close();
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public HashMap<String, Integer> bookPrint() {
		ArrayList<String> result_arr= new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>(); 
		
		try {
			con();
			
			String select_sql = "select book_name,book_writer,book_price from book";
			pstmt = conn.prepareStatement(select_sql);
			
			rs=pstmt.executeQuery(select_sql);
		
			//select sql 출력
			while(rs.next()) {
				
				String book_name = rs.getString(1);
				String book_writer = rs.getString(2);
				int book_price = rs.getInt(3);
				
				map.put(book_name,book_price);
				result_arr.add(book_writer+ book_name+book_price);
			}
			
			discon();
			
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		return map;
	}
	
	public boolean search(String search_name) {
		HashMap<String, Integer> map= bookPrint();
		
		if(map.containsKey(search_name)) {
			System.out.println("해당 책의 가격은 " +map.get(search_name));
			return true;
		}
		return false;
	}
}
