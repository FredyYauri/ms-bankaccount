package com.proyecto.account.msaccount.repository;

import com.proyecto.account.msaccount.entity.Account;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveMongoRepository<Account,Integer> {
}
