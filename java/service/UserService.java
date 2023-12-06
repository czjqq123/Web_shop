package service;

import java.util.List;

import dao.UserDao;
import model.Order;
import model.OrderItem;
import model.Page;
import model.User;

public class UserService {

	private UserDao uDao=new UserDao();
	
	public boolean Register(User user) {
		try {
			if(uDao.isUsernameExist(user.getUsername()))
			{
				return false;
			}
			if(uDao.isEmailExist(user.getEmail()))
			{
				return false;
			}
			uDao.addUser(user);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}
	
	public User Login(String username,String password) {
		User user=null;
		try {
			user=uDao.selectUser(username, password);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return user;
	}
	
	public void updateUser(User user) {
		try {
			uDao.updateUser(user);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public Page getUserPage(int pageNo) {
		Page p = new Page();
		
		p.setPageNo(pageNo);
		int totalCount = 0;
		try {
			totalCount=uDao.getAllUserCount();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(5, totalCount);
		
		List list=null;
		try {
			list = uDao.getAllUserList(pageNo, 5);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		p.setList(list);
		
		return p;
	}
	
	public boolean resetUser(int id) {
		try {
			uDao.resetUser(id);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteUser(int id) {
		try {
			uDao.deleteUser(id);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}
}
