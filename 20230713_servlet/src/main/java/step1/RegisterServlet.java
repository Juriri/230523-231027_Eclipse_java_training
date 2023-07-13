package step1;

import java.io.IOException;
import java.io.PrintWriter;             
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.memberVO;
import dao.memberDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
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
		String name = request.getParameter("userName");
		String address = request.getParameter("userAddress");
		
        if(dao.getMember(id) != null) {
        	out.print("아이디 중복입니다. ");
        } else {
        	memberVO vo = new memberVO(id, name, address, password);
     		dao.addMember(vo);
            out.print(name+ "님 회원가입을 축하합니다. ");
            response.setHeader("Refresh", "1;url=step1/index.html");
        }
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		
		memberDao dao = new memberDao();
		String id = request.getParameter("userId");
		
		// 아이디 중복 체크
        boolean isDuplicate = dao.checkDuplicateId(id);
        
        // 응답 반환
        if (isDuplicate) {
            out.println("아이디 중복입니다.");
        } else {
        	
            out.println("사용 가능한 아이디입니다.");
           
        }
	}
	
	

}
