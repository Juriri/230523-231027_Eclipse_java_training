package step6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class findServlet
 */
@WebServlet("/findServlet")
public class findServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public findServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String jdbc_driver ="oracle.jdbc.OracleDriver";
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userid="hr", pwd = "hr";
		

		
		try {
			Class.forName(jdbc_driver);
			conn = DriverManager.getConnection(jdbc_url, userid, pwd);
			
		} catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		super.service(arg0, arg1);
		
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		
		PrintWriter out=response.getWriter();
		
		try {
			String sql="select name, address from member where id=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("membership"));
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
				out.print("<table border=1>");
				out.print("<tr>");
				out.print("<td>이름: "+rs.getString(1) +"</td>");
				out.print("<td>주소: "+rs.getString(2) +"</td>");
				out.print("</tr>");
				out.print("</table>");	
			} else {
				out.print("검색 결과가 없습니다. ");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			out.close();
			
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
