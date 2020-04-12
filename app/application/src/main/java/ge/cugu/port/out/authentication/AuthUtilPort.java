package ge.cugu.port.out.authentication;

public interface AuthUtilPort {
    boolean checkPassword(String password, String passwordFromDb);
    String encodePassword(String password);
}
