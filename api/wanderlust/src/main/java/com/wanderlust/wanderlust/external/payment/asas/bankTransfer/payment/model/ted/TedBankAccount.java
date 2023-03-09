package com.wanderlust.wanderlust.external.payment.asas.bankTransfer.payment.model.ted;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class TedBankAccount {

    @NotNull
    private TedBankType bank;

    @NotNull
    @NotBlank
    private String accountName;

    @NotNull
    @NotBlank
    private String ownerName;

    @NotNull
    @NotBlank
    private String ownerBirthDate;

    @NotNull
    @NotBlank
    @CPF
    private String cpfCnpj;

    @NotNull
    @NotBlank
    private String agency;

    @NotNull
    @NotBlank
    private String account;

    @NotNull
    @NotBlank
    private String bankAccountType;

}
