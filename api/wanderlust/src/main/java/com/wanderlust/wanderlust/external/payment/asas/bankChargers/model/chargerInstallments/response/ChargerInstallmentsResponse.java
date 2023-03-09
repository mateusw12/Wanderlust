package com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.chargerInstallments.response;

import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger.response.BankChargerResponseDiscount;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger.response.BankChargerResponseFine;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger.response.BankChargerResponseInterest;
import lombok.Data;

import java.util.Date;

@Data
public class ChargerInstallmentsResponse {

    private String object;
    private String id;
    private Date dateCreated;
    private String customer;
    private String installment;
    private String paymentLink;
    private Double value;
    private Double netValue;
    private Double originalValue;
    private Double interestValue;
    private String description;
    private String billingType;
    private Boolean canBePaidAfterDueDate;
    private String pixTransaction;
    private String status;
    private Date dueDate;
    private Date originalDueDate;
    private Date paymentDate;
    private Date clientPaymentDate;
    private Long installmentNumber;
    private String invoiceUrl;
    private String invoiceNumber;
    private String externalReference;
    private Boolean deleted;
    private Boolean anticipated;
    private Boolean anticipable;
    private Date creditDate;
    private Date estimatedCreditDate;
    private String transactionReceiptUrl;
    private String nossoNumero;
    private String bankSlipUrl;
    private Date lastInvoiceViewedDate;
    private Date lastBankSlipViewedDate;
    private BankChargerResponseDiscount discount;
    private BankChargerResponseFine fine;
    private BankChargerResponseInterest interest;
    private Boolean postalService;

}
