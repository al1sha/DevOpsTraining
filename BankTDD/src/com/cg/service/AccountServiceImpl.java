package com.cg.service;

import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidAccountNumberException;
import com.cg.model.AccountBean;
import com.cg.repo.AccountRepository;

public class AccountServiceImpl implements AccountServiceInterface {
	
	AccountRepository accountRepo;
	
	public AccountServiceImpl(AccountRepository accRepo){
		accountRepo = accRepo;
	}

	
	/* (non-Javadoc)
	 * @see com.cg.service.AccountServiceInterface#createAccount(int, int)
	 */
	@Override
	public AccountBean createAccount(int accNum, int amt) throws InsufficientBalanceException{
		
		if(amt<500){
			throw new InsufficientBalanceException();
		}
		
		AccountBean acc =  new AccountBean(accNum, amt);
		accountRepo.saveAccount(acc);
		return acc;
	}
	
	/* (non-Javadoc)
	 * @see com.cg.service.AccountServiceInterface#deposit(int, int)
	 */
	@Override
	public int deposit(int accNum, int amt) throws InvalidAccountNumberException{
		
		AccountBean accNumber = accountRepo.searchAccount(accNum);
		if(accNumber.getAccountNumber() == accNum){
			accNumber.setBalance(accNumber.getBalance()+amt);
		}
		else{
			throw new InvalidAccountNumberException();
			
		}
		return accNumber.getBalance();
		
	}

	/* (non-Javadoc)
	 * @see com.cg.service.AccountServiceInterface#withdraw(int, int)
	 */
	@Override
	public int withdraw(int accNum, int amt){
		
		return 0;
	}

}
