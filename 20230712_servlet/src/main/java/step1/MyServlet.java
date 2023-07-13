package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 * 
 * 서블릿을 컨테이너에 등록한다. name은 서블릿 이름, urlPatterns은 이 서블릿의 url을 설정한다.
 * InitParam는 초기화 파라메터를 설정하는 WebServlet 의 속성이다. 이 속성에 초기화 파라메터 리스트를 작성하고 각 파라메터 @WebInitParam 어노테이션으로 정의하고 
 * name은 파라메터의 이름, value는 값을 나타내는 속성
 */
@WebServlet(name="MyServlet", urlPatterns= {"/MyServlet"}, initParams= {
		@WebInitParam(name="param1", value="value1"),
		@WebInitParam(name="param2", value="value2") })

public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyServlet() {
        super.destroy();
        // TODO Auto-generated constructor stub
    }

    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	System.out.println(config.getInitParameter("param1"));
    	System.out.println(config.getInitParameter("param2"));
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		out.print("<html><body>name= " +name+"</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
