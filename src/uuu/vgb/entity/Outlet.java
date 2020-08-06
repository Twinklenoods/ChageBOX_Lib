package uuu.vgb.entity;

public class Outlet extends Product {
	private int discount=2;//手續費

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		if(discount>0&&discount<100) {this.discount = discount;}
		else {System.out.println("手續費必須在1~100%之間");}
	}
	
	
	public String getDiscount2() {
		int discount =this.discount;
	
	return discount+"%手續費";
		}
			
	public double getUnitPrice3(){//手續費
		double price=super.getUnitPrice()*discount/100;
		return price;
	}
	public double getUnitPrice(){//賣家實收
		double price=super.getUnitPrice()-getUnitPrice3();
		return price;
	}
	public double ListUnitPrice(){//原價
		double price=super.getUnitPrice();
		return price;}

	@Override
	public String toString() {
		return super.toString()+"\n"
				+ "[手續費%=" + getDiscount2()+
				",手續費="+getUnitPrice3()+
				"賣家實收"+getUnitPrice()+"]"
				+"\n";
	}
	
	
	
}
