package uuu.vgb.entity;

public class Product {
	public int id;//Pkey,AUTO_INCREMENT(surrogste key)
	public String name="";//可重複品項名稱,required
	public double unitPrice;//單價,required
	public int stock;//庫存
	public String description="";//描述
	public String photoUrl;//照片
	public String origin="";//面交地點,required
	public String host="";//主機,required
	public boolean unsold;//未出售(是否出售)
	//public int status = 1; //0:新產品, 1:已上架, -1:已停售，這個屬性目前用不到
}
