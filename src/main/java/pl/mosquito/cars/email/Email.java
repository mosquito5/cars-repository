package pl.mosquito.cars.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class Email implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

//    @Override
//    public void sendEmail(String to, String subject, String text) {
//        SimpleMailMessage msg = new SimpleMailMessage();
//
//        msg.setTo(to);
//        msg.setSubject(subject);
//        msg.setText(text);
//
//        javaMailSender.send(msg);
//
//    }

    @Override
    public void email(String to, String body, String subject) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body,true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);
    }

    @Override
    public void emailSimple(String to, String userName, String subject) {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText("Dear " + userName + " your account has been registered successfully");

        javaMailSender.send(msg);
    }
}
