package com.osti.ostirh.appContacto.Service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.osti.ostirh.appContacto.Modelo.Contacto;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author len
 */
public class EmailManagerImpl implements EmailManager {

    @Override
    public boolean EnviarEmail(Contacto contacto) {
        // Recipient's email ID needs to be mentioned.
        String to = contacto.getEmail();

        // Sender's email ID needs to be mentioned
        String from = "info@ostirh.com";
        final String username = "info@ostirh.com";//change accordingly
        final String password = "1236034#24sd";//change accordingly

        // Assuming you are sending email through relay.jangosmtp.net
        String host = "mail.ostirh.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");

        // Get the Session object.
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject("Informação sobre o OSTIRH");

            // Now set the actual message
            message.setText(contacto.getMensagem() + "\n\nNome: " + contacto.getNome() + " \nTelefone: " + contacto.getTelefone());

            // Send message
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            System.out.println("Erro: " + e);
            //throw new RuntimeException(e);
            return false;
        }
        return true;
    }

}
