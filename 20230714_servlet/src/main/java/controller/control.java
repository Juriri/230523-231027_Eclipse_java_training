package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.service;
import step1.BookVo;
/**
 * Servlet implementation class control
 */
@WebServlet("/control")
public class control extends HttpServlet {
	service ser = service.getInstance();
	
	private static final long serialVersionUID = 1L;
       
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
		String type = request.getParameter("type");
		if( type != null && type.equals("list")) {
            // 전달받은 파라미터를 처리하는 로직 작성
            List<BookVo> bookList = ser.BookSelectAll();
            
            // bookList를 request 속성에 저장
            request.setAttribute("bookList", bookList);
            
            // list.jsp로 포워딩
            RequestDispatcher dispatcher = request.getRequestDispatcher("/list.jsp");
            dispatcher.forward(request, response);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String type = request.getParameter("type");
		// http://localhost:8080/20230714_servlet/control?type=insert
	        if (type != null && type.equals("insert")) {
	            String author = request.getParameter("author");
	            String title = request.getParameter("title");
	            String publisher = request.getParameter("publisher");
	            String content = request.getParameter("content");
	            
	            // 전달받은 파라미터를 처리하는 로직 작성
	            ser.BookInsert(new BookVo(0, author, title, publisher, content));

	        } else if (type != null && type.equals("search")) {
	            String search_title = request.getParameter("title");
	            
	            
	            BookVo book = ser.BookSelect(search_title);
	            
	         // 검색 결과를 request 속성에 저장
	            request.setAttribute("book", book);
	            
	            // search.jsp로 포워딩
	            RequestDispatcher dispatcher = request.getRequestDispatcher("/find.jsp");
	            dispatcher.forward(request, response);

	        }
	}

}
