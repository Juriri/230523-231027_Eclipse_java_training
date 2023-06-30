package DBcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class dbcon {

	public  static String jdbc_driver="oracle.jdbc.OracleDriver";
	public  static String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	public  static String userid="hr", pwd = "hr";
	
	public static Connection conn = null;
	public static PreparedStatement pstmt = null;
	public static ResultSet rs=null;
	
	public dbcon() {

	}
	
	public static void con() {
		// TODO Auto-generated method stub
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url,userid,pwd);
			
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
			pstmt.close();
			conn.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}

