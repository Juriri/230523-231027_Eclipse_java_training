package order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Member;
import model.Order;
import order.service.Service;
import order.service.ServiceImpl;

/**
 * Servlet implementation class OrderAddController
 */
@WebServlet("/order/add")
public class OrderAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public OrderAddController() {
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
		//O_state-> 주문 상태
		Service service  = new ServiceImpl();
		HttpSession session = request.getSession(false);
		Member member = (Member)session.getAttribute("member");
		String o_id = (String) member.getId();
	
		Order o = new Order();
		int product_num = (Integer.parseInt(request.getParameter("num")));
		int quantity = (Integer.parseInt(request.getParameter("quantity")));
		o.setO_state(Integer.parseInt(request.getParameter("o_state")));
		o.setPro_num(product_num);
		o.setO_id(o_id);
		o.setTotal_price(quantity);

		service.addOrder(o);
		String path = "/shop2/order/myList?o_state=";
		path += o.getO_state();
		response.sendRedirect(path);
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
