package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Order {

	private int id;
	private float total;
	private int amount;
	private String name;
	private String phone;
	private String address;
	private User user;
	
	private Map<Integer,OrderItem> itemMap = new HashMap<Integer, OrderItem>();
	private List<OrderItem> itemList=new ArrayList<OrderItem>();
	
	public void setUsername(String username) {
		user=new User();
		user.setUsername(username);
	}
	
	public void addGoods(Goods g) {
		if(itemMap.containsKey(g.getId()))
		{
			OrderItem item = itemMap.get(g.getId());
			item.setAmount(item.getAmount()+1);
		}
		else
		{
			OrderItem item = new OrderItem(g.getPrice(), 1, g, this);
			itemMap.put(g.getId(), item);
		}
		amount++;
		total+=g.getPrice();
	}
	
	public void lessenGoods(int goodsid) {
		if(itemMap.containsKey(goodsid))
		{
			OrderItem item = itemMap.get(goodsid);
			item.setAmount(item.getAmount()-1);
			amount--;
			total-=item.getPrice();
			if(item.getAmount()<=0)
			{
				itemMap.remove(goodsid);
			}
		}
	}
	
	public void deleteGoods(int goodsid) {
		if(itemMap.containsKey(goodsid))
		{
			OrderItem item = itemMap.get(goodsid);
			amount-=item.getAmount();
			total-=item.getPrice()*item.getAmount();
			itemMap.remove(goodsid);
		}
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Map<Integer, OrderItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<Integer, OrderItem> itemMap) {
		this.itemMap = itemMap;
	}

	public List<OrderItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}

	public Order() {
		super();
	}
}
