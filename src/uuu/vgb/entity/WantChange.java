package uuu.vgb.entity;

public class WantChange {
 
	public int changesID;
	
	public Customer user;
	
	public Product productID;
	
	public int cheack;
	
	public Customer ownerID;

	
	
	public int getCheack() {
		return cheack;
	}

	public void setCheack(int cheack) {
		this.cheack = cheack;
	}

	public Customer getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(Customer ownerID) {
		this.ownerID = ownerID;
	}

	public int getChangesID() {
		return changesID;
	}

	public void setChangesID(int changesID) {
		this.changesID = changesID;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public Product getProductID() {
		return productID;
	}

	public void setProductID(Product productID) {
		this.productID = productID;
	}

	@Override
	public String toString() {
		return "WantChange [changesID=" + changesID + ", user=" + user + ", productID=" + productID + ", cheack="
				+ cheack + ", ownerID=" + ownerID + "]";
	}

	
	
}
