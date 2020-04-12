package ge.cugu.port.model.requestmodel.resetpassword;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ResetPasswordRequestModel {
    @NotBlank
    private String password;
    @NotBlank
    private String newPassword;
    @NotBlank
    private String repeatNewPassword;
}
