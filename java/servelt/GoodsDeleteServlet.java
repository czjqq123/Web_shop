package servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Order;

/**
 * Servlet implementation class GoodsDeleteServlet
 */
@WebServlet("/goods_delete")
public class GoodsDeleteServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order o = (Order)request.getSession().getAttribute("order");
		
		int id=Integer.parseInt(request.getParameter("goodsid"));
		o.deleteGoods(id);
		response.getWriter().print("ok");
	}

}
