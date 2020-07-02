package uuu.vgb.entity;

public class Product {
	private int id;//Pkey,AUTO_INCREMENT(surrogste key)
	private String name="";//可重複品項名稱,required
	private double unitPrice;//單價,required
	private int stock;//庫存
	private String description="";//描述
	private String photoUrl;//照片
	private String origin="";//面交地點,required
	private char host;//主機,P-PS4,S-Switch,required
	private boolean unsold;//未出售(是否出售)
	//public int status = 1; //0:新產品, 1:已上架, -1:已停售，這個屬性目前用不到
	public Product(){}
	
	public Product(int id, String name, double unitPrice) {
	super();
	this.id = id;
	this.name = name;
	this.unitPrice = unitPrice;
}
	
	
	
	public int getId() {
		return id;

	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		//if(name!=null&&name.length()>0) 
		//{
		this.name = name;
	//}else{System.out.println("需要產品名稱");
	//	}
			}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public char getHost() {
		return host;
	}
	public void setHost(char host) {
		if(host!=0&&host=='P'||host=='S') {
			this.host = host;}
	else {
		System.out.println("請選擇主機類別(P-PS4,S-Switch)");
	}
		}
	public boolean isUnsold() {
		return unsold;
	}
	public void setUnsold(boolean unsold) {
		
		
		this.unsold = unsold;
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName()
				+"{"+"id=" + id +"\n"
				+ "品項名稱=" + name+"\n" 
				+ "定價=" + unitPrice +"\n"
				+"庫存=" + stock+"\n"
				+ "描述=" + description +"\n"
				+ "photoUrl=" + photoUrl +"\n"
				+"地點=" + origin+"\n"
				+ "主機=" + host+"\n"
				+  (unsold?"出售":"未出售") +"}";
	}
	
	
	
}


