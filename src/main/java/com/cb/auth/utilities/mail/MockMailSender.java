/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.utilities.mail;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MockMailSender implements MailService<EmailData> {

    public MockMailSender() {
        log.info("Created");
    }

    @Override
    public void send(EmailData mail) {
        log.info("Sending mail to " + mail.getTo());
        log.info("Subject: " + mail.getSubject());
        log.info("Body: " + mail.getBody());
    }

}
