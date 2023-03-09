package com.wanderlust.wanderlust.controller.payment.account;

import com.wanderlust.wanderlust.external.payment.asas.account.PaymentAccountService;
import com.wanderlust.wanderlust.external.payment.asas.account.model.PaymentAccount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("api/pagamento/conta")
@Tag(name = "Pagamento da conta")
public class PaymentAccountController {

    @Autowired
    private PaymentAccountService paymentAccountService;

    @PostMapping("/create")
    @Operation(summary = "Cria pagamento em conta")
    public ResponseEntity<String> GeneratePixKey(@RequestBody @Valid PaymentAccount paymentAccount) throws JSONException {
        return paymentAccountService.paymentAccount(paymentAccount);
    }

    @PostMapping("/cancel/{paymentAccountId}")
    @Operation(summary = "Cancelamento de pagamento em conta")
    public ResponseEntity<String> cancelationPaymentAccount(@PathVariable @NotNull @NotBlank String paymentAccountId) throws JSONException {
        return paymentAccountService.cancelationPaymentAccount(paymentAccountId);
    }

}
