package org.cap.model;

public class Account {

	private int accountNo;
	private Customer customer;
	private double openingBalance;
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public double getOpeningBalance() {
		return openingBalance;
	}
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public Account(int accountNo, Customer customer, double openingBalance) {
		super();
		this.accountNo = accountNo;
		this.customer = customer;
		this.openingBalance = openingBalance;
	}

	public Account()
	{
		super();
	}
	
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", customer=" + customer + ", openingBalance=" + openingBalance
				+ "]";
	}
	
	
	
	
}
