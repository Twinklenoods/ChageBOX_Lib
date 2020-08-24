package uuu.vgb.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ShoppingCart {
	private Customer member;	
	private Map<CartItem, Integer> cart = new HashMap<>();
	
	public Customer getMember() {
		return member;
	}
	public void setMember(Customer member) {
		this.member = member;
	}
	
	//cart的mutator(s)
	public void add(Product p, int quantity) {
		add(p, null, "", quantity);
	}
	
	public void add(Product p, String colorName, int quantity) {
		add(p, colorName, "", quantity);
	}
	
	public void add(Product p, String colorName,String size, int quantity) {
		if(p==null) {
			throw new IllegalArgumentException("加入購物車時產品物件不得為null");
		}
		Color color = p.findColor(colorName);		
		CartItem item = new CartItem();
		item.setProduct(p);
		item.setColor(color);
		if(size!=null && size.length()>0) {
			item.setSize(size);
		}
		
		//找出是否有購買相同品項的舊數量
		Integer oldQuantity = cart.get(item); 
 		if(oldQuantity!=null) quantity+=oldQuantity;
 		
		cart.put(item, quantity);
	}
	
	@Override
	public String toString() {
		String result=getClass().getSimpleName()+
				"[訂購人=" + member + ",\n"
				+ " 購物明細="; 
		for(Map.Entry<CartItem, Integer> entry :cart.entrySet()) {		
			result+= "\n購買"+ entry.getKey().toString() + ",\n買了" + entry.getValue() + "個";
		}				
		return result;
	}
	
	//cart's的accessor(s)的寫法
	public int size() {
		return cart.size();
	}
	
//	public double getSubAmount(CartItem key) {
//		return key.getProduct().getUnitPrice() 
//				* cart.get(key);
//	}
	
	public Integer getQuantity(CartItem key) {
		return cart.get(key);
	}
	
	public Set<CartItem> getCartItemSet() {
		return cart.keySet();
	}
	
	public int getTotalQuantity() {
		int sum = 0;		
		for(Integer quantity:cart.values()) {
			if(quantity!=null) {
				sum = sum + quantity;
				//sum += quantity;
			}
		}		
		return sum;
	}
	
	public double getTotalAmount() {
		double sum = 0;
		for(Map.Entry<CartItem, Integer> entry:cart.entrySet()) {
			CartItem item = entry.getKey();
			Integer quantity = entry.getValue();
			
			sum += item.getProduct().getUnitPrice() * quantity;
		}
		
		return sum;
	}
}
