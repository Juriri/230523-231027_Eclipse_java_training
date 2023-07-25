package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.service.Service;
import board.service.ServiceImpl;
import model.Board;

/**
 * Servlet implementation class DelBoardController
 */
@WebServlet("/DelBoardController")
public class DelBoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DelBoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		request.setCharacterEncoding("euc-kr");
		
		Service service = new ServiceImpl();
		
		int num  = Integer.parseInt(request.getParameter("num"));
		String type = request.getParameter("type");
		Board board = service.getBoard(num);
		
		RequestDispatcher dispatcher = null;
		
		if(type.equals("update")) {
			request.setAttribute("board", board);
			dispatcher = request.getRequestDispatcher("/board/search.jsp");
			if(dispatcher!=null) {
				dispatcher.forward(request, response);
			}
		}
		if(type.equals("delete")) {
			dispatcher = request.getRequestDispatcher("/member/result.jsp");
			service.delBoard(num);
			if(dispatcher!=null) {
				dispatcher.forward(request, response);
			}
		}
		
	}

}
