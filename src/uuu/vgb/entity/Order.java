package uuu.vgb.entity;

public class Order {

	public int id;//流水號
	public int productID;
	public int uniprice;
	public String pay;//付款方式
	public String use;//貨運方式
	public String pay_fee;//付款方式
	public String use_fee;//貨運方式
	public String name;
	public String phone;
	public String email;
	public String address;
	public String createTime;
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
	public String getPay() {
		return pay;
	}
	public void setPay(String pay) {
		this.pay = pay;
	}
	public String getUse() {
		return use;
	}
	public void setUse(String use) {
		this.use = use;
	}
	public String getPay_fee() {
		return pay_fee;
	}
	public void setPay_fee(String pay_fee) {
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
