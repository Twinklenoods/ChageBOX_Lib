package uuu.vgb.entity;

public class OwnerQa {
	
	public int id;
	public Customer ownerId;
	public Customer customerId;
	public String ownerQA;
	public String createTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Customer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Customer ownerId) {
		this.ownerId = ownerId;
	}
	public Customer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}
	public String getOwnerQA() {
		return ownerQA;
	}
	public void setOwnerQA(String ownerQA) {
		this.ownerQA = ownerQA;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "OwnerQa [id=" + id + ", ownerId=" + ownerId + ", customerId=" + customerId + ", ownerQA=" + ownerQA
				+ ", createTime=" + createTime + "]";
	}
	
	
	
	
}
