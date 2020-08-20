package uuu.vgb.service;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.VGBException;

public class CustomerService {
	CustomersDAO dao = new CustomersDAO(); 
	public void register(Customer c) throws VGBException{
		if(c==null) {
			throw new IllegalArgumentException("客戶c不得為null");
		}
		dao.insert(c);	
	}
	
	public Customer login(String id,String pwd) throws VGBException{
		
		if(id==null||pwd==null) {
			throw new IllegalArgumentException("帳號密碼沒輸入");
		}
		
		Customer c=null;
		c=dao.selectCustomersById(id);
		
		
		if(c!=null) {
			if(pwd.equals(c.getPassword())) {
			return c;
			}
			
			
		}
			throw new VGBException("目前密碼輸入錯誤");
		
	}
	/*追加的update*/
	public void update(Customer c) throws VGBException{
		if(c==null) {
			throw new IllegalArgumentException("客戶c不得為null");
		}
		dao.update(c);	
	}
}
