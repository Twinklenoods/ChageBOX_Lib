package uuu.vgb.entity;

public class CartItem {
	private Product product; //PKey
	private Color color; //PKey
	private String size = ""; //PKey
	//private int quantity;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		if(product!=null) {
			this.product = product;
		}else {
			throw new IllegalArgumentException("購物明細的產品不得為null");
		}
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {		
		this.color = color;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	@Override
	public String toString() {
		return this.getClass().getName() + "[買了=" + product 
					+ ",\n 購買顏色=" + color + ", 購買尺寸=" + size + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}
	
	
}
