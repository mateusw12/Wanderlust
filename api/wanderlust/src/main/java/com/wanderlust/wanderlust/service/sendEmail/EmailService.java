package com.wanderlust.wanderlust.service.sendEmail;

import com.wanderlust.wanderlust.dto.sendEmail.EmailDTO;
import com.wanderlust.wanderlust.mapper.sendEmail.EmailMapper;
import com.wanderlust.wanderlust.model.sendEmail.EmailModel;
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

    @Autowired
    private EmailMapper emailMapper;

    public EmailDTO sendEmail(EmailDTO emailDTO, List<MultipartFile> attachments) throws MessagingException {
        EmailModel emailModel = emailMapper.toEntity(emailDTO);

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setTo(emailModel.getRecipient());
        helper.setSubject(emailModel.getSubject());
        helper.setText(emailModel.getBody(), true);

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
        return emailDTO;
    }

}
