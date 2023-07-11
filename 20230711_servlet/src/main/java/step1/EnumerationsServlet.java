package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnumerationsServlet
 */
@WebServlet("/EnumerationsServlet")
public class EnumerationsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnumerationsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out=response.getWriter();
		
		//요청 시 넘어온 name들을 Enumeration 타입으로 리
		//request.getParameterNames();
		
		Enumeration e = request.getParameterNames();
		//name이 있을 때까지 계속 수행
		while(e.hasMoreElements()) {
			//out.print(e.nextElement()+"<br>")
			//name을 얻어와서 value를 반환한다.
			String info=request.getParameter(e.nextElement().toString());
			out.print(info+"<br>");
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
