package com.wanderlust.wanderlust.controller.payment.bankTransfer;

import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.payment.AsaasPaymentBankTransferService;
import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.payment.model.asaasTransferAccount.AsaasTransferAccount;
import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.payment.model.pixSchedule.PixScheduleTransfer;
import com.wanderlust.wanderlust.external.payment.asas.bankTransfer.payment.model.ted.TedBankTransfer;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("api/pagamento/transferencia")
@Tag(name = "Pagamento por transferencia")
public class PaymentBankTransferController {

    @Autowired
    private AsaasPaymentBankTransferService asaasPaymentBankTransferService;

    @PostMapping("/ted")
    @Operation(summary = "Transferencia bancária via TED")
    public ResponseEntity<String> tedBankTransfer(@RequestBody @Valid TedBankTransfer tedBankTransfer) throws JSONException {
        return asaasPaymentBankTransferService.tedBankTransfer(tedBankTransfer);
    }

    @PostMapping("/pix-manual")
    @Operation(summary = "Transferencia bancária via PIX manual")
    public ResponseEntity<String> manualPixBankTransfer(@RequestBody @Valid TedBankTransfer tedBankTransfer) throws JSONException {
        return asaasPaymentBankTransferService.manualPixBankTransfer(tedBankTransfer);
    }

    @PostMapping("/pix-manual-agendado")
    @Operation(summary = "Transferencia bancária via PIX manual agendado")
    public ResponseEntity<String> manualPixScheduleBankTransfer(@RequestBody @Valid PixScheduleTransfer pixScheduleTransfer) throws JSONException {
        return asaasPaymentBankTransferService.manualPixScheduleBankTransfer(pixScheduleTransfer);
    }

    @PostMapping("/conta")
    @Operation(summary = "Transferencia bancária para conta")
    public ResponseEntity<String> asaasTransferAccount(@RequestBody @Valid AsaasTransferAccount asaasTransferAccount) throws JSONException {
        return asaasPaymentBankTransferService.asaasTransferAccount(asaasTransferAccount);
    }

}
