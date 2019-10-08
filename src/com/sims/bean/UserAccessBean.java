package com.sims.bean;

public class UserAccessBean {
	 private int useraccess_id;
	 private int designation_id;
	 private boolean canread;
	 private boolean canedit;
	 private boolean cancreate;
	 private boolean candelete;
	public int getUseraccess_id() {
		return useraccess_id;
	}
	public void setUseraccess_id(int useraccess_id) {
		this.useraccess_id = useraccess_id;
	}
	public int getDesignation_id() {
		return designation_id;
	}
	public void setDesignation_id(int designation_id) {
		this.designation_id = designation_id;
	}
	public boolean isCanread() {
		return canread;
	}
	public void setCanread(boolean canread) {
		this.canread = canread;
	}
	public boolean isCanedit() {
		return canedit;
	}
	public void setCanedit(boolean canedit) {
		this.canedit = canedit;
	}
	public boolean isCancreate() {
		return cancreate;
	}
	public void setCancreate(boolean cancreate) {
		this.cancreate = cancreate;
	}
	public boolean isCandelete() {
		return candelete;
	}
	public void setCandelete(boolean candelete) {
		this.candelete = candelete;
	}
	 
	 

}
