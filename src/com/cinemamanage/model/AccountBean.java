package com.cinemamanage.model;

import javax.validation.constraints.NotEmpty;

public class AccountBean {
	
	

	
	private String accountID;
	@NotEmpty(message="name Cannot be Empty")
	private String accountName;
	@NotEmpty(message="email Cannot be Empty")
	private String accountEmail;
	@NotEmpty(message="name Cannot be Empty")
	private String accountPassword;

	@NotEmpty(message="name Cannot be Empty")
	private String confirmPassword;
	
	private String accountStatus;
	private String accountRole;
	
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountEmail() {
		return accountEmail;
	}
	public void setAccountEmail(String accountEmail) {
		this.accountEmail = accountEmail;
	}
	public String getAccountPassword() {
		return accountPassword;
	}
	public void setAccountPassword(String accountPassword) {
		this.accountPassword = accountPassword;
	}
	public String getAccountRole() {
		return accountRole;
	}
	public void setAccountRole(String accountRole) {
		this.accountRole = accountRole;
	}
	public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}
	
	
}
