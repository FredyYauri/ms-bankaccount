package com.proyecto.bankaccount.msbankaccount.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@Getter
@Document(collection = "accounts")
public class BankAccount {
    @Id
    private Integer idAccount;      //id de cuenta
    private String numberAccount;   //número de cuenta
    private Float balance;          //saldo
    private Integer idCustomer;     //id de cliente
    private String accountType;     //tipo de cuenta
}
