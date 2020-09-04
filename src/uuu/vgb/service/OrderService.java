package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Order;
import uuu.vgb.entity.Outlet;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.WantChange;

public class OrderService {
	
	public double order(Customer c ,Product p, int quantitiy) {
		double amount=p.getUnitPrice()*quantitiy;
	return amount;
	}
	
	OrdersDAO dao = new OrdersDAO(); 
	public void register(Order o) throws VGBException{
		if(o==null) {
			throw new IllegalArgumentException("訂單o不得為null");
		}
		dao.insert(o);	
	}
	public List<Order> getOrderBuyByUserID(String UserID)throws VGBException{
		return dao.selectOrderByUserID(UserID);
		}
	public List<Order> getOrderBuyByOwnerID(String ownerID)throws VGBException{
		return dao.selectOrderByOwnerID(ownerID);
		}
	public void update(Order o) throws VGBException{
		if(o==null) {
			throw new IllegalArgumentException("訂單p不得為null");
		}
		dao.update(o);	
	
}
}
