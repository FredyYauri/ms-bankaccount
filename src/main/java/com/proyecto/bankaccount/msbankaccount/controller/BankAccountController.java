package com.proyecto.bankaccount.msbankaccount.controller;

import com.proyecto.bankaccount.msbankaccount.entity.BankAccount;
import com.proyecto.bankaccount.msbankaccount.service.BankAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@Slf4j
@RequestMapping(value = "/bankaccount")
public class BankAccountController {
    @Autowired
    private BankAccountService bankAccountService;

    /**
     * Obtener todas las cuentas bancarias
     *
     * @return
     */
    @GetMapping
    public Flux<BankAccount> getAll() {
        return bankAccountService.getAll();
    }

    /**
     * Obtener cuenta bancaria por id
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<BankAccount>> getAccountByID(@PathVariable Integer id) {
        return bankAccountService.getAccountByID(id).map(response->ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON)
                 .body(response))
                .defaultIfEmpty(ResponseEntity.badRequest().build());

//        return bankAccountService.getAccountByID(id).map(ResponseEntity::ok)
//                .defaultIfEmpty(ResponseEntity.noContent().build());
    }

    /**
     * Registrar nueva cuenta bancaria
     *
     * @param bankAccount
     * @return
     */
    @PostMapping
    public Mono<BankAccount> saveAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.saveAccount(bankAccount);
    }

    /**
     * Modificar cuenta bancaria
     *
     * @param bankAccount
     * @return
     */
    @PutMapping
    public Mono<BankAccount> updateAccount(@RequestBody BankAccount bankAccount) {
        return bankAccountService.updateAccount(bankAccount);
    }

    /**
     * Eliminar cuenta bancaria
     *
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public Mono<BankAccount> deleteAccount(@PathVariable Integer id) {
        return bankAccountService.deleteAccount(id);
    }

    /**
     * Obtener cuentas bancarias de un determinado cliente
     *
     * @param idConsumer
     * @return
     */
    @GetMapping("/bycustomer/{idConsumer}")
    public Flux<BankAccount> getAccountByIdCustomer(@PathVariable Integer idConsumer) {
        log.info("entra a getAccountByIdCustomer");
        return bankAccountService.getAccountByIdCustomer(idConsumer);
    }

}
