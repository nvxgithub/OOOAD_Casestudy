package com.ilp.entity;

public class Account {

	private String accountCode;
	private String accountName;
	private double accountBalance;
	private Product product;
	
	public Account(String accountCode, String accountName, double accountBalance, Product product) {
		super();
		this.accountCode = accountCode;
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		this.product = product;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Account [accountCode=" + accountCode + ", accountName=" + accountName + ", accountBalance="
				+ accountBalance + ", product=" + product + "]";
	}
	
	
}
