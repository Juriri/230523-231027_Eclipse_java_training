package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class TestJDBC3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbc_driver="oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid="hr";
		String pwd="hr";
		
		boolean flag = true;
		Scanner sc = new Scanner(System.in);
		
		try {
		//oracle DB 연결준비
			Class.forName(jdbc_driver);
			System.out.println("데이터베이스 연결 준비..");
			Connection conn = DriverManager.getConnection(url,userid,pwd); //도로
			System.out.println("데이터베이스 연결 성공");
			QueryInterfaceImpl.stmt = conn.createStatement();
	
			
			while(flag) {
				System.out.println("1. insert  2. update  3. delete  4. select  5. 종료");
				int num = sc.nextInt();
			}
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
