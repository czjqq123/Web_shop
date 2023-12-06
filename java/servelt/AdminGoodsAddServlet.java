package servelt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.Goods;
import service.GoodsService;

/**
 * Servlet implementation class AdminGoodsAddServlet
 */
@WebServlet("/admin/goods_add")
public class AdminGoodsAddServlet extends HttpServlet {
	
	private GoodsService gService = new GoodsService();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> list = upload.parseRequest(request);
			Goods g=new Goods();
			for(FileItem item:list)
			{
				if(item.isFormField())
				{
					switch (item.getFieldName()){
						case "name":
							g.setName(item.getString("utf-8"));
							break;
						case "price":
							g.setPrice(Integer.parseInt(item.getString("utf-8")));
							break;
						case "intro":
							g.setIntro(item.getString("utf-8"));
							break;
					}
				}
				else
				{
					if(item.getInputStream().available()<=0)continue;
					String fileName = item .getName();
					String path = this.getServletContext().getRealPath("/picture")+"/"+fileName;
					InputStream in=item.getInputStream();
					FileOutputStream out=new FileOutputStream(path);
					byte[] buffer=new byte[1024];
					int len=0;
					while((len=in.read(buffer))>0)
					{
						out.write(buffer);
					}
					in.close();
					out.close();
					item.delete();
					
					g.setCover("/picture"+"/"+fileName);
					gService.addGoods(g);
					
					request.setAttribute("msg", "增加货物成功！");
					request.getRequestDispatcher("/admin/goods_list").forward(request, response);
				}
			}
		} catch (FileUploadException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
