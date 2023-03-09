package com.wanderlust.wanderlust.external.payment.asas.customer.model;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CustomerCreate {

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Email
    private String email;

    private String phone;

    private String mobilePhone;

    @NotBlank
    @NotNull
    private String cpfCnpj;

    @NotBlank
    @NotNull
    private String postalCode;

    @NotBlank
    @NotNull
    private String address;

    @NotBlank
    @NotNull
    private String addressNumber;

    private String complement;

    @NotBlank
    @NotNull
    private String province;

    private String externalReference;

    private Boolean notificationDisabled;

    private String additionalEmails;

    @NotBlank
    @NotNull
    private String stateInscription;

    @NotBlank
    @NotNull
    private String municipalInscription;

    @NotBlank
    @NotNull
    private String observations;

}
