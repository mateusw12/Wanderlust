package com.wanderlust.wanderlust.service.sendEmail;

import com.wanderlust.wanderlust.model.sendEmail.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(Email email, List<MultipartFile> attachments) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(email.getRecipient());
        helper.setSubject(email.getSubject());
        helper.setText(email.getBody(), true);

        if(attachments.size() != 0) {
            for (MultipartFile attachment : attachments) {
                byte[] bytes = new byte[0];
                try {
                    bytes = attachment.getBytes();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                ByteArrayResource byteArrayResource = new ByteArrayResource(bytes);
                helper.addAttachment(attachment.getOriginalFilename(), byteArrayResource);
            }
        }

        mailSender.send(mimeMessage);
    }

}
