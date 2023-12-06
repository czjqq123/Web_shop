package servelt;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Goods;
import model.Page;
import service.GoodsService;

/**
 * Servlet implementation class GoodsListServlet
 */
@WebServlet("/goods_list")
public class GoodsListServlet extends HttpServlet {
	private GoodsService gService = new GoodsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int pageNo=1;
		if(request.getParameter("pageNo")!=null)
		{
			pageNo=Integer.parseInt(request.getParameter("pageNo"));
		}
		
		Page p=gService.getGoodsPage(pageNo);
		request.setAttribute("p", p);
		
		request.getRequestDispatcher("/goods_list.jsp").forward(request, response);
	}

}
