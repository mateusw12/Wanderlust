package com.wanderlust.wanderlust.controller.sendEmail;

import com.wanderlust.wanderlust.model.sendEmail.Email;
import com.wanderlust.wanderlust.service.sendEmail.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/envio-email")
public class SendEmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    public ResponseEntity<Email> sendEmail(@RequestBody Email email) throws MessagingException {
        emailService.sendEmail(email);
        return ResponseEntity.ok().build();
    }

}
