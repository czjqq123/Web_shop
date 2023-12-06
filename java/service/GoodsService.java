package service;

import java.util.List;
import java.util.Map;

import dao.GoodsDao;
import model.Goods;
import model.Page;

public class GoodsService {
	private GoodsDao gDao=new GoodsDao();
	
	public List<Map<String, Object>> getRecommendGoodsList(){
		List<Map<String,Object>> list=null;
		try {
			list=gDao.getRecommendGoodsList();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	public Map<String, Object> getScrollGoodsList(){
		Map<String,Object> map=null;
		try {
			map=gDao.getScrollGoods();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return map;
	}
	
	public Page getGoodsPage(int pageNo) {
		Page p = new Page();
		
		p.setPageNo(pageNo);
		int totalCount = 0;
		try {
			totalCount=gDao.getAllGoodsCount();
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(8, totalCount);
		
		List list=null;
		try {
			list = gDao.getAllGoodsList(pageNo, 8);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		p.setList(list);
		
		return p;
	}
	
	public Goods getGoodsById(int id) {
		Goods g=null;
		try {
			g = gDao.getGoodsById(id);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return g;
	}

	public Page getSearchGoodsPage(String keyword, int pageNo) {
		Page p = new Page();
		
		p.setPageNo(pageNo);
		int totalCount = 0;
		try {
			totalCount=gDao.getSearchGoodsCount(keyword);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		p.setPageSizeAndTotalCount(8, totalCount);
		
		List list=null;
		try {
			list = gDao.getSearchGoodsList(keyword, pageNo, 8);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		p.setList(list);
		
		return p;
	}
	
	public void addGoods(Goods g) {
		try {
			gDao.addGoods(g);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
	public boolean deleteGoods(int id) {
		try {
			gDao.deleteGoods(id);
			return true;
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			return false;
		}
	}
}
