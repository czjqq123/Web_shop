package dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.Goods;
import model.Order;
import model.OrderItem;
import utils.DBUtil;

public class OrderDao {

	public void insertOrder(Connection con,Order order) throws Exception {
		QueryRunner r=new QueryRunner();
		String sql="insert into orders(total,amount,name,phone,address,user_id) value(?,?,?,?,?,?)";
		r.update(con,sql,order.getTotal(),order.getAmount(),order.getName(),order.getPhone(),order.getAddress(),order.getUser().getId());
	}
	
	public void insertOrderItem(Connection con,OrderItem item) throws Exception {
		QueryRunner r=new QueryRunner();
		String sql="insert into orderitem(price,amount,goods_id,order_id) value(?,?,?,?)";
		r.update(con,sql,item.getPrice(),item.getAmount(),item.getGoods().getId(),item.getOrder().getId());
	}
	
	public int getLastInsertId(Connection con) throws Exception {
		QueryRunner r=new QueryRunner();
		String sql="select last_insert_id()";
		return Integer.parseInt(r.query(con, sql, new ScalarHandler<BigInteger>()).toString());
	}
	
	public List<Order> selectOrdersByUserId(int userId) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql = "select * from orders where user_id = ? order by id desc";
		return r.query(sql, new BeanListHandler<Order>(Order.class),userId);
	}
	
	public List<OrderItem> selectOrderItemByOrderId(int orderId) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql ="select i.id,i.price,i.amount,g.name from orderitem i,goods g where order_id = ? and i.goods_id = g.id";
		return r.query(sql, new BeanListHandler<OrderItem>(OrderItem.class),orderId);
	}

	public int getAllOrdersCount() throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select count(*) from orders";
		return r.query(sql, new ScalarHandler<Long>()).intValue();
	}

	public List<Order> getAllOrdersList(int pageNo, int pageSize) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select o.id,o.total,o.amount,o.name,o.phone,o.address,u.username from orders o,user u where o.user_id=u.id order by id desc limit ?,?";
		return r.query(sql, new BeanListHandler<Order>(Order.class),(pageNo-1)*pageSize,pageSize);
	}
	
	public void deleteOrder(Connection con,int id) throws Exception {
		QueryRunner r=new QueryRunner();
		String sql="delete from orders where id = ?";
		r.update(con,sql,id);
	}
	
	public void deleteOrderItem(Connection con,int id) throws Exception {
		QueryRunner r=new QueryRunner();
		String sql="delete from orderitem where order_id = ?";
		r.update(con,sql,id);
	}
}
