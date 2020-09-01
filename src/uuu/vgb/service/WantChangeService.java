package uuu.vgb.service;


import java.util.List;

import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;
import uuu.vgb.entity.WantChange;

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
}
