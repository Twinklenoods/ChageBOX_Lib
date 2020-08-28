package uuu.vgb.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import uuu.vgb.entity.Customer;
import uuu.vgb.entity.OwnerQa;
import uuu.vgb.entity.Product;
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
		public List<OwnerQa> getOwnerIdOnly(String OwnerID)throws VGBException{
			return dao.selectOwnerQaByIdOnly(OwnerID);
			}
		
		public List<OwnerQa> getOwnerIdOn(String OwnerID)throws VGBException{
			return dao.selectOwnerQaByIdOn(OwnerID);
			}
		
		public List<OwnerQa> getOwnerIdOFF(String OwnerID)throws VGBException{
			return dao.selectOwnerQaByIdOFF(OwnerID);
			}
		public void updown(OwnerQa o) throws VGBException{
			if(o==null) {
				throw new IllegalArgumentException("訂單p不得為null");
			}
			dao.updownQA(o);	
}
		
		public OwnerQa login(int id,String ownerID) throws VGBException{
			
			if(ownerID==null) {
				throw new IllegalArgumentException("訂單編號,建立者沒輸入");
			}
			
			OwnerQa c=null;
			c=dao.selectOwner_QA_ById(id);
			
			
			if(c!=null) {
				
				return c;
				
				
				
			}
				throw new VGBException("訂單編號,建立者輸入錯誤");
			
		}
		
}
