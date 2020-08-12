package uuu.vgb.test;

import uuu.vgb.entity.Outlet;

class TestVIP {

	public static void main(String[] args) {
		VIP vip=new VIP();
		vip.setId("A0123456789");
		vip.setName("張大頭");
		vip.setDiscount(0);
		
		System.out.println(vip.getDiscount2());
		System.out.println(vip.getName());
		System.out.println("id:"+vip.getId());
		Outlet out= new Outlet();
		 out.setId(1);
		 System.out.println(out.getId());
		}
		
		
	}


