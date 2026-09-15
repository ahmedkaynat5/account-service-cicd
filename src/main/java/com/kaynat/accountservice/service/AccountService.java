package com.kaynat.accountservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kaynat.accountservice.model.Account;
import com.kaynat.accountservice.repository.AccountRepository;
import com.kaynat.accountservice.exception.AccountNotFoundException;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }
}