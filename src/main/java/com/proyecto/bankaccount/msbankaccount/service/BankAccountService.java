package com.proyecto.bankaccount.msbankaccount.service;

import com.proyecto.bankaccount.msbankaccount.entity.BankAccount;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BankAccountService {
    Flux<BankAccount> getAll();
    Mono<BankAccount> getAccountByID(Integer idAccount);
    Mono<BankAccount> saveAccount(BankAccount bankAccount);
    Mono<BankAccount> updateAccount(BankAccount bankAccount);
    Mono<BankAccount> deleteAccount(Integer idAccount);
    Flux<BankAccount> getAccountByIdCustomer(Integer idCustomer);

}
