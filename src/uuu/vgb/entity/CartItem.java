package uuu.vgb.entity;

public class CartItem {
	private Product product;

//		private Color color;
//		private String size="";
//private int quantity;	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		if (product != null) {
			this.product = product;
		} else {
			throw new IllegalArgumentException("產品明細不得為NUll");
		}
	}

	@Override
	public String toString() {
		return "CartItem [買了=" + product + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((product == null) ? 0 : product.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CartItem))
			return false;
		CartItem other = (CartItem) obj;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

}
