package servelt;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import model.Order;
import service.GoodsService;

/**
 * Servlet implementation class GoodsBuyServlet
 */
@WebServlet("/goods_buy")
public class GoodsBuyServlet extends HttpServlet {
	
	private GoodsService gService=new GoodsService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		Order o = null;
		if(request.getSession().getAttribute("order")!=null)
		{
			o=(Order)request.getSession().getAttribute("order");
		}
		else
		{
			o=new Order();
			request.getSession().setAttribute("order", o);
		}
		
		int id=Integer.parseInt(request.getParameter("goodsid"));
		Goods g = gService.getGoodsById(id);
		o.addGoods(g);
		response.getWriter().print("ok");
	}

}
