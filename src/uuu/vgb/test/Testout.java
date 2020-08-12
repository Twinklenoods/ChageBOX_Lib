package uuu.vgb.test;
import  uuu.vgb.entity.Outlet;
class Testout {

	public static void main(String[] args) {
	 Outlet out= new Outlet();
	 out.setId(1010001);
	 out.setDiscount(4);
	 out.setUnitPrice(600);
	 ;
	 System.out.println("實收價格:"+out.getUnitPrice());
	 //System.out.println("%"+out.getDiscount());
	 //System.out.println(out.getDiscount2());
	// System.out.println("id:"+out.getId());
	 System.out.println("原價:"+out.ListUnitPrice());
	
	 System.out.println("賣方:"+"\t"+out.toString());
	}

}
