package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.OwnerQa;
import uuu.vgb.entity.Question;
import uuu.vgb.entity.VGBException;

public class OwnerQaService {

	OwnerQaDAO dao =new OwnerQaDAO ();
		public void register(OwnerQa q) throws VGBException{
			if(q==null) {
				throw new IllegalArgumentException("問題q不能等於null");
			}
			dao.insert(q);
		} 
		public List<OwnerQa> getOwnerID(String OwnerID,String CustomerID)throws VGBException{
			return dao.selectOwnerQaByID(OwnerID,CustomerID);
			}
		
}

