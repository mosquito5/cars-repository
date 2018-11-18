package pl.mosquito.cars.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class Email implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(text);

        javaMailSender.send(msg);

    }

    @Override
    public void regEmail(String to) {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(to);
        msg.setSubject("Your account has ben registered");
        msg.setText("Thank you for registration");

        javaMailSender.send(msg);
    }
}
