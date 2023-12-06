package dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import model.Goods;
import utils.DBUtil;

public class GoodsDao {

	public List<Map<String, Object>> getRecommendGoodsList() throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from goods limit 0,6";
		return r.query(sql, new MapListHandler());
	}
	
	public Map<String, Object> getScrollGoods() throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from goods";
		return r.query(sql, new MapHandler());
	}
	
	public List<Goods> getAllGoodsList(int pageNo, int pageSize) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from goods limit ?,?";
		return r.query(sql, new BeanListHandler<Goods>(Goods.class),(pageNo-1)*pageSize,pageSize);
	}
	
	public int getAllGoodsCount() throws Exception{
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select count(*) from goods";
		return r.query(sql, new ScalarHandler<Long>()).intValue();
	}
	
	public Goods getGoodsById(int id) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from goods where id = ?";
		return r.query(sql, new BeanHandler<Goods>(Goods.class), id);
	}

	public int getSearchGoodsCount(String keyword) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select count(*) from goods where name like ?";
		return r.query(sql, new ScalarHandler<Long>(), "%"+keyword+"%").intValue();
	}

	public List<Goods> getSearchGoodsList(String keyword, int pageNo, int pageSize) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="select * from goods where name like ? limit ?,?";
		return r.query(sql, new BeanListHandler<Goods>(Goods.class),"%"+keyword+"%",(pageNo-1)*pageSize,pageSize);
	}
	
	public void addGoods(Goods g) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="insert into goods(name,cover,price,intro) value(?,?,?,?)";
		r.update(sql,g.getName(),g.getCover(),g.getPrice(),g.getIntro());
	}
	
	public void deleteGoods(int id) throws Exception {
		QueryRunner r=new QueryRunner(DBUtil.getDataSource());
		String sql="delete from goods where id = ?";
		r.update(sql,id);
	}
}
