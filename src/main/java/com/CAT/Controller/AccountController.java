package com.CAT.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.CAT.Model.Account;
import com.CAT.Model.Customer;
import com.CAT.Service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	@Autowired
	private AccountService accountService;

	@PostMapping
	public ResponseEntity<String> addAccount(@RequestBody Account account) {
		return ResponseEntity.ok(accountService.addAccount(account));
	}

	@GetMapping
	public ResponseEntity<List<Account>> getAllAccounts() {
		return ResponseEntity.ok(accountService.getAllAccounts());
	}

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		return ResponseEntity.ok(accountService.getAllCustomers());
	}

	@PostMapping("/transfer")
	public ResponseEntity<String> transferFunds(@RequestParam int fromId, @RequestParam int toId,
			@RequestParam double balance) {
		return ResponseEntity.ok(accountService.transferFunds(fromId, toId, balance));
	}
	/*
	 * @PostMapping("/transfer") public ResponseEntity<String>
	 * transferFunds(@RequestBody TransferRequest transferRequest) { String result =
	 * accountService.transferFunds(transferRequest.getFromAccountId(),
	 * transferRequest.getToAccountId(), transferRequest.getbalance()); return
	 * ResponseEntity.ok(result); }
	 */

	@GetMapping("/{accountNumber}/balance")
	public ResponseEntity<Account> getBalanceOf(@PathVariable int accountNumber) {
		return ResponseEntity.ok(accountService.getBalanceOf(accountNumber));
	}
}