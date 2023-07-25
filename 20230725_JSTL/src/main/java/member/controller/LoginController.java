package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.JoinService;
import member.service.JoinServiceImpl;
import model.Member;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		request.setCharacterEncoding("euc-kr");
		
		JoinService service = new JoinServiceImpl();
		
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		Member member = service.getMember(id);
		String msg = null;
		if (member != null) {
			if(member.getPwd().equals(pwd)) {
				//로그인 성공
				session.setAttribute("member", member);
				msg = "로그인 성공";
			} else {
				//비밀번호 미스매치
				msg = "비밀번호 틀림";
			}
					
		} else {
			//해당 id 검색 결과 없음
			msg = "해당 ID의 회원정보 없음";
		}

		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/member/result.jsp");
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}

	}

}
