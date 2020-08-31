package uuu.vgb.entity;

public class remind {

	public int remindId;//流水號
	
	public boolean unLook;//未讀
	
	public String user;//建立者
	
	public String lookTime;//已讀時間
	
	public Customer owner ;//擁有者

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
				+ ", owner=" + owner + "]";
	}

	
}