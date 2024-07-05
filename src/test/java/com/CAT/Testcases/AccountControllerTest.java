/*
 * package com.CAT.Testcases;
 * 
 * import com.CAT.Controller.AccountController; import com.CAT.Model.Account;
 * import com.CAT.Model.Customer; import com.CAT.Service.AccountService; import
 * org.junit.jupiter.api.Test; import org.mockito.Mockito; import
 * org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import
 * org.springframework.boot.test.mock.mockito.MockBean; import
 * org.springframework.http.MediaType; import
 * org.springframework.test.web.servlet.MockMvc;
 * 
 * import java.util.Arrays; import java.util.List;
 * 
 * import static
 * org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*; import
 * static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 * 
 * @WebMvcTest(AccountController.class) public class AccountControllerTest {
 * 
 * @Autowired private MockMvc mockMvc;
 * 
 * @MockBean private AccountService accountService;
 * 
 * @Test void testAddAccount() throws Exception { Account account = new
 * Account(); account.setAccountId(123); account.setBalance(1000);
 * 
 * Mockito.when(accountService.addAccount(Mockito.any(Account.class))).
 * thenReturn("Account created");
 * 
 * mockMvc.perform(post("/accounts") .contentType(MediaType.APPLICATION_JSON)
 * .content("{\"accountNumber\": 123, \"balance\": 1000}"))
 * .andExpect(status().isOk()) .andExpect(content().string("Account created"));
 * }
 * 
 * @Test void testGetAllAccounts() throws Exception { Account account1 = new
 * Account(); account1.setAccountId(123); account1.setBalance(1000);
 * 
 * Account account2 = new Account(); account2.setAccountId(456);
 * account2.setBalance(2000);
 * 
 * List<Account> accounts = Arrays.asList(account1, account2);
 * 
 * Mockito.when(accountService.getAllAccounts()).thenReturn(accounts);
 * 
 * mockMvc.perform(get("/accounts")) .andExpect(status().isOk())
 * .andExpect(jsonPath("$[0].accountNumber").value(123))
 * .andExpect(jsonPath("$[0].balance").value(1000))
 * .andExpect(jsonPath("$[1].accountNumber").value(456))
 * .andExpect(jsonPath("$[1].balance").value(2000)); }
 * 
 * @Test void testGetAllCustomers() throws Exception { Customer customer1 = new
 * Customer(); customer1.setCustId(1); customer1.setName("John");
 * 
 * Customer customer2 = new Customer(); customer2.setCustId(2);
 * customer2.setName("Jane");
 * 
 * List<Customer> customers = Arrays.asList(customer1, customer2);
 * 
 * Mockito.when(accountService.getAllCustomers()).thenReturn(customers);
 * 
 * mockMvc.perform(get("/accounts/customers")) .andExpect(status().isOk())
 * .andExpect(jsonPath("$[0].customerId").value(1))
 * .andExpect(jsonPath("$[0].name").value("John"))
 * .andExpect(jsonPath("$[1].customerId").value(2))
 * .andExpect(jsonPath("$[1].name").value("Jane")); }
 * 
 * @Test void testTransferFunds() throws Exception {
 * Mockito.when(accountService.transferFunds(123, 456,
 * 100.0)).thenReturn("Transfer successful");
 * 
 * mockMvc.perform(post("/accounts/transfer") .param("fromId", "123")
 * .param("toId", "456") .param("balance", "100.0")) .andExpect(status().isOk())
 * .andExpect(content().string("Transfer successful")); }
 * 
 * @Test void testGetBalanceOf() throws Exception { Account account = new
 * Account(); account.setAccountId(123); account.setBalance(1000);
 * 
 * Mockito.when(accountService.getBalanceOf(123)).thenReturn(account);
 * 
 * mockMvc.perform(get("/accounts/123/balance")) .andExpect(status().isOk())
 * .andExpect(jsonPath("$.accountNumber").value(123))
 * .andExpect(jsonPath("$.balance").value(1000)); } }
 */