package com.cg.exceptions;

public class InsufficientBalanceException  extends Exception{

	public InsufficientBalanceException(){
		System.out.println("Exception: Insufficient Balance in your Account");
	}
}
