package uuu.vgb.entity;

public class Order {

	public int id;//流水號
	public int productID;
	public int uniprice;
	public int pay;//付款方式
	public int use;//貨運方式
	public int pay_fee;//付款方式
	public String use_fee;//貨運方式
	public String name;
	public String phone;
	public String email;
	public String address;
	public String createTime;
	public String userID;
	public String ownerID;
	public String proName;
	
	
	
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getOwnerID() {
		return ownerID;
	}
	public void setOwnerID(String ownerID) {
		this.ownerID = ownerID;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public int getUniprice() {
		return uniprice;
	}
	public void setUniprice(int uniprice) {
		this.uniprice = uniprice;
	}
	public int getPay() {
		return pay;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
	public int getUse() {
		return use;
	}
	public void setUse(int use) {
		this.use = use;
	}
	public int getPay_fee() {
		return pay_fee;
	}
	public void setPay_fee(int pay_fee) {
		this.pay_fee = pay_fee;
	}
	public String getUse_fee() {
		return use_fee;
	}
	public void setUse_fee(String use_fee) {
		this.use_fee = use_fee;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "order [id=" + id + ", productID=" + productID + ", uniprice=" + uniprice + ", pay=" + pay + ", use="
				+ use + ", pay_fee=" + pay_fee + ", use_fee=" + use_fee + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", address=" + address + ", createTime=" + createTime + "]";
	}
	
	
}
