package com.cg.exceptions;

public class InvalidAccountNumberException extends Exception {

	public InvalidAccountNumberException(){
		System.out.println("Exception: The Account Number you entered is Invalid");
	}
}
