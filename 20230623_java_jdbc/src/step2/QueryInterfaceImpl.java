package step2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueryInterfaceImpl implements QueryInterface{

	private String sql=null;
	private int result;
	
	static Connection conn = null;
	static Statement stmt = null;
	
	@Override
	public void Insert() {
		// TODO Auto-generated method stub
		//1. insert sql 구문
		sql = "insert into member(id,password,name,address) values('spring','aaa','장매력','길동')";
		System.out.println("intert 쿼리 실행 시작: " + result);
	}
	
	@Override
	public void Update() {
		// TODO Auto-generated method stub
		//2. update sql 구문
		sql = "update member set address ='수서' where name='장매력'";
		System.out.println("update 쿼리 실행 시작: "+ result);
	}
	
	@Override
	public void Delete() {
		// TODO Auto-generated method stub
		//3. delete sql 구문
		sql = "delete from member where name='장매력'";
		System.out.println("delete 쿼리 실행 시작: "+ result);
	}
	
	@Override
	public String Result(int num) throws SQLException {
		result = stmt.executeUpdate(sql);
		return sql;
	}

	@Override
	public void Select() throws SQLException {
		String select_sql="select id, password, name, address from member";
		ResultSet rs=stmt.executeQuery(select_sql);
		
		//select sql 출력
		while(rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+ rs.getString("name")+" "+rs.getString("address"));
		}
		
		rs.close();
		stmt.close();
		conn.close();
	}
		

}
