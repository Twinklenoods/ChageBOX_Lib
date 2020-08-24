package uuu.vgb.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ShoppingCart {
	private Customer customer;
	private Map<CartItem, Integer> cart = new HashMap<>();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void add(Product p) {
		if (p == null) {
			throw new IllegalArgumentException("加入購物車時產品物件不得為null");
		}
		CartItem item = new CartItem();
		item.setProduct(p);

		cart.put(item, 1);
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + "[訂購人=" + customer + ",\n" + " 購物明細=";
		for (Map.Entry<CartItem, Integer> entry : cart.entrySet()) {
			result += "\n購買" + entry.getKey().toString() + ",\n買了" + entry.getValue() + "個";
		}
		return result;
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
	public Map<CartItem, Integer> getCart() {
		return cart;
	}
}