package com.wanderlust.wanderlust.controller.sendEmail;

import com.wanderlust.wanderlust.dto.sendEmail.EmailDTO;
import com.wanderlust.wanderlust.service.sendEmail.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
    public EmailDTO sendEmail(@RequestBody @Valid EmailDTO emailDTO,
                              @RequestParam("attachment")List<MultipartFile> attachments) throws MessagingException {
        return emailService.sendEmail(emailDTO, attachments);
    }

}
