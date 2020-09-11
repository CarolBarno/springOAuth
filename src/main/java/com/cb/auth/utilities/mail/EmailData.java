/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.utilities.mail;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class EmailData {

    @Autowired
    private Environment env;

    private String to;
    private String subject;
    private String body;
    private String from;
    private boolean isMultipart;
    private boolean isHtml;

    public static EmailData of(String to, String subject, String body) {

        EmailData data = new EmailData();

        data.to = to;
        data.subject = subject;
        data.body = body;

        return data;
    }

}
