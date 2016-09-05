package com.cg.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidAccountNumberException;
import com.cg.service.AccountServiceNew;

public class AccountMain {

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		AccountServiceNew accSer =  new  AccountServiceNew();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int choice=0;
		
		do{
			System.out.println("-------Enter your choice-------");
			System.out.println("1. Create Account \n2. Withdraw Amount \n3. Deposit \n4. Show Balance");
			choice = Integer.parseInt(br.readLine());
			int accNum;
			String console;
			switch (choice) {
			case 1:
				System.out.println("Enter the account number");
				accNum = Integer.parseInt(br.readLine());
				System.out.println("Enter the initial amount");
				int initalAmt = Integer.parseInt(br.readLine());
				console = accSer.createAccount(accNum, initalAmt);
				System.out.println(console);
				break;
	
			case 2:
				System.out.println("Enter the account number");
				accNum = Integer.parseInt(br.readLine());
				System.out.println("Enter the withdrawal amount");
				int withdrawAmt = Integer.parseInt(br.readLine());
				try {
					console = accSer.withdraw(accNum, withdrawAmt);
					System.out.println(console);
				} catch (InsufficientBalanceException e) {} catch (InvalidAccountNumberException e) {}
				
				break;
				
			case 3:
				System.out.println("Enter the account number");
				accNum = Integer.parseInt(br.readLine());
				System.out.println("Enter the deposit amount");
				int depositAmt = Integer.parseInt(br.readLine());
				try {
					console = accSer.deposit(accNum, depositAmt);
					System.out.println(console);
				} catch (InvalidAccountNumberException e) {}
				
				break;
				
			case 4:
				System.out.println("Enter the account number");
				accNum = Integer.parseInt(br.readLine());
				System.out.println("Enter the deposit amount");
				try {
					console = accSer.showBalance(accNum);
					System.out.println(console);
				} catch (InvalidAccountNumberException e) {}
				
				break;
				
			default:
				System.out.println("Wrong option. Bye");
				break;
			}
		}while(choice<5);
		
	}

}
