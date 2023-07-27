package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.service.Service;
import member.service.ServiceImpl;
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		RequestDispatcher dispatcher = null;
		Service service = new ServiceImpl();
		
		HttpSession session = request.getSession();
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		Member member = service.getMember(id);
		
		String result_msg = "";
		
		if(member != null && member.getPwd().equals(pwd) ) {
			//로그인 성공
			session.setAttribute("member", member);
			//1::판매자, 2::구매자
			int type = member.getType();
			
			if(type == 1) {
				dispatcher = request.getRequestDispatcher("/view/member/result.jsp");
			} else if(type == 2) {
				dispatcher = request.getRequestDispatcher("/view/member/result.jsp");
			}
			
		} else {
			//로그인 실패
			result_msg = "로그인 실패";
			dispatcher = request.getRequestDispatcher("/view/member/loginForm.jsp");
		}
		
		request.setAttribute("msg", result_msg);
		
		if(dispatcher != null) {
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
