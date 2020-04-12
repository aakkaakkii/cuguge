package ge.cugu.port.in.security.resetpassword.exception;

public class CurrentPasswordIsIncorrectException extends Exception {
    public CurrentPasswordIsIncorrectException(){
        super("Current password is incorect");
    }
}
