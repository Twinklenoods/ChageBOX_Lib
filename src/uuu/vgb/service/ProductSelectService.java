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
	
	public List<Product> getOwner(String owner)throws VGBException{
		return dao.selectProductsByOwner(owner);
		}
	public List<Product> searchProductsByName(String search)throws VGBException{
		return dao.searchProductsByname(search);
	}
	public List<Product> getUpdown(String updown)throws VGBException{
		return dao.selectProductsUpdown(updown);
		}
	
	public List<Product> getUpOwner(String owner)throws VGBException{
		return dao.selectProductsUpOwner(owner);
		}
	
}
