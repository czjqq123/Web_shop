package servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Page;
import service.OrderService;

/**
 * Servlet implementation class AdminOrderListServlet
 */
@WebServlet("/admin/order_list")
public class AdminOrderListServlet extends HttpServlet {
	
	private OrderService oService=new OrderService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int pageNo=1;
		if(request.getParameter("pageNo")!=null)
		{
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
		
		Page p=oService.getOrderPage(pageNo);
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("/admin/order_list.jsp").forward(request, response);
	}
}
