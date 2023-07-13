package step1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.memberVO;
import dao.memberDao;

/**
 * Servlet implementation class memberSearchServlet
 */
@WebServlet("/memberSearchServlet")
public class memberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public memberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0");

        response.setContentType("application/json; charset=utf-8");
        response.setCharacterEncoding("utf-8");

        PrintWriter out = response.getWriter();
        memberDao dao = new memberDao();
        List<memberVO> memberList = dao.findMember(request.getParameter("id"));

        if (!memberList.isEmpty()) {
            StringBuilder json = new StringBuilder();
            json.append("[");

            for (int i = 0; i < memberList.size(); i++) {
                memberVO vo = memberList.get(i);

                json.append("{");
                json.append("\"id\":\"").append(vo.getId()).append("\",");
                json.append("\"name\":\"").append(vo.getName()).append("\",");
                json.append("\"address\":\"").append(vo.getAddress()).append("\",");
                json.append("\"password\":\"").append(vo.getPassword()).append("\"");
                json.append("}");

                if (i < memberList.size() - 1) {
                    json.append(",");
                }
            }

            json.append("]");

            out.println(json.toString());
        } else {
        	out.println("[]");
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
