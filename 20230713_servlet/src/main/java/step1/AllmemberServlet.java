package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import vo.memberVO;
import dao.memberDao;
/**
 * Servlet implementation class AllmemberServlet
 */
@WebServlet("/AllmemberServlet")
public class AllmemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllmemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");

		// TODO Auto-generated method stub
		
	    response.setContentType("application/json; charset=utf-8");
	    response.setCharacterEncoding("utf-8");
		
		PrintWriter out = response.getWriter();
		memberDao dao = new memberDao();
		List<memberVO> memberList = dao.SelectAll();

		// 회원 목록을 JSON 형식의 문자열로 생성
	    StringBuilder json = new StringBuilder();
	    json.append("[");
	    for (int i = 0; i < memberList.size(); i++) {
	        memberVO member = memberList.get(i);
	        json.append("{");
	        json.append("\"id\":\"").append(member.getId()).append("\",");
	        json.append("\"name\":\"").append(member.getName()).append("\",");
	        json.append("\"address\":\"").append(member.getAddress()).append("\",");
	        json.append("\"password\":\"").append(member.getPassword()).append("\"");
	        json.append("}");
	        if (i < memberList.size() - 1) {
	            json.append(",");
	        }
	    }
	    json.append("]");

	    out.print(json.toString());
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
