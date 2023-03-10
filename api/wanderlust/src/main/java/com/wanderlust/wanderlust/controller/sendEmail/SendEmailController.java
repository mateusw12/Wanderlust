package com.wanderlust.wanderlust.controller.sendEmail;

import com.wanderlust.wanderlust.model.sendEmail.Email;
import com.wanderlust.wanderlust.service.sendEmail.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("api/envio-email")
@Tag(name = "Envio de E-mail")
public class SendEmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping
    @Operation(summary = "Envia email")
    public ResponseEntity<Email> sendEmail(@RequestBody @Valid Email email,
                                           @RequestParam("attachment")List<MultipartFile> attachments) throws MessagingException {
        emailService.sendEmail(email, attachments);
        return ResponseEntity.ok().build();
    }

}
