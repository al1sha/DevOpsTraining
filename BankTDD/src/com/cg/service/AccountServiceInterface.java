package com.cg.service;

import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidAccountNumberException;
import com.cg.model.AccountBean;

public interface AccountServiceInterface {

	public abstract AccountBean createAccount(int accNum, int amt)
			throws InsufficientBalanceException;

	public abstract int deposit(int accNum, int amt) throws InvalidAccountNumberException;

	public abstract int withdraw(int accNum, int amt);

}