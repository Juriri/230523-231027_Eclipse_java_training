package step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC1 {
	public static void main(String[] args) {
		
		String jdbc_driver="oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid="hr";
		String pwd="hr";
		
		try {
		//oracle DB 연결준비
			Class.forName(jdbc_driver);
			System.out.println("데이터베이스 연결 준비..");
			Connection conn = DriverManager.getConnection(url,userid,pwd); //도로
			System.out.println("데이터베이스 연결 성공");
			Statement stmt = conn.createStatement(); 
	
			//insert sql 구문
			String insert_sql = "insert into member(id,password,name,address) values('spring','aaa','장매력','길동')";
			int result = stmt.executeUpdate(insert_sql);
			System.out.println("intert 쿼리 실행 시작: ");
			//System.out.println(result);
			
			//select sql 구문
			String select_sql="select id, password, name, address from member";
			ResultSet rs=stmt.executeQuery(select_sql);
			
			//select sql 출력
			while(rs.next()) {
				
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+ rs.getString("name")+" "+rs.getString("address"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
