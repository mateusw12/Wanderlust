package com.wanderlust.wanderlust.controller.sendSms;

import com.wanderlust.wanderlust.model.sendSms.SMS;
import com.wanderlust.wanderlust.service.sendSms.SmsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/sms")
@Tag(name = "Envio de SMS")
public class SendSmsController {

    @Autowired
    private SmsService smsService;

    @PostMapping
    @Operation(summary = "Envia sms")
    public ResponseEntity<SMS> sendSMS(@RequestBody @Valid SMS sms) {
        smsService.sendSMS(sms);
        return ResponseEntity.ok().body(sms);
    }

}
