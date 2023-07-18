package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import service.EventService;
import service.Service;

/**
 * Servlet implementation class user_control
 */
@WebServlet("/user_control")
public class user_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new EventService();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		
		String resultView = "user/";
		
		if(type.equals("signin")) {
			resultView="user/signin.jsp";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(resultView);
		dis.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		
		String resultView = "user/";
		
		if(type.equals("signin.do")) {
			String search_id = request.getParameter("id");
			String search_pwd = request.getParameter("pwd");
			
			Member m = service.getMemberbySignin(search_id, search_pwd);
			
			String msg = null;
			if (m == null) {
				msg = "해당 유저 정보 없습니다. ";
			} else {
				HttpSession session = request.getSession(true); // 새로운 세션 가져오거나 기존 세션 사용
				String userId = (String) session.getAttribute("id");
				
				if(userId != null) {
					msg = "이미 로그인 상태입니다. ";
				}else {
					session.setAttribute("id", m.getId()); // 세션에 로그인된 사용자의 아이디 저장
					msg = "로그인 성공입니다. ";
				}
	            
			}
			
            
         // JavaScript로 alert 메시지 출력
            String alertScript = "<script>alert('" + msg + "');</script>";
            request.setAttribute("alertScript", alertScript);
            resultView = "event/form.jsp";
			
		}
		
		if(type.equals("signout")) {
			HttpSession session = request.getSession(true); // 새로운 세션 가져오거나 기존 세션 사용
			String userId = (String) session.getAttribute("id");
			String msg = null;
			
			if(userId != null) {
				// 세션 무효화 (로그아웃)
	            session.invalidate();
				msg = "로그아웃 되었습니다. ";
				
	            
			}else {
				msg = "로그인 먼저 진행 해주세요.";
			}
			
			String alertScript = "<script>alert('" + msg + "');</script>";
            request.setAttribute("alertScript", alertScript);
            resultView = "event/form.jsp";
		}
		RequestDispatcher dis = request.getRequestDispatcher(resultView);
		dis.forward(request, response);
	}

}
