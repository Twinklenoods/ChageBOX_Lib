package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;

public class OrderService {
	
	public double order(Customer c ,Product p, int quantitiy) {
		double amount=p.getUnitPrice()*quantitiy;
	return amount;
	}
	
}
