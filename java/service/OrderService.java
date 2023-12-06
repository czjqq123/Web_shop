package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import dao.OrderDao;
import model.Order;
import model.OrderItem;
import model.Page;
import utils.DBUtil;

public class OrderService {

	private OrderDao oDao=new OrderDao();
	
	public void addOrder(Order order) {
		Connection con=null;
		try {
			con=DBUtil.getConnection();
			con.setAutoCommit(false);
			
			oDao.insertOrder(con, order);
			int id=oDao.getLastInsertId(con);
			order.setId(id);
			for(OrderItem item:order.getItemMap().values())
			{
				oDao.insertOrderItem(con, item);
			}
			
			con.commit();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
		}
	}
	
	public List<Order> selectOrdersByUserId(int userId){
		List<Order> list=null;
		try {
			list = oDao.selectOrdersByUserId(userId);
			for(Order o:list) {
				List<OrderItem> l = oDao.selectOrderItemByOrderId(o.getId());
				o.setItemList(l);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}

	public Page getOrderPage(int pageNo) {
		Page p = new Page();
		
		p.setPageNo(pageNo);
		int totalCount = 0;
		try {
			totalCount=oDao.getAllOrdersCount();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(10, totalCount);
		
		List list=null;
		try {
			list = oDao.getAllOrdersList(pageNo, 10);
			for(Order o:(List<Order>)list) {
				List<OrderItem> l = oDao.selectOrderItemByOrderId(o.getId());
				o.setItemList(l);
			}
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		p.setList(list);
		
		return p;
	}
	
	public void deleteOrder(int id) {
		Connection con=null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			
			oDao.deleteOrderItem(con, id);
			oDao.deleteOrder(con, id);
			con.commit();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			if(con!=null)
				try {
					con.rollback();
				} catch (SQLException e1) {
					// TODO 自动生成的 catch 块
					e1.printStackTrace();
				}
		}
		
	}
}
