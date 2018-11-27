package pl.mosquito.cars.email;

public interface EmailService {
    void sendEmail(String to, String subject, String text);
    void regEmail(String to, String userName);
    void regEmailSimple(String to, String userName);
}
