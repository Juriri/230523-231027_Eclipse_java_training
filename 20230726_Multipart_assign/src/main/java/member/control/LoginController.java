package member.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.*;
import model.Member;
/**
 * Servlet implementation class LoginController
 */
@WebServlet("/control/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = null;
		String type = request.getParameter("type");
		
		//로그인 화면 이동
		if (type.equals("Login")) {
			dispatcher = request.getRequestDispatcher("/member/SignInForm.jsp");	
		//로그아웃
		} else if (type.equals("Logout")) {
			// Clear the session and perform logout
		    HttpSession session = request.getSession(false);
		    if (session != null) {
		        session.invalidate();
		    }
		    dispatcher = request.getRequestDispatcher("/home.jsp"); 
		}
		
		if(dispatcher!=null) {
			dispatcher.forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		request.setCharacterEncoding("euc-kr");
		
		RequestDispatcher dispatcher = null;
		HttpSession session = request.getSession();
		
		JoinService service = new JoinServiceImpl();
		String type = request.getParameter("type");
	
		if (type.equals("Login.do")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			Member member = service.getMember(id);
			
			String msg = null;
			
			if (member != null) {
				if(member.getPwd().equals(pwd)) {
					//로그인 성공
					session.setAttribute("member", member);
					msg = "로그인 성공";
					//로그인 성공
					dispatcher = request.getRequestDispatcher("/home.jsp");
					
				} else {
					//비밀번호 미스매치
					msg = "비밀번호 틀림";
					dispatcher = request.getRequestDispatcher("/member/SignResult.jsp");
				}
						
			} else {
				//해당 id 검색 결과 없음
				msg = "해당 ID의 회원정보 없음";
				dispatcher = request.getRequestDispatcher("/member/SignResult.jsp");
			}
			
			request.setAttribute("msg", msg);
			
			if(dispatcher != null) {
				dispatcher.forward(request, response);
			}
		} 	
	
	}

}
