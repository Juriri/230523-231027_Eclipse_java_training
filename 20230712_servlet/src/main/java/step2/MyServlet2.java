package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet2
 */
@WebServlet("/MyServlet2")
public class MyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet2() {
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
		
		PrintWriter out=response.getWriter();
		out.print("<html<body>");
		out.print("<h3> body 내용 </h3>");
		out.print("내용 <br>");
		out.print("내용 <br>");
		out.print("</body></html>");
		
		//RequestDispatcher: 객체 획득
		//request.getRequestDispatcher(); 의 파라메터는 사용할 자원의 경로
		
		//절대 경로로만 지정
		//RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Banner");
		
		//절대 경로 상대 경로 모두 가능 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Banner");
		if(dispatcher != null) {
			dispatcher.include(request, response);
		}
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
