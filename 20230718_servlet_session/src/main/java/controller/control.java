package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Member;
import service.EventService;
import service.Service;

/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Service service = new EventService();
    
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

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");

		String type = request.getParameter("type");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String email = request.getParameter("email");
		String resultView = "event/";

		
		if(type.equals("insert")) {
			Member mem = new Member(id, pwd, email);
			service.insert(mem);
			resultView="event/list.jsp";
			
			request.setAttribute("data", service.list());
		}
		
		if(type.equals("list")) {
			resultView="event/list.jsp";
			request.setAttribute("data", service.list());
		}
		
		if(type.equals("delete")) {
			int num = Integer.parseInt(request.getParameter("num"));
			service.delete(num);
			resultView="event/form.jsp";
		}
		
		
		if(type.equals("update")) {
			int num = Integer.parseInt(request.getParameter("num"));			
			request.setAttribute("data", service.getMember(num));
			
			resultView="event/edit.jsp";
			
		}
		
		if(type.equals("update.do")) {
			int num = Integer.parseInt(request.getParameter("num"));
			pwd = request.getParameter("pwd");
			email = request.getParameter("email");
			Member m = service.getMember(num);
			
			
			m.setPwd(pwd);
			m.setEmail(email);
			service.edit(m);
			
			resultView="event/list.jsp";
			request.setAttribute("data", service.list());
			
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(resultView);
		dis.forward(request, response);
		 
	
	}

}
