package uuu.vgb.test;

import uuu.vgb.entity.PaymentType;
import uuu.vgb.entity.ShippingType;

public class TestPay {
	public static void main(String[] args) {
	 for(PaymentType pType:PaymentType.values()) {
		 System.out.println(pType.name());
		 System.out.println(pType.getFee());
		 System.out.println(pType.getDescription());
		 System.out.println(pType);
	}

	 System.out.println("...........................................................");
			 for(ShippingType pType2:ShippingType.values()) {
				 System.out.println(pType2.name());
				 System.out.println(pType2.getFee());
				 System.out.println(pType2.getDescription());
				 System.out.println(pType2);
			
	
	
	
	}
	
}
	}
