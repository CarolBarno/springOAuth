/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cb.auth.utilities.common;

import com.cb.auth.utilities.mail.MailService;
import com.cb.auth.utilities.mail.MockMailSender;
import com.cb.auth.utilities.mail.SmtpMailSender;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
@Slf4j
public class ApplicationConfig {

    @Autowired
    private DataSource dataSource;

    /**
     * Configures a MockMailSender when the property
     * <code>spring.mail.host</code> isn't defined.
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(MailService.class)
    @ConditionalOnProperty(name = "spring.mail.host", havingValue = "foo", matchIfMissing = true)
    public MailService<?> mockMailSender() {
        log.info("Configuring MockMailSender");
        return new MockMailSender();
    }

    /**
     * Configures an SmtpMailSender when the property
     * <code>spring.mail.host</code> is defined.
     *
     * @param javaMailSender
     * @return
     */
    @Bean
    @ConditionalOnMissingBean(MailService.class)
    @ConditionalOnProperty("spring.mail.host")
    public MailService<?> smtpMailSender(JavaMailSender javaMailSender) {
        log.info("Configuring SmtpMailSender");
        return new SmtpMailSender(javaMailSender);
    }

    /**
     * Conversion between Applications Entities and DTO
     *
     * @return
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
}
