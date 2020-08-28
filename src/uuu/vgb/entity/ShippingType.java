package uuu.vgb.entity;

public enum ShippingType {
	toCat(100,"黑貓"),
	toNew(100,"新竹貨運"),
	toFace("面交"),
	toStore("超商到店");
	
	
	
	private final double fee;
	private final String description;
	
	private ShippingType(String description) {
		this(0,description);
	}
	private ShippingType(double fee, String description) {
		this.fee = fee;
		this.description = description;
	}
	public double getFee() {
		return fee;
	}
	public String getDescription() {
		return description;
	}
	@Override
	public String toString() {
		
		return description+(fee>0?("-"+fee+"元"):"");
	}
	
	
}
