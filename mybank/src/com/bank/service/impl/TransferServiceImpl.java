package com.bank.service.impl;

import java.sql.SQLException;

import com.bank.domain.Account;
import com.bank.domain.Transfer;
import com.bank.repository.DataRepository;
import com.bank.service.TransferService;



public class TransferServiceImpl implements TransferService {
	DataRepository dataRepo = new DataRepository();
	
	@Override
	public void fundsTransfer(Transfer transfer) throws SQLException {
		// TODO Auto-generated method stub
		
		AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
		accountServiceImpl.deposit(new Account(transfer.getFromAccount(), 50000.00));
		accountServiceImpl.withdrawl(new Account(transfer.getToAccount(), 150000.00));
		dataRepo.getTransfer(transfer);
		
	}
	
	
}