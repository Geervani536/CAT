package com.CAT.Service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CAT.Model.Account;
import com.CAT.Model.Customer;
import com.CAT.Repository.AccountRepository;
import com.CAT.Repository.CustomerRepository;
import com.CAT.Service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public String addAccount(Account account) {
		// TODO Auto-generated method stub
		accountRepository.save(account);
		return "Account created successfully";

	}

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepository.findAll();
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public String transferFunds(int fromId, int toId, double balance) {
		// TODO Auto-generated method stub
		Optional<Account> fromAccountOpt = accountRepository.findById(fromId);
		Optional<Account> toAccountOpt = accountRepository.findById(toId);

		if (!fromAccountOpt.isPresent() || !toAccountOpt.isPresent()) {
			return "ID MISMATCH";
		}

		Account fromAccount = fromAccountOpt.get();
		Account toAccount = toAccountOpt.get();

		if (fromAccount.getBalance() < balance) {
			return "INSUFFICIENT FUNDS";
		}

		fromAccount.setBalance(fromAccount.getBalance() - balance);
		toAccount.setBalance(toAccount.getBalance() + balance);

		accountRepository.save(fromAccount);
		accountRepository.save(toAccount);

		return "SUCCESS";
	}

	@Override
	public Account getBalanceOf(int accountNumber) {
		// TODO Auto-generated method stub
		return accountRepository.findById(accountNumber).orElse(null);
	}
}
