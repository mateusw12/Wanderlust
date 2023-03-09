package com.wanderlust.wanderlust.controller.payment.bankChargers;

import com.wanderlust.wanderlust.external.payment.asas.bankChargers.BankChargersService;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger.BankCharger;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.charger.response.BankChargerResponse;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.chargerInstallments.ChargerInstallments;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.chargerInstallments.response.ChargerInstallmentsResponse;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.creditCard.BankChargerCreditCard;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.qrCoreCharge.QRCodeCharger;
import com.wanderlust.wanderlust.external.payment.asas.bankChargers.model.reverseCharge.ReverseCharge;
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
@RequestMapping("api/pagamento-cobranca")
@Tag(name = "Pagamento de cobranças")
public class BankChargerController {

    @Autowired
    private BankChargersService bankChargersService;

    @PostMapping("/create-charger")
    @Operation(summary = "Cria cobrança")
    public ResponseEntity<BankChargerResponse> createCharger(@RequestBody @Valid BankCharger bankCharger) throws JSONException {
        return bankChargersService.createCharger(bankCharger);
    }

    @PostMapping("/create-charger-credit")
    @Operation(summary = "Cria cobrança de cartão de crédito")
    public ResponseEntity<String> createCreditCardCharger(@RequestBody @Valid BankChargerCreditCard bankChargerCreditCard) throws JSONException {
        return bankChargersService.createCreditCardCharger(bankChargerCreditCard);
    }

    @PostMapping("/create-charger-installment")
    @Operation(summary = "Cria cobrança parcelada")
    public ResponseEntity<ChargerInstallmentsResponse> createChargerInstallments(@RequestBody @Valid ChargerInstallments chargerInstallments) throws JSONException {
        return bankChargersService.createChargerInstallments(chargerInstallments);
    }

    @PostMapping("/reverse-charger/{chargerId}")
    @Operation(summary = "Estorna cobrança")
    public ResponseEntity<String> reverseCharge(@RequestBody @Valid ReverseCharge reverseCharge,
                                                @PathVariable @NotBlank @NotNull String chargerId) {
        return bankChargersService.reverseCharge(reverseCharge, chargerId);
    }

    @GetMapping("/find-qrCode/{chargerId}")
    @Operation(summary = "Consulta QR Code da cobrança")
    public ResponseEntity<QRCodeCharger> findQrdCodeCharger(@PathVariable @NotBlank @NotNull String chargerId) {
        return bankChargersService.findQrdCodeCharger(chargerId);
    }

    @DeleteMapping("/remove-charger/{chargerId}")
    @Operation(summary = "Remove cobrança")
    public ResponseEntity<String> removeCharger(@PathVariable @NotBlank @NotNull String chargerId) {
        return bankChargersService.removeCharger(chargerId);
    }

}
