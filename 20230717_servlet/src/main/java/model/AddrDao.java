<<<<<<< HEAD
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddrDao {
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs=null;
	
	public static Connection con() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void discon() {
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
=======
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AddrDao {
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs=null;
	
	public static Connection con() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","hr","hr");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void discon() {
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
>>>>>>> refs/remotes/origin/main
