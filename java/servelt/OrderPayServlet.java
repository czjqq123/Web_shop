package servelt;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import model.Order;
import model.User;
import service.OrderService;

/**
 * Servlet implementation class OrderPayServlet
 */
@WebServlet("/order_pay")
public class OrderPayServlet extends HttpServlet {
	private OrderService oService=new OrderService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Order o=(Order)request.getSession().getAttribute("order");
		try {
			BeanUtils.copyProperties(o, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		o.setUser((User)request.getSession().getAttribute("user"));
		oService.addOrder(o);
		
		request.getSession().removeAttribute("order");
		request.setAttribute("msg", "订单支付成功！");
		
		request.getRequestDispatcher("/order_success.jsp").forward(request, response);
	}

}
