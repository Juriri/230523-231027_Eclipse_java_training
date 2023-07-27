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
 * Servlet implementation class AddController
 */
@WebServlet("/seller/Add")
public class AddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddController() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		Service service = new ServiceImpl();
		Product p = new Product();
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		String img = "";
		
		int maxSize = 1024 * 1024 * 10;
		MultipartRequest multi = null;
	
		//String uploadPath="C:\\Users\\KOSTA\\Desktop\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\webapps\\shop_img";
		String uploadPath = "/Users/hyunjulee/Desktop/eclipse_workspace/230523-231027_Eclipse_java_training/20230727_Multipart/src/main/webapp/shop_img";
		try {
			p.setNum(service.makeNum());
			p.setS_id(member.getId());

			multi = new MultipartRequest(request, uploadPath, maxSize, "utf-8", new DefaultFileRenamePolicy());
			p.setName(multi.getParameter("name"));
			p.setQuantity(Integer.parseInt(multi.getParameter("quantity")));
			p.setPrice(Integer.parseInt(multi.getParameter("price")));
			p.setContent(multi.getParameter("content"));
			
			//전송한 전체 파일 이름들을 가져옴
			Enumeration files = multi.getFileNames();
			
			while(files.hasMoreElements()){
				//form 태크에서 name="여기에 지정한 이름"을 가져온다.
				String file1 = (String)files.nextElement();
				img = multi.getFilesystemName(file1);
				//파일 업로드
				File file = multi.getFile(file1);
				
			}
			
			p.setImg("/shop_img/"+img);
			service.add(p);
	
			
			String path="/seller/List";
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(path);
			if(dispatcher != null) {
				dispatcher.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
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
