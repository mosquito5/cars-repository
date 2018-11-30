package pl.mosquito.cars.email;

public interface EmailService {
//    void sendEmail(String to, String subject, String text);
    void email(String to, String userName, String subject);
    void emailSimple(String to, String userName, String subject);
}
