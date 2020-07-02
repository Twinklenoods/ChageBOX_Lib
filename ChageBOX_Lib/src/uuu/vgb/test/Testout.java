package uuu.vgb.test;
import  uuu.vgb.entity.Outlet;
class Testout {

	public static void main(String[] args) {
	 Outlet out= new Outlet();
	 out.setId(111);
	 out.setDiscount(0);
	 out.setUnitPrice(500);
	 
	 System.out.println("含手續費:"+out.getUnitPrice());
	 System.out.println("%"+out.getDiscount());
	 System.out.println(out.getDiscount2());
	 System.out.println("id:"+out.getId());
	 System.out.println("原價:"+out.ListUnitPrice());
	
	
	}

}
