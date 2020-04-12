package ge.cugu.port.out.mail;

public interface MailPort {
    void send(String emailTo, String subject, String message);
}
