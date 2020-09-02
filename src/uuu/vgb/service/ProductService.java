package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;

public class ProductService {
	ProductsDAO dao = new ProductsDAO(); 
	public void register(Product c) throws VGBException{
		if(c==null) {
			throw new IllegalArgumentException("訂單c不得為null");
		}
		dao.insert(c);	
	}
	
	public Product login(String id,String owner) throws VGBException{
		
		if(id==null||owner==null) {
			throw new IllegalArgumentException("訂單編號,建立者沒輸入");
		}
		
		Product c=null;
		c=dao.selectProductsById(id);
		
		
		if(c!=null) {
			if(owner.equals(c.getOwner().getId())) {
			return c;
			}
			
			
		}
			throw new VGBException("訂單編號,建立者輸入錯誤");
		
	}
	public void update(Product p) throws VGBException{
		if(p==null) {
			throw new IllegalArgumentException("訂單p不得為null");
		}
		dao.update(p);	
	
}
	public void updown(Product p) throws VGBException{
		if(p==null) {
			throw new IllegalArgumentException("訂單p不得為null");
		}
		dao.updown(p);	
	
}
	public void deleteProduct(Product p) throws VGBException{
		if(p==null) {
			throw new IllegalArgumentException("訂單p不得為null");
		}
		dao.deleteProduct(p);	
	
}
	public void BUY(Product p) throws VGBException{
		if(p==null) {
			throw new IllegalArgumentException("訂單p不得為null");
		}
		dao.updownBUY(p);
}
	
	public void listrating(Product p) throws VGBException{
		if(p==null) {
			throw new IllegalArgumentException("訂單p不得為null");
		}
		dao.listrating(p);
}
}