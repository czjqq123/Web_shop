package servelt;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.GoodsService;

/**
 * Servlet implementation class IndexServlet
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private GoodsService gService=new GoodsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//取得条幅商品（只有一个）
		Map<String, Object> map=gService.getScrollGoodsList();
		request.setAttribute("scroll", map);
		
		//取得推荐商品
		List<Map<String,Object>> list=gService.getRecommendGoodsList();
		request.setAttribute("recommendList", list);
		
		//跳转到index.jsp
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
