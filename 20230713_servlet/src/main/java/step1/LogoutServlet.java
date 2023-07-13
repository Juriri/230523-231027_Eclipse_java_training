package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.memberDao;
/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		memberDao dao = new memberDao();
	
		
		//기존 세션이 있으면 리턴, 없으면 null을 리턴
		HttpSession session = request.getSession(false);
		
        if(session == null) {
        	out.print("로그인부터 먼저 해주세요");
        	response.setHeader("Refresh", "2;url=step1/login.html");
        } else {
        	String userId = (String) session.getAttribute("user");
            // 세션 무효화
        	session.invalidate();
        	out.print("로그아웃되었습니다. 사용자 ID: " + userId);
        	 response.setHeader("Refresh", "2;url=step1/index.html"); // 3초 후에 홈 화면 페이지로 이동
       

        }
        
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
