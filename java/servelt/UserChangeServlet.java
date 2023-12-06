package servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.UserService;

/**
 * Servlet implementation class UserChangeServlet
 */
@WebServlet("/user_change")
public class UserChangeServlet extends HttpServlet {
	
	private UserService uService = new UserService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("user");
		
		String name=request.getParameter("name");
		if(name!="")user.setName(name);
		String address=request.getParameter("address");
		if(address!="")user.setAddress(address);
		String phone=request.getParameter("phone");
		if(phone!="")user.setPhone(phone);
		String password=request.getParameter("password");
		String passwordNew=request.getParameter("passwordNew");
		if(password.equals(user.getPassword())&&passwordNew!="")
		{
			user.setPassword(passwordNew);
			request.setAttribute("successMsg", "修改密码成功！");
		}
		else
		{
			if(password!="")request.setAttribute("failMsg", "修改密码失败！");
		}
		
		uService.updateUser(user);
		if(name!=""||address!=""||phone!="")request.setAttribute("msg", "收货信息修改成功！");
		
		request.getRequestDispatcher("/user_center.jsp").forward(request, response);
	}

}
