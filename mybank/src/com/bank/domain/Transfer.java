package com.bank.domain;

public class Transfer {
	private String transferId;
	private String description;
	private String fromAccount;
	private String toAccount;
	private Double amount;
	
		
	public Transfer(String description, String fromAccount, String toAccount, Double amount) {
		super();
		this.description = description;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amount = amount;
	}
	public Transfer() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the transferId
	 */
	public String getTransferId() {
		return transferId;
	}
	/**
	 * @param transferId the transferId to set
	 */
	public void setTransferId(String transferId) {
		this.transferId = transferId;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the fromAccount
	 */
	public String getFromAccount() {
		return fromAccount;
	}
	/**
	 * @param string the fromAccount to set
	 */
	public void setFromAccount(String string) {
		this.fromAccount = string;
	}
	/**
	 * @return the toAccount
	 */
	public String getToAccount() {
		return toAccount;
	}
	/**
	 * @param transfer the toAccount to set
	 */
	public void setToAccount(String transfer) {
		this.toAccount = transfer;
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
	public void setFromAccount(Transfer transfer) {
		// TODO Auto-generated method stub
		
	}
	
	

}
