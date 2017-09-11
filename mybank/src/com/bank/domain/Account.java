package com.bank.domain;

public class Account {
	
	private String accountNumber;
	private AccountType accountType;
	private Double amount;
	
	public Account(){}
	
	public Account(String accountNumber, AccountType accountType, Double amount) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.amount = amount;
	}
	
	public Account(String accountNumber, Double amount) {
		super();
		this.accountNumber = accountNumber;
		//this.accountType = accountType;
		this.amount = amount;
	}
	
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the accuntType
	 */
	public AccountType getAccuntType() {
		return accountType;
	}
	/**
	 * @param accuntType the accuntType to set
	 */
	public void setAccuntType(AccountType accuntType) {
		this.accountType = accuntType;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accuntType=" + accountType + ", amount=" + amount + "]";
	}
	
}
