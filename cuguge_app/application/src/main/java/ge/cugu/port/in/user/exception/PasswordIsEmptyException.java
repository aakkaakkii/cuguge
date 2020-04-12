package ge.cugu.port.in.user.exception;

public class PasswordIsEmptyException extends Exception{
    public PasswordIsEmptyException(){
        super("password is empty");
    }
}
