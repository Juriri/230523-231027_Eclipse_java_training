package step8;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
	
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		if(id.equals("java")) {
			if(password.equals("abcd")) {
				HttpSession session=request.getSession();
				session.setAttribute("userName", "java");
				out.print(id+"님 로그인 ok");
				out.print("<hr><a href=ShopServlet>ShopServlet</a>");
				
			}else {
				out.print("비번이 틀렸습니다. ");
				out.print("<hr><a href=Login.html>로그인 홈 돌아가기</a>");
			}
		} else {
			out.print("아이디 틀렸습니다. ");
			out.print("<hr><a href=Login.html>로그인 홈 돌아가기</a>");
		}
		
		out.close();
	}

}
