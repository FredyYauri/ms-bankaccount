package com.proyecto.account.msaccount.service;

import com.proyecto.account.msaccount.entity.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountService {
    Flux<Account> getAll();
    Mono<Account> getAccountByID(Integer idAccount);
    Mono<Account> saveAccount(Account account);
    Mono<Account> updateAccount(Account account);
    Mono<Account> deleteAccount(Integer idAccount);
    Flux<Account> getAccountByIdCustomer(Integer idCustomer);

}
