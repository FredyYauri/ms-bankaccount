package com.proyecto.bankaccount.msbankaccount.service;

import com.proyecto.bankaccount.msbankaccount.entity.BankAccount;
import com.proyecto.bankaccount.msbankaccount.repository.BankAccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class BankBankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public Flux<BankAccount> getAll() {
        return bankAccountRepository.findAll();
    }

    @Override
    public Mono<BankAccount> getAccountByID(Integer idAccount) {
        return bankAccountRepository.findById(idAccount);
    }

    @Override
    public Mono<BankAccount> saveAccount(BankAccount bankAccount) {
        return bankAccountRepository.save(bankAccount);
    }

    @Override
    public Mono<BankAccount> updateAccount(BankAccount bankAccount) {
        return bankAccountRepository.findById(bankAccount.getIdAccount())
                .flatMap(newBankAccount -> {
                    newBankAccount.setIdAccount(bankAccount.getIdAccount());
                    newBankAccount.setBalance(bankAccount.getBalance());
                    newBankAccount.setNumberAccount(bankAccount.getNumberAccount());
                    newBankAccount.setIdCustomer(bankAccount.getIdCustomer());
                    newBankAccount.setAccountType(bankAccount.getAccountType());
                    return bankAccountRepository.save(newBankAccount);
                });
    }

    @Override
    public Mono<BankAccount> deleteAccount(Integer idAccount) {
        return bankAccountRepository.findById(idAccount)
                .flatMap(bankAccount -> bankAccountRepository.delete(bankAccount).then(Mono.just(bankAccount)));
    }


    @Override
    public Flux<BankAccount> getAccountByIdCustomer(Integer idCustomer) {
        return bankAccountRepository.findAll()
                .filter(bankAccount -> bankAccount.getIdCustomer() == idCustomer);
    }
}
