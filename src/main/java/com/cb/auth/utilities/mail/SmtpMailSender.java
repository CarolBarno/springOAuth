/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.utilities.mail;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;

@Slf4j
public class SmtpMailSender implements MailService<EmailData> {

    private final JavaMailSender javaMailSender;

    // 
    public SmtpMailSender(JavaMailSender javaMailSender) {

        this.javaMailSender = javaMailSender;
        log.info("Created");
    }

    /**
     * Sends a mail using a MimeMessageHelper
     *
     * @param mail
     */
    @Override
    @Async
    public void send(EmailData mail) {

        log.info("Sending SMTP mail from thread " + Thread.currentThread().getName()); // toString gives more info    	

        // create a mime-message
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {

            // create a helper
            helper = new MimeMessageHelper(message, true);
            // set the attributes
            helper.setSubject(mail.getSubject());
            helper.setTo(mail.getTo());
            helper.setText(mail.getBody(), true); // true indicates html
            helper.setFrom("email address");
//             continue using helper object for more functionalities like adding attachments, etc.  

        } catch (MessagingException e) {

            throw new RuntimeException(e);
        }

        //send the mail
        javaMailSender.send(message);
        log.info("Sent SMTP mail from thread " + Thread.currentThread().getName());
    }

}
