package ge.cugu.port.in.user.exception;

public class MailAlreadyExistsException  extends Exception {
    public MailAlreadyExistsException(){
        super("Mail Already Exists");
    }
}
