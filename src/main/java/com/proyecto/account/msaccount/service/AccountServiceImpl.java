package com.proyecto.account.msaccount.service;

import com.proyecto.account.msaccount.entity.Account;
import com.proyecto.account.msaccount.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService{
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public Flux<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Mono<Account> getAccountByID(Integer idAccount) {
        return accountRepository.findById(idAccount);
    }

    @Override
    public Flux<Account> getAccountByIdCustomer(Integer idCustomer) {
        return accountRepository.findAll()
                .filter(account -> account.getIdCustomer() == idCustomer);
    }

    @Override
    public Mono<Account> saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Mono<Account> updateAccount(Account account) {
        return accountRepository.findById(account.getIdAccount())
                .flatMap(newAccount -> {
                    newAccount.setIdAccount(account.getIdAccount());
                    newAccount.setBalance(account.getBalance());
                    newAccount.setNumberAccount(account.getNumberAccount());
                    newAccount.setIdCustomer(account.getIdCustomer());
                    newAccount.setAccountType(account.getAccountType());
                    return accountRepository.save(newAccount);
                });
    }

    @Override
    public Mono<Account> deleteAccount(Integer idAccount) {
        return accountRepository.findById(idAccount)
                .flatMap(account -> accountRepository.delete(account).then(Mono.just(account)));
    }
}
