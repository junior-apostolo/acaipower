package com.power.acai.service;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.SimpleMailMessage;

import com.power.acai.model.User;

public interface EmailService {

//  void sendOrderConfirmationHtmlEmail(Pedido obj);
//    void sendOrderConfirmationEmail(Pedido obj);
	void sendMail(SimpleMailMessage msg);

	void sendHtmlEmail(MimeMessage msg);

	void sendNewPasswordEmail(User cliente, String newPass);
}
