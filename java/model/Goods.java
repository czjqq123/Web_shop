package model;

public class Goods {

	private int id;
	private String name;
	private String cover;
	private float price;
	private String intro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	
	public Goods() {
		super();
	}
	public Goods(int id, String name, String cover, float price, String intro) {
		super();
		this.id = id;
		this.name = name;
		this.cover = cover;
		this.price = price;
		this.intro = intro;
	}
}
