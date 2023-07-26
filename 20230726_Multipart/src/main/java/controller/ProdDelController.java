package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Product;
import service.Service;
import service.ServiceImpl;

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
		Service service = new ServiceImpl();
		
		int num = Integer.parseInt(request.getParameter("num"));
		Product product = service.getProduct(num);
		service.delProduct(num);
		
		String uploadPath="C:\\Users\\KOSTA\\Desktop\\workspace2\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img";
		String[] arr=product.getImg().split("/");
		String fname = arr[arr.length-1];
		File f = new File(uploadPath+fname);
		f.delete();
		
		
		String path="/seller/List";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		if(dispatcher != null) {
			dispatcher.forward(request, response);
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
