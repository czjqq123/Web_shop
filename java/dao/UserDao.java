package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.Order;
import model.User;
import utils.DBUtil;

public class UserDao {

	public void addUser(User user) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="insert into user(username,email,password,name,phone,address,isadmin,isvalidate) value(?,?,?,?,?,?,?,?)";
		r.update(sql,user.getUsername(),user.getEmail(),user.getPassword(),user.getName(),user.getPhone(),user.getAddress(),user.isIsadmin(),user.isIsvalidate());
	}
	
	public boolean isUsernameExist(String username) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where username = ?";
		if(r.query(sql, new BeanHandler<User>(User.class),username)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public boolean isEmailExist(String email) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where email = ?";
		if(r.query(sql, new BeanHandler<User>(User.class),email)==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public User selectUser(String username,String password) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user where username = ? and password = ?";
		return r.query(sql, new BeanHandler<User>(User.class),username,password);
	}
	
	public void updateUser(User user) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="update user set name = ?,address = ?,phone = ?,password = ? where id = ?";
		r.update(sql,user.getName(),user.getAddress(),user.getPhone(),user.getPassword(),user.getId());
	}

	public int getAllUserCount() throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select count(*) from user";
		return r.query(sql, new ScalarHandler<Long>()).intValue();
	}

	public List<User> getAllUserList(int pageNo, int pageSize) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from user order by id desc limit ?,?";
		return r.query(sql, new BeanListHandler<User>(User.class),(pageNo-1)*pageSize,pageSize);
	}
	
	public void resetUser(int id) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="update user set password = '123456' where id = ?";
		r.update(sql,id);
	}

	public void deleteUser(int id) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="delete from user where id = ?";
		r.update(sql,id);
	}
}
