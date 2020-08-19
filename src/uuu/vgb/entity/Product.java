package uuu.vgb.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Product {
	private int id;// Pkey,AUTO_INCREMENT(surrogste key)
	private String name;// 可重複品項名稱,required,遊戲名稱
	private String owner;// 訂單建立者
	private String customer;// 交易對象
	private double unitPrice;// 單價,required//BuyPrice
	private String description = "";// 商品描述//comment1
	private String wantChange = "";// 想換的東西
	private String photoUrl;// 照片//img
	private String origin = "";// 面交地點,required
	private String host;// 主機,P-PS4,S-Switch,required
	private String buy;// private boolean married;參考
	private String changebox;// private boolean married;
	private String ownerN;// 訂單建立者name
	private String createTime;//建立時間
	private String updown;//建立時間

	

	public String getUpdown() {
		return updown;
	}

	public void setUpdown(String updown) {
		this.updown = updown;
	}

	public Product() {
	}

	public Product(int id, String name, double unitPrice) {
		super();
		this.id = id;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	public int getId() {
		return id;

	}

	public void setId(int string) {
		this.id = string;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		} else {
			System.out.println("需要產品名稱");
		}
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getOwnerN() {
		return ownerN;
	}

	public void setOwnerN(String ownerN) {
		this.ownerN = ownerN;
	}
	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getWantChange() {
		return wantChange;
	}

	public void setWantChange(String wantChange) {
		this.wantChange = wantChange;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}
	public String getBuy() {
		return buy;
		
	}
	public void setBuy(String buy) {
		this.buy = buy;
	}
	public String getChangebox() {
		return changebox;
		
	}
	public void setChangebox(String change) {
		this.changebox = change;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Product))
			return false;
		Product other = (Product) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [訂單編號=" + id + ", 遊戲名稱=" + name + ", 擁有者=" + owner +",擁有者=" + ownerN+ ", 買家=" + customer + ", 直購價格="
				+ unitPrice + ", 商品描述=" + description + ", wantChange=" + wantChange + ", 照片=" + photoUrl
				+ ", origin=" + origin + ", host=" + host + ", buy=" + buy + ", change=" + changebox 
				+ "]";
	}

	

}
