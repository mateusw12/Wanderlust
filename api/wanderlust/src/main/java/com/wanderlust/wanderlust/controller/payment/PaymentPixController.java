package com.wanderlust.wanderlust.controller.payment;

import com.wanderlust.wanderlust.external.payment.asas.AsasPaymentPixService;
import com.wanderlust.wanderlust.external.payment.asas.model.pix.dataPix.Pix;
import com.wanderlust.wanderlust.external.payment.asas.model.pix.generatePix.GeneratePix;
import com.wanderlust.wanderlust.external.payment.asas.model.pix.qrCodeDecode.QRCodeDecode;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Validated
@RestController
@RequestMapping("api/pagamento/pix")
@Tag(name = "Pagamento por pix")
public class PaymentPixController {

    @Autowired
    AsasPaymentPixService asasPaymentPixService;

    @GetMapping("/generate-pix")
    @Operation(summary = "Gera chave")
    public GeneratePix GeneratePixKey() throws JSONException {
        return asasPaymentPixService.GeneratePixKey();
    }

    @GetMapping("/find-key")
    @Operation(summary = "Consulta as chaves")
    public ResponseEntity<Pix> findPixKey() throws JSONException {
        return asasPaymentPixService.findPixKey();
    }

    @GetMapping("/decode/{payLoad}")
    @Operation(summary = "Decodifica um QR Code")
    public ResponseEntity<QRCodeDecode> qrdCodeDecode(@PathVariable @NotNull @NotBlank String payLoad) throws JSONException {
        return asasPaymentPixService.qrdCodeDecode(payLoad);
    }

    @GetMapping("/decode")
    @Operation(summary = "Remove chave pix")
    public ResponseEntity<String> RemovePixKey(@PathVariable @NotNull @NotBlank String pixId) throws JSONException {
        return asasPaymentPixService.RemovePixKey(pixId);
    }

}
