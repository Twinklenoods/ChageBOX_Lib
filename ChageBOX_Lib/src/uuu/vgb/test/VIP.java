package uuu.vgb.test;

import uuu.vgb.entity.Customer;

class VIP extends Customer {
	private int discount = 5;//5%off
	public int getDiscount(){return discount;}
	public void setDiscount(int discount){
		if(discount>0&&discount<100) {this.discount=discount;}
		else{System.err.println("則扣必須在1~99%之間");}
		}

	public String getDiscount2() {
		int discount =100-this.discount;
	if(discount%10==0) {discount/=10;}
	return discount+"折";
		}
			}
	
	