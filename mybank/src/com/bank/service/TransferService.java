package com.bank.service;

import java.sql.SQLException;

import com.bank.domain.Transfer;

public interface TransferService {	
	public void fundsTransfer(Transfer transfer) throws SQLException;	
}
