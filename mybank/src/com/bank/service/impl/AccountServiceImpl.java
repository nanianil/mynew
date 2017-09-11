package com.bank.service.impl;

import java.sql.SQLException;

import com.bank.domain.Account;
import com.bank.repository.DataRepository;
import com.bank.service.AccountService;

//import datarepos.DataRepository;

public class AccountServiceImpl implements AccountService{
	DataRepository dataRepo = new DataRepository();
	public void deposit(Account accountDeposit) throws SQLException {
		// TODO Auto-generated method stub
		Account account = dataRepo.getAccount(accountDeposit.getAccountNumber());
		Double balanceAmount = account.getAmount() + accountDeposit.getAmount();
		account.setAmount(balanceAmount);		
		dataRepo.updateAccount(account);
	}
	
	public void withdrawl(Account accountWithdrawl) throws SQLException {
		// TODO Auto-generated method stub		
		Account account = dataRepo.getAccount(accountWithdrawl.getAccountNumber());
		Double balanceAmount = account.getAmount() - accountWithdrawl.getAmount();
		account.setAmount(balanceAmount);		
		dataRepo.updateAccount(account);	
	}

}