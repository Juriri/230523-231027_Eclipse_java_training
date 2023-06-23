package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface QueryInterface {
	
	public void Insert();
	public void Update();
	public void Delete();
	public String Result(int num) throws SQLException;
	public void Select()throws SQLException;;

}
