package uuu.vgb.test;
import  uuu.vgb.entity.Outlet;
class Testout {

	public static void main(String[] args) {
	 Outlet out= new Outlet();
	 out.setId(1);
	 out.setDiscount(200);
	 out.setUnitPrice(500);
	 
	 System.out.println("打折後"+out.getUnitPrice());
	 System.out.println(out.getDiscount());
	 System.out.println(out.getDiscount2());
	 System.out.println(out.getId());
	 System.out.println("原價"+out.ListUnitPrice());
	
	
	}

}
