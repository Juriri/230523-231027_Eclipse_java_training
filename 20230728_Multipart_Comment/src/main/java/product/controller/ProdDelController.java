package product.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Product;
import product.service.Service;
import product.service.ServiceImpl;

/**
 * Servlet implementation class ProdDelController
 */
@WebServlet("/seller/Del")
public class ProdDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdDelController() {
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
		
		Service service  = new ServiceImpl();
		int num = Integer.parseInt(request.getParameter("num"));
		Product product = service.getProduct(num);
		
		String uploadPath="C:\\Users\\KOSTA\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img\\";
		//String uploadPath = "/Users/hyunjulee/Desktop/eclipse_workspace/230523-231027_Eclipse_java_training/20230727_Multipart/src/main/webapp/shop_img/";
		String[] arr=product.getImg().split("/");
		String fname = arr[arr.length-1];
		
		if(product != null) {
			HttpSession session = request.getSession();
			Member member = (Member) session.getAttribute("member");
			
			//로그인된 사용자의 아이디와 작성된 글의 s_id가 일치해야만 삭제 가능
			if(member.getId().equals(product.getS_id())) {
				File f = new File(uploadPath+fname);
				f.delete();
				service.delProduct(num);
				
				String path="/seller/List";
				
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
