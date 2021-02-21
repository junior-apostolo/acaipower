package com.power.acai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.power.acai.service.EmailService;
import com.power.acai.service.SmtpEmailService;



@SpringBootApplication
public class PowerAcaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerAcaiApplication.class, args);

	}
    @Bean
    public EmailService emailService(){
        return new SmtpEmailService();
    }

}
