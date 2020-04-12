package ge.cugu.port.in.user.exception;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(Long id) {
        super(String.format("User with Id - '%d' not found", id));
    }

    public UserNotFoundException(String username) {
        super(String.format("User with username '%s' not found", username));
    }
}

