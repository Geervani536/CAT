package com.CAT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.CAT.Model.Account;


public interface AccountRepository extends JpaRepository<Account, Integer> {
	
}