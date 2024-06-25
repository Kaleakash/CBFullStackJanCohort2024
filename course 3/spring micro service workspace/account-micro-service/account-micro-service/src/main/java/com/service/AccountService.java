package com.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Account;
import com.repository.AccountRepository;

@Service
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public String createAccount(Account account) {
		Optional<Account> result = accountRepository.findById(account.getAccno());
		if(result.isPresent()) {
			return "Account already exists";
		}else {
			accountRepository.save(account);
			return "Account created successfully";
		}
	}
	
	public String findAccount(int accno) {
		Optional<Account> result = accountRepository.findById(accno);
		if(result.isPresent()) {
			Account acc = result.get();
			return "Your balance is "+acc.getAmount();
		}else {
			return "Account number not exists";
		}
	}
	public int findAccno(String emailid) {
		try {
		return accountRepository.findAccnumberByEmailId(emailid);
		}catch(Exception e) {
			return -1;
		}
	}
}








