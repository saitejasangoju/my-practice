package com.practice.sendmail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;

@RestController
public class SendMailController {

    @Autowired
    private SendMailService sendMailService;

    @GetMapping("/send-email")
    public String sendEmail() {
        try {
            sendMailService.sendEmailWithAttachment();
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return "Email sent successfully!";
    }

}
