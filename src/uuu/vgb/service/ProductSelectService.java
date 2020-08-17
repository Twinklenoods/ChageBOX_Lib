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
	
}
