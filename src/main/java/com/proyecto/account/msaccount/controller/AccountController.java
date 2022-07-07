package com.proyecto.account.msaccount.controller;

import com.proyecto.account.msaccount.entity.Account;
import com.proyecto.account.msaccount.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping(value = "/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @GetMapping
    public Flux<Account> getAll(){
        return accountService.getAll();
    }

    @GetMapping("/{id}")
    public Mono<Account> getAccountByID(@PathVariable Integer id){
        return accountService.getAccountByID(id);
    }

    @PostMapping
    public Mono<Account> saveAccount(@RequestBody Account account){
        return accountService.saveAccount(account);
    }

    @PutMapping
    public Mono<Account> updateAccount(@RequestBody Account account){
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/{id}")
    public Mono<Account> deleteAccount(@PathVariable Integer id){
        return accountService.deleteAccount(id);
    }

    @GetMapping("/bycustomer/{idConsumer}")
    public Flux<Account> getAccountByIdCustomer(@PathVariable Integer idConsumer){
        log.info("entra a getAccountByIdCustomer");
        return accountService.getAccountByIdCustomer(idConsumer);
    }

}
