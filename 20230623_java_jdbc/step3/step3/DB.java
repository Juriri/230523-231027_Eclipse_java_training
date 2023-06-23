package step3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class DB {
	String jdbc_driver="oracle.jdbc.OracleDriver";
	String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
	String userid="hr";
	String pwd="hr";
	
	public Connection conn=null;
	public PreparedStatement pstmt = null;
	public ResultSet rs =  null;
	
	
	public void con() throws SQLException, ClassNotFoundException {
		
		try {
		Class.forName(jdbc_driver);
		conn = DriverManager.getConnection(jdbc_url,userid,pwd);
		} catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
