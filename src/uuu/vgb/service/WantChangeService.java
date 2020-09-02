package uuu.vgb.service;


import java.util.List;

import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.WantChange;
import uuu.vgb.entity.remind;

public class WantChangeService {

	WantChangeDAO dao =new WantChangeDAO();
	public void register(WantChange w) throws VGBException{
		if(w==null) {
			throw new IllegalArgumentException("問題q不能等於null");
		}
		dao.insert(w);
	} 
	public List<WantChange> getWantChangeByProductID(String ownerID)throws VGBException{
		return dao.selectOwnerChangeByID(ownerID);
		}
	
	public List<WantChange> getWantChangeByUserID(String userID)throws VGBException{
		return dao.selectUserChangeByID(userID);
		}
	
	
	
	/*追加的update*/
	public void update(WantChange w) throws VGBException{
		if(w==null) {
			throw new IllegalArgumentException("訂單p不得為null");
		}
		dao.update(w);	
	
}

}
