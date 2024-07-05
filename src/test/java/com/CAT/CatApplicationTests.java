/*
 * package com.CAT;
 * 
 * import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Test; import org.mockito.InjectMocks; import
 * org.mockito.Mock; import org.mockito.MockitoAnnotations; import
 * org.springframework.boot.test.context.SpringBootTest;
 * 
 * import com.CAT.Model.Account; import com.CAT.Repository.AccountRepository;
 * import com.CAT.Repository.CustomerRepository; import
 * com.CAT.Service.impl.AccountServiceImpl;
 * 
 * @SpringBootTest class AccountServiceTest {
 * 
 * @Mock private AccountRepository accountRepository;
 * 
 * @Mock private CustomerRepository customerRepository;
 * 
 * @InjectMocks private AccountServiceImpl accountService;
 * 
 * public AccountServiceTest() { MockitoAnnotations.openMocks(this); }
 * 
 * @Test void testAddAccount() { Account account = new Account();
 * when(accountRepository.save(account)).thenReturn(account); String result =
 * accountService.addAccount(account);
 * assertEquals("Account created successfully", result); }
 * 
 * @Test void testGetAllAccounts() { Account account = new Account();
 * when(accountRepository.findAll()).thenReturn(Arrays.asList(account));
 * List<Account> accounts = accountService.getAllAccounts(); assertEquals(1,
 * accounts.size()); }
 * 
 * @Test void testTransferFunds() { Account fromAccount = new Account();
 * fromAccount.setId(1); fromAccount.setBalance(1000);
 * 
 * Account toAccount = new Account(); toAccount.setId(2);
 * toAccount.setBalance(500);
 * 
 * when(accountRepository.findById(1)).thenReturn(java.util.Optional.of(
 * fromAccount));
 * when(accountRepository.findById(2)).thenReturn(java.util.Optional.of(
 * toAccount));
 * 
 * String result = accountService.transferFunds(1, 2, 200);
 * assertEquals("SUCCESS", result); }
 * 
 * private Object when(Optional<Account> byId) { // TODO Auto-generated method
 * stub return null; } }
 */