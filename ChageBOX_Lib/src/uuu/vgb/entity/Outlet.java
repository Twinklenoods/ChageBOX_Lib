package uuu.vgb.entity;

public class Outlet extends Product {
	private int discount=102;

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount<120&&discount>100) {this.discount = discount;}
		else {System.err.println("手續費必須在100~120%之間");}
	}
	
	
	public String getDiscount2() {
		int discount =this.discount-100;
	
	return discount+"%手續費";
		}
			
	public double getUnitPrice(){
		double price=unitPrice*discount/100;
		return price;
	}
	
	public double ListUnitPrice(){
		double price=unitPrice;
		return price;}
	
	
	
}
