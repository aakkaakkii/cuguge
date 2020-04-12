package ge.cugu.port.in.user.exception;

public class PasswordDidntMatchException extends Exception {
    public PasswordDidntMatchException(){
        super("Password didn't Match");
    }
}