package com.wanderlust.wanderlust.external.payment.asas.customer.model;

import lombok.Data;

import java.util.Date;

@Data
public class CustomerResponse {

    private String object;
    private String id;
    private Date dateCreated;
    private String name;
    private String email;
    private String company;
    private String phone;
    private String mobilePhone;
    private String address;
    private String addressNumber;
    private String complement;
    private String province;
    private String postalCode;
    private String cpfCnpj;
    private String personType;
    private Boolean deleted;
    private String additionalEmails;
    private String externalReference;
    private Boolean notificationDisabled;
    private String observations;
    private String municipalInscription;
    private String stateInscription;
    private Boolean canDelete;
    private String cannotBeDeletedReason;
    private Boolean canEdit;
    private String cannotEditReason;
    private Boolean foreignCustomer;
    private Long city;
    private String state;
    private String country;

}
