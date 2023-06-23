package step1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBTest {
	
	public static void main(String[] args)  {
		Connection conn=null;
		Statement stmt=null;
		
		String jdbc_driver="oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid="hr";
		String pwd="hr";
		
		try {
		//oracle DB 연결준비
		Class.forName(jdbc_driver);
		System.out.println("데이터베이스 연결 준비..");
		conn = DriverManager.getConnection(url,userid,pwd); //도로
		stmt = conn.createStatement(); //자동차
		
			if(conn!=null) {
				System.out.println("드라이버 로딩 성공");
			}
		String sql="select Last_name from employees";
		
		ResultSet rs=stmt.executeQuery(sql);
		int i=1;
		System.out.println("name: ");
		
		//column row1의 모든column 출력
			while(rs.next()) {
				System.out.println(i+": "+rs.getString(1));
				i++;
			}
			
		rs.close();
		stmt.close();
		conn.close();
		
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
