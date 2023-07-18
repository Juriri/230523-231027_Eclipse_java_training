<<<<<<< HEAD
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.EventService;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EventService service = EventService.getInstance();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public control() {
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
		
		if(type != null && type.equals("list")){
			request.setAttribute("member_list", service.MemberSelectAll());
			
			//list.jsp로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher("step1/list.jsp");
            dispatcher.forward(request, response);
		}
		
		if(type != null && type.equals("update")){
			int num = Integer.parseInt(request.getParameter("num"));
			
			Member m = service.MemberSelectbyId(num);
			request.setAttribute("member", m);
            RequestDispatcher dispatcher = request.getRequestDispatcher("step1/update.jsp");
            dispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///control?type=insert"
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("insert")){
			String name = request.getParameter("pd_name");
			String tel = request.getParameter("pd_tel");
			String address = request.getParameter("pd_addr");
			String postal = request.getParameter("pd_postal");
			
			Member m = new Member(name, tel, address, postal);
			service.MemberInsert(m);
			
			response.sendRedirect("step1/index.jsp");
		}
		
		if(type != null && type.equals("search")){
			String name = request.getParameter("pd_name");
			
			List<Member> arr = service.MemberSelect(name);
			request.setAttribute("member_result_list", arr);
			
			//search.jsp로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher("step1/search.jsp");
            dispatcher.forward(request, response);
		}
		
		if(type != null && type.equals("update.do")){
			int num = Integer.parseInt(request.getParameter("num"));
			String tel = request.getParameter("pd_tel");
			String address = request.getParameter("pd_addr");
			String postal = request.getParameter("pd_postal");
			
			Member m = service.MemberSelectbyId(num);
			m.setTel(tel);
			m.setAddress(address);
			m.setPostal(postal);
		
			service.MemberUpdate(m);
			
			response.sendRedirect("step1/list.jsp");
			
		}
		
	}

}
=======
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.EventService;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
    EventService service = EventService.getInstance();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public control() {
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
		
		if(type != null && type.equals("list")){
			request.setAttribute("member_list", service.MemberSelectAll());
			
			//list.jsp로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher("step1/list.jsp");
            dispatcher.forward(request, response);
		}
		
		if(type != null && type.equals("update")){
			int num = Integer.parseInt(request.getParameter("num"));
			
			Member m = service.MemberSelectbyId(num);
			request.setAttribute("member", m);
            RequestDispatcher dispatcher = request.getRequestDispatcher("step1/update.jsp");
            dispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		///control?type=insert"
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String type = request.getParameter("type");
		
		if(type != null && type.equals("insert")){
			String name = request.getParameter("pd_name");
			String tel = request.getParameter("pd_tel");
			String address = request.getParameter("pd_addr");
			String postal = request.getParameter("pd_postal");
			
			Member m = new Member(name, tel, address, postal);
			service.MemberInsert(m);
			
			response.sendRedirect("step1/index.jsp");
		}
		
		if(type != null && type.equals("search")){
			String name = request.getParameter("pd_name");
			
			List<Member> arr = service.MemberSelect(name);
			request.setAttribute("member_result_list", arr);
			
			//search.jsp로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher("step1/search.jsp");
            dispatcher.forward(request, response);
		}
		
		if(type != null && type.equals("update.do")){
			int num = Integer.parseInt(request.getParameter("num"));
			String tel = request.getParameter("pd_tel");
			String address = request.getParameter("pd_addr");
			String postal = request.getParameter("pd_postal");
			
			Member m = service.MemberSelectbyId(num);
			m.setTel(tel);
			m.setAddress(address);
			m.setPostal(postal);
		
			service.MemberUpdate(m);
			
			response.sendRedirect("step1/list.jsp");
			
		}
		
	}

}
>>>>>>> refs/remotes/origin/main
