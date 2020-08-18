package uuu.vgb.test;
import uuu.vgb.entity.Product;
import uuu.vgb.entity.VGBException;
import uuu.vgb.service.ProductService;


public class testProductsInter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProductService service =new ProductService();
		try {
			Product c = new Product();	
				
				c.setName("寶可夢'劍'");
				
				
				c.setOwner("A129067964");
				c.setUnitPrice(1000);
				c.setDescription("這是敘述");
				c.setWantChange("想交換的物品");
				c.setOwnerN("va");
				
				c.setHost("ps4");
				c.setChangebox("");
				c.setBuy("yes");
				c.setOrigin("台南市");
				c.setPhotoUrl("照片");
				
				service.register(c);;
				}catch(VGBException e) {
					 e.printStackTrace();	
					}catch(Exception e) {
				e.printStackTrace();
					}
						System.out.println("Bye");
			}

}
