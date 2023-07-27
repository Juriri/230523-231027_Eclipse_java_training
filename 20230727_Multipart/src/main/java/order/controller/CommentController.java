package order.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import comment.service.Service;
import comment.service.ServiceImpl;
import model.Comment;

/**
 * Servlet implementation class CommentController
 */
@WebServlet("/order/CommentController")

public class CommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		request.setCharacterEncoding("euc-kr");
		
		String action = request.getParameter("action");
		Service service = new ServiceImpl();
		
		if(action.equals("add")) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			String userId = request.getParameter("userId");
			String commentText = request.getParameter("commentText");
			
			Comment comment = new Comment(productId, userId, commentText);
			service.add(comment);
			String path = "/seller/detail?num=" + productId + "&type=customer";
			System.out.println("path "+path);
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			if(dispatcher != null) {
				dispatcher.forward(request, response);
			}
			///seller/detail?num=${product.getNum()}&type=customer
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
