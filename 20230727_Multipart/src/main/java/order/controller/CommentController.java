package order.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import comment.service.Service;
import comment.service.ServiceImpl;
import model.Comment;
import model.Member;

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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		Service service = new ServiceImpl();
		
		//댓글 추가
		if(action.equals("add")) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			String userId = request.getParameter("userId");
			String commentText = request.getParameter("commentText");
			
			Comment comment = new Comment(productId, userId, commentText);
			service.add(comment);
			
			List<Comment> comments = service.selectAllByP_num(productId);
			
			// JSON 형식으로 변환하여 응답
	        response.setContentType("application/json");
			//Gson 라이브러리를 사용하여 comments 리스트를 JSON 형식으로 변환
	        Gson gson = new Gson();
	        String json = gson.toJson(comments);
	        //response.getWriter().write(json)을 사용하여 클라이언트로 JSON 데이터를 응답
	        response.getWriter().write(json);
		}
		
		if(action.equals("getComments")) {
			int productId = Integer.parseInt(request.getParameter("productId"));
			List<Comment> comments = service.selectAllByP_num(productId);
		
	        // JSON 형식으로 변환하여 응답
	        response.setContentType("application/json");
			//Gson 라이브러리를 사용하여 comments 리스트를 JSON 형식으로 변환
	        Gson gson = new Gson();
	        String json = gson.toJson(comments);
	        //response.getWriter().write(json)을 사용하여 클라이언트로 JSON 데이터를 응답
	        response.getWriter().write(json);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String action = request.getParameter("action");

	    if (action.equals("deleteComment")) {
	        int commentId = Integer.parseInt(request.getParameter("commentId"));
	        String commentuserId = request.getParameter("userId");
	        
	        Service service = new ServiceImpl();
	        service.delComment(commentId);

	    }
	}
}
