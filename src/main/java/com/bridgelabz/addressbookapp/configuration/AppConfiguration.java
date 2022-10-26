package com.bridgelabz.addressbookapp.configuration;

import com.bridgelabz.addressbookapp.util.EmailSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    public EmailSender emailSenderService()
    {
        return new EmailSender();
    }
}
