package ge.cugu.security;

import ge.cugu.port.in.security.resetpassword.ResetPasswordUseCase;
import ge.cugu.port.in.security.resetpassword.exception.CurrentPasswordIsIncorrectException;
import ge.cugu.port.in.user.exception.PasswordDidntMatchException;
import ge.cugu.port.in.user.exception.UserNotFoundException;
import ge.cugu.port.model.requestmodel.resetpassword.ForgotPasswordRequestModel;
import ge.cugu.port.model.requestmodel.resetpassword.ResetForgottenPasswordRequestModel;
import ge.cugu.port.model.requestmodel.resetpassword.ResetPasswordRequestModel;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;

@RestController
@RequestMapping("/api/resetPassword")
@RequiredArgsConstructor
public class PasswordReset {
    private final ResetPasswordUseCase resetPasswordUseCase;

    @PostMapping
    public void resetPassword(@RequestBody @Valid ResetPasswordRequestModel model,
                              Principal principal)
            throws PasswordDidntMatchException, UserNotFoundException, CurrentPasswordIsIncorrectException {
        resetPasswordUseCase.resetPassword(principal.getName(), model);
    }

    @PostMapping("/forgotPassword")
    public void forgotPassword(@RequestBody @Valid ForgotPasswordRequestModel model) {
        resetPasswordUseCase.forgotPassword(model);
    }

    @PostMapping("/forgotPassword/{code}")
    public void resetForgottenPassword(@PathVariable String code,
                                       @RequestBody @Valid ResetForgottenPasswordRequestModel model)
            throws PasswordDidntMatchException {
        resetPasswordUseCase.resetForgottenPassword(code, model);
    }

}
