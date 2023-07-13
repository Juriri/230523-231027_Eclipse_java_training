package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MyServlet6
 */
@WebServlet("/MyServlet6")
public class MyServlet6 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet6() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=EUC-KR");
		response.setCharacterEncoding("euc-kr");
		
		//session 획득
		HttpSession session = request.getSession();
		
		//request객체에 저장된 정보 읽기
		String requestInfo = (String) request.getAttribute("requestInfo");
		
		//session 객체에 저장된 정보 읽기
		String sessionInfo = (String) session.getAttribute("sessionInfo");
		
		//ServletContext 객체 획득
		ServletContext application = getServletContext();
		
		//application 객체에 저장된 정보 읽기
		String applicationInfo = (String) application.getAttribute("applicationInfo");
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("requestInfo: "+requestInfo+"<br>");
		out.print("sessionInfo: "+sessionInfo+"<br>");
		out.print("applicationInfo: "+applicationInfo+"<br>");
		out.print("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
