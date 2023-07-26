package member.control;

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
 * Servlet implementation class MypageController
 */
@WebServlet("/control/Mypage")
public class MypageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MypageController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		JoinService service = new JoinServiceImpl();

		String type = request.getParameter("type");
		RequestDispatcher dispatcher = null;
		
		//마이페이지 이동
		if(type.equals("Mypage")) {
			dispatcher = request.getRequestDispatcher("/member/Mypage.jsp");
		//내 정보 수정
		} else if(type.equals("Update")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			
			Member member = new Member(id, pwd, name, email);
			
			service.editMember(member);
			HttpSession session = request.getSession();
			session.setAttribute("member", member);
			dispatcher = request.getRequestDispatcher("/member/Mypage.jsp");
			
		} else if(type.equals("Delete")) {
			HttpSession session = request.getSession(false);
			Member member = (Member) session.getAttribute("member");
			service.delMember(member.getId());
			
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
		doGet(request, response);
		
	}

}
