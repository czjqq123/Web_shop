package servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;

/**
 * Servlet implementation class AdminGoodsDeleteServlet
 */
@WebServlet("/admin/goods_delete")
public class AdminGoodsDeleteServlet extends HttpServlet {
	
	private GoodsService gService = new GoodsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int id=Integer.parseInt(request.getParameter("id"));
		if(gService.deleteGoods(id))request.setAttribute("msg", "删除货物成功！");
		else request.setAttribute("failMsg", "删除货物失败，该货物具有多条订单信息，不可删除！");
		
		request.getRequestDispatcher("/admin/goods_list").forward(request, response);
	}
}
