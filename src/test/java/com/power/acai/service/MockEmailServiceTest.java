package com.power.acai.service;

import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public class MockEmailServiceTest extends AbstractEmailService {
	private static final Logger LOG = LoggerFactory.getLogger(MockEmailServiceTest.class);
	@Value("${default.sender}")
    private String sender;
	@Override
	public void sendMail(SimpleMailMessage msg) {
		LOG.info("Simulando envio de email...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}

	@Override
	public void sendHtmlEmail(MimeMessage msg) {
		LOG.info("Simulando envio de email HTML...");
		LOG.info(msg.toString());
		LOG.info("Email enviado");
	}
//    public void sendNewPasswordEmail(User cliente, String newPass){
//        SimpleMailMessage simpleMailMessage = prepareNewPasswordEmail(cliente, newPass);
//        sendMail(simpleMailMessage);
//    }
//
//    protected SimpleMailMessage prepareNewPasswordEmail(User cliente, String newPass) {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(cliente.getEmail());
//        simpleMailMessage.setFrom(sender);
//        simpleMailMessage.setSubject("Solicitação de nova senha");
//        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
//        simpleMailMessage.setText("Nova senha: " + newPass);
//        return simpleMailMessage;
//    }
}
