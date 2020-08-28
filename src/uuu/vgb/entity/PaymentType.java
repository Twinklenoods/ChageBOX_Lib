package uuu.vgb.entity;

public enum PaymentType {
	Face("面交",ShippingType.toFace),
	ATM("ATM轉帳",ShippingType.toCat,ShippingType.toNew,ShippingType.toStore),
	Home(60,"到貨付款",ShippingType.toStore),
	Store("超商付款",ShippingType.toStore),
	Card("信用卡付款",ShippingType.toCat,ShippingType.toNew,ShippingType.toStore);
	
	private final double fee;
	private final String description;
	private final ShippingType[] shippingTypeArray;
	
	private PaymentType(String description,
			ShippingType... shippingTypeArray) {
		this(0,description,shippingTypeArray);
	}
	private PaymentType(double fee, String description,ShippingType... shippingTypeArray) {
		this.fee = fee;
		this.description = description;
		this.shippingTypeArray=shippingTypeArray;
	}
	public double getFee() {
		return fee;
	}
	public String getDescription() {
		return description;
	}
	public ShippingType[] getshippingTypeArray() {
		return shippingTypeArray.clone();
	}
	
	@Override
	public String toString() {
		
		return description+(fee>0?("-"+fee+"元"):"");
	}
	
	
}
