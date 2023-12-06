package servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;
import model.OrderItem;
import model.User;
import service.OrderService;

/**
 * Servlet implementation class OrderListServlet
 */
@WebServlet("/order_list")
public class OrderListServlet extends HttpServlet {
	
	OrderService oService = new OrderService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		User user = (User)request.getSession().getAttribute("user");
		List<Order> list = oService.selectOrdersByUserId(user.getId());
		request.setAttribute("orderlist", list);
		
		request.getRequestDispatcher("/order_list.jsp").forward(request, response);
	}
}
