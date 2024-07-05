package com.CAT.Service;

import java.util.List;

import com.CAT.Model.Account;
import com.CAT.Model.Customer;

public interface AccountService {
	String addAccount(Account account);

	List<Account> getAllAccounts();

	List<Customer> getAllCustomers();

	String transferFunds(int fromId, int toId, double amount);

	Account getBalanceOf(int accountNumber);
}