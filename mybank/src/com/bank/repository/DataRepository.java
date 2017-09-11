package com.bank.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.bank.domain.Account;
import com.bank.domain.AccountType;
import com.bank.domain.Address;
import com.bank.domain.Customer;
import com.bank.domain.Transfer;

public class DataRepository {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/mybank";
	// Database credentials
	static final String USER = "root";
	static final String PASS = "root";

	String customerSql = "SELECT c.customerNumber, c.name, c.phone, c.mail, a.address1, a.address2, a.city, a.state, a.pin FROM customer c"
			+ " JOIN address a ON a.customerNumber = c.customerNumber ";

	String getAccountSql = "SELECT * FROM ACCOUNT WHERE accountNumber=";
	String updateAccountSql = "UPDATE ACCOUNT SET";
	String transferSql = "INSERT INTO TRANSFER ( description, fromaccount, toaccount, amount) ";

	public Connection getConnection() {
		Connection conn = null;

		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			System.out.println();
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		}

		return conn;

	}

	public List<Customer> getCustomers() throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(customerSql);

		List<Customer> customerList =new ArrayList<>();
		//Map<Integer, Customer> customerMap = new LinkedHashMap<Integer, Customer>();
		try {
			while(rs.next()) {

				Customer customer = new Customer();
				Integer customerNumber = rs.getInt("customerNumber");
				customer.setCustomerNumber(customerNumber.intValue());
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setMail(rs.getString("mail"));

				Address address = new Address();
				address.setAddress1(rs.getString("address1"));
				address.setAddress2(rs.getString("address2"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setPin(rs.getString("pin"));

				customer.setAddress(address);
			//	customerMap.put(customerNumber.intValue(), customer);

				 customerList.add(customer);
			}

			// Collections.sort(customerList);
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
	//	return customerMap;
		//return null;
		return customerList;
		//return null;
	}

	public Account getAccount(String accountNumber) throws SQLException {

		Account account = new Account();

		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(getAccountSql + accountNumber);
		System.out.println("getAccoutQuery----->" + getAccountSql + accountNumber);

		try {
			if (rs.next()) {
				account.setAccountNumber(rs.getString(1));
				String accountType = rs.getString(2);
				if (accountType.equals("current")) {
					account.setAccuntType(AccountType.CURRENT);
				} else {
					account.setAccuntType(AccountType.SAVINGS);
				}
				account.setAmount(rs.getDouble(3));
			}
		} finally {
			rs.close();
			stmt.close();
			conn.close();
		}
		return account;

	}

	public void updateAccount(Account account) throws SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		try {
			@SuppressWarnings("unused")
			int count = stmt.executeUpdate(updateAccountSql + " Amount=" + account.getAmount() + " WHERE AccountNumber="
					+ account.getAccountNumber());

		} finally {
			stmt.close();
			conn.close();
		}
	}

	public Transfer getTransfer(Transfer transfer) throws SQLException {

		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		try {
			String queryString = transferSql + "VALUES ('" + transfer.getDescription() + "','" + transfer.getFromAccount()
					+ "','" + transfer.getToAccount() + "'," + transfer.getAmount()+")";
			System.out.println("QuryString ----->" + queryString);
			@SuppressWarnings("unused")
			
			boolean rs = stmt.execute(queryString);

		} finally {

			stmt.close();
			conn.close();
		}
		return transfer;
	}
	
	

}
