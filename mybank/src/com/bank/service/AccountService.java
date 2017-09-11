package com.bank.service;

import java.sql.SQLException;

import com.bank.domain.Account;

public interface AccountService {
	public void deposit(Account account) throws SQLException;
	public void withdrawl(Account account) throws SQLException;	
	
}
