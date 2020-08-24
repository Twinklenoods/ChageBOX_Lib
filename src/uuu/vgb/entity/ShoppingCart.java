package uuu.vgb.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
	private Customer member;
	private List<CartItem> cart=new ArrayList<CartItem>();
	public void add (Product p) {
	
		cart.add(p);}

	
    
		
		
		//CartItem item= new CartItem();
		//add(p,quantity);		
	
		//item.setProduct(p);
		//找出是否有購買相同商品的舊數量
	////	Integer oldQuantity = cart.get(item);
	//	if(oldQuantity!=null) quantity+=oldQuantity;//
	//	cart.put(item, quantity);
	
//cart's的accessor(s)
	
	public List<CartItem> getCart() {
		return cart;
	}


	
}

