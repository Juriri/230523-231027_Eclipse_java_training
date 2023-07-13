package step1;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.memberVO;
import dao.memberDao;

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
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		memberDao dao = new memberDao();
		
		String id = request.getParameter("userId");
		String password = request.getParameter("userPassword");
		
		//기존 세션이 있으면 리턴, 없으면 null을 리턴
		HttpSession session = request.getSession(false);
		
        if(dao.getMember(id) == null) {
        	out.print("가입되지않는 아이디입니다. ");
        	response.setHeader("Refresh", "2;url=step1/login.html");
        } else {
        	memberVO find_mem = dao.getMember(id);
        	if(!find_mem.getPassword().equals(password)) {
        		out.print("틀린 패스워드입니다. ");
        		response.setHeader("Refresh", "2;url=step1/login.html");
        	} else {
                if (session == null) {
                    session = request.getSession(true);
                    session.setAttribute("user", id);
                    out.print(id + "님 로그인 성공입니다.");
                    response.setHeader("Refresh", "1;url=step1/index.html");
                } else {
                    out.print("이미 로그인되어 있음.");
                    response.setHeader("Refresh", "1;url=step1/index.html");
                }
            }
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
