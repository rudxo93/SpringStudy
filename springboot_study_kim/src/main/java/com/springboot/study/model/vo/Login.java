package com.springboot.study.model.vo;

public class Login {
	
	private String loginid;
	private String loginpassword;
	private int loginFlag;
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getLoginpassword() {
		return loginpassword;
	}
	public void setLoginpassword(String loginpassword) {
		this.loginpassword = loginpassword;
	}
	
	public int getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(int loginFlag) {
		this.loginFlag = loginFlag;
	}
	
	@Override
	public String toString() {
		return "Login [loginid=" + loginid + ", loginpassword=" + loginpassword + ", loginFlag=" + loginFlag + "]";
	}

}
