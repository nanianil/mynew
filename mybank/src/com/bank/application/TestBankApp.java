package com.bank.application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bank.domain.Account;
import com.bank.domain.AccountType;
import com.bank.domain.Address;
import com.bank.domain.Customer;
import com.bank.domain.Transfer;
import com.bank.repository.DataRepository;
import com.bank.service.impl.AccountServiceImpl;
import com.bank.service.impl.TransferServiceImpl;


public class TestBankApp {
	
	
	public static void  main(String[] args) throws SQLException{
		
		/*TransferServiceImpl transferServiceImpl = new TransferServiceImpl();
		Transfer transfer = new Transfer();
		transfer.setDescription("Powerbill");
		transfer.setFromAccount("20000000011");
		transfer.setToAccount("20000000010");
		transfer.setAmount(50000.00);
		
		transferServiceImpl.fundsTransfer(transfer);*/
		
		/*AccountServiceImpl accountServiceImpl = new AccountServiceImpl();
		accountServiceImpl.deposit(new Account("20000000012",AccountType.SAVINGS, 9999999.00));
		accountServiceImpl.withdrawl(new Account("20000000011",AccountType.SAVINGS, 88888.00));
		
		
		Map<Integer,Customer> customerMap =null;		
		DataRepository dataRepo = new DataRepository();
		customerMap = dataRepo.getCustomers();
		
		
		customerMap.get(dataRepo);
		customerMap.forEach((name,customer)->{
			
			
			System.out.print("CustomerNumber :"+customer.getCustomerNumber());
			System.out.print(", CustomerName : " +customer.getName());
			System.out.print(", PhoneNo :" +customer.getPhone());
			System.out.print(", MailId :" +customer.getMail());
			
			Address address = customer.getAddress();			
			System.out.print(",   Address1 :" +address.getAddress1());
			System.out.print(", Address2 :" +address.getAddress2());
			System.out.print(", City :" +address.getCity());
			System.out.print(", State :" +address.getState());
			System.out.print(", Pin :" +address.getPin()+"\n");
		});
		 Map<Integer,Customer> sortedMap =
				 customerMap.entrySet().stream().sorted()
	                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
	                                (customerNumber,customer) -> customer, LinkedHashMap::new));
	        System.out.println("Sorted Map: " + Arrays.toString(sortedMap.entrySet().toArray()));*/
		
		DataRepository dataRepo = new DataRepository();

		List<Customer> customerList = dataRepo.getCustomers();
		customerList.forEach((customer) ->{
			
			System.out.print("CustomerId :"+customer.getCustomerNumber());
			System.out.print(", CustomerName : " +customer.getName());
			System.out.print(", PhoneNo :" +customer.getPhone());
			System.out.print(", MailId :" +customer.getMail());
			
			Address address = customer.getAddress();
			
			System.out.print(",   Address1 :" +address.getAddress1());
			System.out.print(", Address2 :" +address.getAddress2());
			System.out.print(", City :" +address.getCity());
			System.out.print(", State :" +address.getState());
			System.out.print(", Pin :" +address.getPin());
			System.out.println();
			System.out.println();

});
		
	}
}

