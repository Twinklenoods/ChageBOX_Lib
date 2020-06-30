package uuu.vgb.entity;

public class Outlet extends Product {
	private int discount=20;

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount>0&&discount<100) {this.discount = discount;}
		else {System.err.println("則扣必須在1~99%之間");}
	}
	
	
	public String getDiscount2() {
		int discount =100-this.discount;
	if(discount%10==0) {discount/=10;}
	return discount+"折";
		}
			
	public double getUnitPrice(){
		double price=unitPrice*(100D-discount)/100;
		return price;
	}
	
	public double ListUnitPrice(){
		double price=unitPrice;
		return price;}
	
	
	
}
