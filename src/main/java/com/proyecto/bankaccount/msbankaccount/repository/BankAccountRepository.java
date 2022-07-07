package com.proyecto.bankaccount.msbankaccount.repository;

import com.proyecto.bankaccount.msbankaccount.entity.BankAccount;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankAccountRepository extends ReactiveMongoRepository<BankAccount,Integer> {
}
