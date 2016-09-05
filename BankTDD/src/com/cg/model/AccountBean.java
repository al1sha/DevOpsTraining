package com.cg.model;

public class AccountBean {

	
	private int accountNumber;
	private int balance;
	
	public AccountBean(int accNo, int bal){
		accountNumber = accNo;
		balance = bal;
	}
	
	
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountNumber;
		result = prime * result + balance;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountBean other = (AccountBean) obj;
		if (accountNumber != other.accountNumber)
			return false;
		if (balance != other.balance)
			return false;
		return true;
	}
	
	
	
	
}
