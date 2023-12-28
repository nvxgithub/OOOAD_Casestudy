package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {

	private double checkDepositRate;

	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList,
			double checkDepositRate) {
		super(productCode, productName, serviceList);
		this.checkDepositRate = 0.3;
	}

	public double getCheckDepositRate() {
		return checkDepositRate;
	}

	public void setCheckDepositRate(double checkDepositRate) {
		this.checkDepositRate = checkDepositRate;
	}
	
	
}
