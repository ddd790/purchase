package com.purchase.entity;

public class User {
	private int USER_CODE;
	private String MAIL_ADDRESS;
	private String USER_NAME;
	private int AUTHORITY_KIND;
	private String PASSWORD;
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String pASSWORD) {
		PASSWORD = pASSWORD;
	}
	public int getUSER_CODE() {
		return USER_CODE;
	}
	public void setUSER_CODE(int uSER_CODE) {
		USER_CODE = uSER_CODE;
	}
	public String getMAIL_ADDRESS() {
		return MAIL_ADDRESS;
	}
	public void setMAIL_ADDRESS(String mAIL_ADDRESS) {
		MAIL_ADDRESS = mAIL_ADDRESS;
	}
	public String getUSER_NAME() {
		return USER_NAME;
	}
	public void setUSER_NAME(String uSER_NAME) {
		USER_NAME = uSER_NAME;
	}
	public int getAUTHORITY_KIND() {
		return AUTHORITY_KIND;
	}
	public void setAUTHORITY_KIND(int aUTHORITY_KIND) {
		AUTHORITY_KIND = aUTHORITY_KIND;
	}
	
}
