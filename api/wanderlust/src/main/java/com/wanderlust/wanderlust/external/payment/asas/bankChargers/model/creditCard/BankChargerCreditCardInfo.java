package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.creditCard;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class BankChargerCreditCardInfo {

    @NotNull
    @NotBlank
    private String name;

    private String email;

    @NotNull
    @NotBlank
    private String cpfCnpj;

    private String postalCode;

    private String addressNumber;

    private String addressComplement;

    private String phone;

    private String mobilePhone;

}
