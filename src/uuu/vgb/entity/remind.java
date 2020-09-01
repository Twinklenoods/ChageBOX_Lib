package uuu.vgb.entity;

public class remind {

	public int remindId;//流水號
	
	public boolean unLook;//未讀
	
	public String user;//建立者
	
	public String lookTime;//已讀時間
	
	public Customer owner ;//擁有者

	public Customer Q_owner;//QA
	
	public Customer C_owner;//change
	
	
	public Customer getQ_owner() {
		return Q_owner;
	}

	public void setQ_owner(Customer q_owner) {
		Q_owner = q_owner;
	}

	public Customer getC_owner() {
		return C_owner;
	}

	public void setC_owner(Customer c_owner) {
		C_owner = c_owner;
	}

	public Customer getOwner() {
		return owner;
	}

	public void setOwner(Customer owner) {
		this.owner = owner;
	}

	public int getRemindId() {
		return remindId;
	}

	public void setRemindId(int remindId) {
		this.remindId = remindId;
	}

	public boolean isUnLook() {
		return unLook;
	}

	public void setUnLook(boolean unLook) {
		this.unLook = unLook;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getLookTime() {
		return lookTime;
	}

	public void setLookTime(String lookTime) {
		this.lookTime = lookTime;
	}

	@Override
	public String toString() {
		return "remind [remindId=" + remindId + ", unLook=" + unLook + ", user=" + user + ", lookTime=" + lookTime
				+ ", owner=" + owner + ", Q_owner=" + Q_owner + ", C_owner=" + C_owner + "]";
	}

	

	
}