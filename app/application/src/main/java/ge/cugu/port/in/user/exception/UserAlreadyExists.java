package ge.cugu.port.in.user.exception;

public class UserAlreadyExists extends Exception {

    public UserAlreadyExists(String username) {
        super(String.format("User with username '%s' already exists", username));
    }
}
