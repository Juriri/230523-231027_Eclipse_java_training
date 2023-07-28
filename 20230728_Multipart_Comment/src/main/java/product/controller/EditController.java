package product.controller;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import model.Member;
import model.Product;
import product.service.Service;
import product.service.ServiceImpl;

/**
 * Servlet implementation class EditController
 */
@WebServlet(name = "ProdEditController", urlPatterns = { "/seller/Edit" })
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditController() {
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
		request.setCharacterEncoding("euc-kr");
		response.setContentType("text/html; charset=euc-kr");
		request.setCharacterEncoding("euc-kr");
		
		Service service  = new ServiceImpl();
		int num = Integer.parseInt(request.getParameter("num"));
		Product product = service.getProduct(num);
		
		if(product != null) {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			
			//로그인된 사용자의 아이디와 작성된 글의 s_id가 일치해야만 수정 가능
			if(member.getId().equals(product.getS_id())) {
				String name = request.getParameter("name");
				int quantity = Integer.parseInt(request.getParameter("quantity"));
				int price = Integer.parseInt(request.getParameter("price"));
				String content = request.getParameter("content");
				
				product.setName(name);
				product.setQuantity(quantity);
				product.setPrice(price);
				product.setContent(content);
				
				service.editProduct(product);
				
				// 수정이 완료되면 해당 상품의 상세 페이지로 리다이렉트
				request.setAttribute("msg", "수정 완료되었습니다.");
				request.setAttribute("product", product);
				
				String path="/view/seller/detail.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				if(dispatcher != null) {
					dispatcher.forward(request, response);
				}
				
			} else {
				String path="/seller/List";
				String msg = "작성자가 아니여서 권한이 없습니다.";
				request.setAttribute("msg", msg);
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				if(dispatcher != null) {
					dispatcher.forward(request, response);
				}
			}
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
