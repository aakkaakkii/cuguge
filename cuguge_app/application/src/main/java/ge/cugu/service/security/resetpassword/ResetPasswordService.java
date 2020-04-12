package ge.cugu.service.security.resetpassword;

import ge.cugu.domain.user.ActivationCode;
import ge.cugu.domain.user.User;
import ge.cugu.port.in.security.resetpassword.ResetPasswordUseCase;
import ge.cugu.port.in.security.resetpassword.exception.CurrentPasswordIsIncorrectException;
import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.UserNotFoundException;
import ge.cugu.port.model.requestmodel.resetpassword.ForgotPasswordRequestModel;
import ge.cugu.port.model.requestmodel.resetpassword.ResetForgottenPasswordRequestModel;
import ge.cugu.port.model.requestmodel.resetpassword.ResetPasswordRequestModel;
import ge.cugu.port.out.authentication.AuthUtilPort;
import ge.cugu.port.out.mail.MailPort;
import ge.cugu.port.out.user.ActivationCodePort;
import ge.cugu.port.out.user.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ResetPasswordService implements ResetPasswordUseCase {
    private final UserPort userPort;
    private final ActivationCodePort activationCodePort;
    private final MailPort mailPort;
    private final AuthUtilPort authUtilPort;

    @Override
    public void resetPassword(String username, ResetPasswordRequestModel model)
            throws PasswordDidntMatchException, UserNotFoundException, CurrentPasswordIsIncorrectException {
        
        if (!model.getNewPassword().equals(model.getRepeatNewPassword())) {
            throw new PasswordDidntMatchException();
        }

        User user = userPort.findByUsername(username);

        if (user == null) {
            throw new UserNotFoundException(username);
        }

        if (!authUtilPort.checkPassword(model.getNewPassword(), user.getPassword())) {
            throw new CurrentPasswordIsIncorrectException();
        }

        user.setPassword(authUtilPort.encodePassword(model.getPassword()));
        userPort.update(user);
    }

    @Override
    public void forgotPassword(ForgotPasswordRequestModel model) {
        User user = userPort.findByMailOrUsernameAndType(model.getUsernameOrPassword(), User.Type.DEFAULT);

        if (user != null) {
            sendResetCode(user);
        }
    }

    @Override
    public void resetForgottenPassword(String code, ResetForgottenPasswordRequestModel model)
            throws PasswordDidntMatchException {

        if (!model.getPassword().equals(model.getRepeatPassword())) {
            throw new PasswordDidntMatchException();
        }

        ActivationCode activationCode = activationCodePort.findByCode(code);

        if (activationCode != null && activationCode.getUser() != null) {
            User user = activationCode.getUser();
            user.setPassword(authUtilPort.encodePassword(model.getPassword()));
            userPort.update(user);
            activationCodePort.delete(activationCode.getId());
        }
    }

    private void sendResetCode(User user) {
        ActivationCode activationCode = activationCodePort.add(ActivationCode.builder()
                .activationCode(UUID.randomUUID().toString())
                .user(user)
                .build());

        String message = String.format(
                "Hello %s!\n" +
                        "Reset Password link: http://localhost:8080/api/registration/activation/%s",
                user.getUsername(),
                activationCode.getActivationCode()
        );

        mailPort.send(user.getMail(), "Reset Password", message);
    }
}
