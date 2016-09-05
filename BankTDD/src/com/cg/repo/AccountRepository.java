package com.cg.repo;

import com.cg.model.AccountBean;

public interface AccountRepository {

	public abstract boolean saveAccount(AccountBean account);
	public abstract AccountBean searchAccount(int accountNum);
}
