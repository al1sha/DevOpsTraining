package com.cg.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.cg.exceptions.InsufficientBalanceException;
import com.cg.exceptions.InvalidAccountNumberException;
import com.cg.model.AccountBean;
import com.cg.repo.AccountRepository;
import com.cg.service.AccountServiceImpl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
public class AccountTest {
	
	
	
	@Mock
	AccountRepository accRepo;
	
	AccountServiceImpl accSer;

	@Before
	public void setUp() throws Exception {
		
		MockitoAnnotations.initMocks(this);
		accSer =  new AccountServiceImpl(accRepo);
	}

	@Test(expected=com.cg.exceptions.InsufficientBalanceException.class)
	public void testCreateAccN() throws InsufficientBalanceException {
		
		accSer.createAccount(101, 200);
	}
	
	@Test
	public void testCreateAccP() throws InsufficientBalanceException {
		
		AccountBean acc =  new AccountBean(102, 6000);
		
		when(accRepo.saveAccount(acc)).thenReturn(true);
		assertEquals(acc, accSer.createAccount(102, 6000));
	}
	
	
	@Test(expected=com.cg.exceptions.InvalidAccountNumberException.class)
	public void testDepositN() throws InvalidAccountNumberException {
		
		AccountBean acc =  new AccountBean(103, 6000);
		when(accRepo.searchAccount(103)).thenThrow(new InvalidAccountNumberException());
		assertEquals(acc, accSer.deposit(103, 6000));

	}
	
	/*@Test
	public void testDepositP() throws InvalidAccountNumberException {
		AccountBean acc =  new AccountBean(103, 6000);
		
		when(accRepo.saveAccount(acc)).thenReturn(true);
		assertEquals(acc, accSer.deposit(103, 6000));

	}*/

}
