package ge.cugu.port.model.requestmodel.resetpassword;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ForgotPasswordRequestModel {
    @NotBlank
    private String usernameOrPassword;
}
