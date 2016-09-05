package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidAccountNumberException;
import com.cg.model.AccountBean;

public class AccountServiceNew {
	
		List<AccountBean> accList;
		
		public AccountServiceNew(){
			accList = new ArrayList<AccountBean>();
		}
		
	
		// create: check if account number already exist--> exception
		public String createAccount(int accNum, int amt){
			
			if(accList.size()==0){
				AccountBean acc =  new AccountBean(accNum, amt);
				accList.add(acc);
				return "Account created succesfully";
			}
			
			for (AccountBean al : accList) {
				if(al.getAccountNumber()!=accNum)
				{	
					AccountBean acc =  new AccountBean(accNum, amt);
					accList.add(acc);
					
					return "Account created succesfully";
				}
			}
			return "Account already exits";
			
		}
		
		//deposit: check if accNum exist--> exception AND deposit
		public String deposit(int accNum, int depositAmt) throws InvalidAccountNumberException{
			
			for (AccountBean al : accList) {
				if(al.getAccountNumber()==accNum)
				{	
					System.out.println("**al.getAccountNumber()..." + al.getAccountNumber());
					al.setBalance(al.getBalance()+depositAmt);
					return "Amount deposited. New Balance is:  " + al.getBalance();
				}
			}
			throw new InvalidAccountNumberException();
			
		}

		// withdraw: check if accNum exist--> exception AND check if withdrawAmt is less than balance--> exception
		public String withdraw(int accNum, int withdrawAmt) throws InsufficientBalanceException, InvalidAccountNumberException{
			
			for (AccountBean al : accList) {
				if(al.getAccountNumber()==accNum && (al.getBalance()>=withdrawAmt))
				{	
					al.setBalance(al.getBalance()-withdrawAmt);
					return "Amount deducted. New Balance is:  " + al.getBalance();
				}
				if(al.getBalance()<withdrawAmt){
					//return "Insufficient Balance";
					throw new InsufficientBalanceException();
				}
				
			}
			
			throw new InvalidAccountNumberException();
		}

		public String showBalance(int accNum) throws InvalidAccountNumberException{
			for (AccountBean al : accList) {
				if(al.getAccountNumber()==accNum)
				{
					return "Your Balance is:  " +al.getBalance();
				}
			}
			throw new InvalidAccountNumberException();
		}

}
