package com.wanderlust.wanderlust.controller.payment.bankTransfer;

import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.AsaasPaymentBankTransferService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/pagamento/transferencia")
@Tag(name = "Pagamento por transferencia")
public class PaymentBankTransferController {

    @Autowired
    private AsaasPaymentBankTransferService asaasPaymentBankTransferService;

}
