package com.wanderlust.wanderlust.controller.sendEmail;

import com.wanderlust.wanderlust.model.sendEmail.Email;
import com.wanderlust.wanderlust.service.sendEmail.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.validation.Valid;

@Validated
@RestController
@RequestMapping("api/envio-email")
@Tag(name = "Controle de envio de E-mail")
public class SendEmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    @Operation(summary = "Envia email")
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid Email email) throws MessagingException {
        emailService.sendEmail(email);
        return ResponseEntity.ok().build();
    }

}
