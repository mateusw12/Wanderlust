package com.wanderlust.wanderlust.model.paymentCondition;

public enum PaymentCondition {

    CASHPAYMENT("Pagamento a vista"),
    DEFERREDPAYMENT("Pagamento a prazo"),
    PAYMENTBANKRECEIPT("Boleto"),
    PAYMENTPIX("pix");

    private final String description;

    PaymentCondition(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentCondition getEnumValue(String description) {
        return PaymentCondition.valueOf(description);
    }

}
