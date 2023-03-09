package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.creditCard;

import lombok.Data;

@Data
public class BankChargerCreditCardInfo {

    private String name;
    private String email;
    private String cpfCnpj;
    private String postalCode;
    private String addressNumber;
    private String addressComplement;
    private String phone;
    private String mobilePhone;

}
