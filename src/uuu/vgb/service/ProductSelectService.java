package uuu.vgb.service;

import java.util.List;

import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;

public class ProductSelectService {
	private ProductsSelectDAO dao = new ProductsSelectDAO();
	public List<Product> getAllProducts() throws VGBException{
	 return dao.selectAllProducts();
 }
	
	public Product getProduct(String id) throws VGBException{
	return dao.selectProductsById(id);
	}
	
	public List<Product> getOwner(String ownerId)throws VGBException{
		return dao.searctProductsByOwner(ownerId);
		}
	public List<Product> searchProductsByName(String search)throws VGBException{
		return dao.selectProductsByname(search);
	}
	public List<Product> getUpdown(String updown)throws VGBException{
		return dao.selectProductsUpdown(updown);
		}
	
	public List<Product> getUpOwner(String owner)throws VGBException{
		return dao.selectProductsUpOwner(owner);
		}
	
	public List<Product> getBOX(String Box)throws VGBException{
		return dao.selectProductsBOXUpdown(Box);
		}
	public List<Product> getBUY(String Buy)throws VGBException{
		return dao.selectProductsBUYUpdown(Buy);
		}
	
	public List<Product> getUpBOX(String owner)throws VGBException{
		return dao.searctProductsByOwnerBOXup(owner);
		}
	public List<Product> getdownBOX(String owner)throws VGBException{
		return dao.searctProductsByOwnerBOXdown(owner);
		}
	
	public List<Product> getdownBUY(String owner)throws VGBException{
		return dao.searctProductsByOwnerBUYdown(owner);
		}
	public List<Product> getupBUY(String owner)throws VGBException{
		return dao.searctProductsByOwnerBUYup(owner);
		}
	public List<Product> getlistrating(String Lisyrating)throws VGBException{
		return dao.searctLisyrating(Lisyrating);
		}
}
