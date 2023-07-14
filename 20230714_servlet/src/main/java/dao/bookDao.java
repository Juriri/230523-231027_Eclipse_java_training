package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bookDao {
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs=null;
	
	public static void con() {
		// TODO Auto-generated method stub
		try {
			//mac::"oracle.jdbc.OracleDriver"
			
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.0.36:1521:xe","hr","hr");
			
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	public static void discon() {
		// TODO Auto-generated method stub
		try {
			if(rs!=null) {
				rs.close();
			}
			if(pstmt!=null) {
				pstmt.close();	
			}
			if(conn!=null) {
				conn.close();	
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
