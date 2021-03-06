package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.remind;

public class RemindService {
	RemindDAO dao = new RemindDAO(); 
	public void register(remind r) throws VGBException{
		if(r==null) {
			throw new IllegalArgumentException("客戶c不得為null");
		}
		dao.insert(r);	
	}
	
	public void register2(remind r) throws VGBException{
		if(r==null) {
			throw new IllegalArgumentException("客戶c不得為null");
		}
		dao.insert2(r);	
	}
	
	public void register3(remind r) throws VGBException{
		if(r==null) {
			throw new IllegalArgumentException("客戶c不得為null");
		}
		dao.insert3(r);	
	}
	/*追加的update*/
	public void update(remind r) throws VGBException{
		if(r==null) {
			throw new IllegalArgumentException("訂單p不得為null");
		}
		dao.update(r);	
	
}
	
	public List<remind> getRemind(String ownerID)throws VGBException{
		return dao.searctRemindByOwner(ownerID);
		}
	public List<remind> getRemindQ(String ownerID)throws VGBException{
		return dao.searctRemindByOwnerQ(ownerID);
		}
	public List<remind> getRemindC(String ownerID)throws VGBException{
		return dao.searctRemindByOwnerC(ownerID);
		}
}
