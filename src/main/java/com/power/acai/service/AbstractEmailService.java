package com.power.acai.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.TemplateEngine;

import com.power.acai.model.User;

public abstract class AbstractEmailService  implements EmailService {
	@Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

//    @Override
//    public void sendOrderConfirmationEmail(Pedido obj) {
//        SimpleMailMessage simpleMailMessage = prepareSimpleMailMessageFromPedido(obj);
//        sendMail(simpleMailMessage);
//    }

//    protected SimpleMailMessage prepareSimpleMailMessageFromPedido(Pedido obj) {
//        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
//        simpleMailMessage.setTo(obj.getCliente().getEmail());
//        simpleMailMessage.setFrom(sender);
//        simpleMailMessage.setSubject("Pedido confirmado! Código do pedido: " + obj.getId());
//        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
//        simpleMailMessage.setText(obj.toString());
//        return simpleMailMessage;
//    }

//    protected String htmlFromTemplatePedido(Pedido obj){
//        Context context = new Context();
//        context.setVariable("pedido", obj);
//        return templateEngine.process("email/confirmacaoPedido", context);
//    }

//    @Override
//    public void sendOrderConfirmationHtmlEmail(Pedido obj){
//        try {
//            MimeMessage mimeMessage = preprareMimeMessageFromPedido(obj);
//            sendHtmlEmail(mimeMessage);
//        } catch (MessagingException e) {
//            sendOrderConfirmationEmail(obj);
//        }
//
//    }

//    protected MimeMessage preprareMimeMessageFromPedido(Pedido obj) throws MessagingException {
//        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//        mimeMessageHelper.setTo(obj.getCliente().getEmail());
//        mimeMessageHelper.setFrom(sender);
//        mimeMessageHelper.setSubject("Pedido confirmado! Código: " + obj.getId());
//        mimeMessageHelper.setSentDate(new Date(System.currentTimeMillis()));
//        mimeMessageHelper.setText(htmlFromTemplatePedido(obj), true);
//        return mimeMessage;
//    }

    @Override
    public void sendNewPasswordEmail(User cliente, String newPass){
        SimpleMailMessage simpleMailMessage = prepareNewPasswordEmail(cliente, newPass);
        sendMail(simpleMailMessage);
    }

    protected SimpleMailMessage prepareNewPasswordEmail(User cliente, String newPass) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(cliente.getEmail());
        simpleMailMessage.setFrom(sender);
        simpleMailMessage.setSubject("Solicitação de nova senha");
        simpleMailMessage.setSentDate(new Date(System.currentTimeMillis()));
        simpleMailMessage.setText("Nova senha: " + newPass);
        return simpleMailMessage;
    }
}
