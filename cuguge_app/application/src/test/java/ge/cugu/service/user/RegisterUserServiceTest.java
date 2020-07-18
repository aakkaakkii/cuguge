package ge.cugu.service.user;

import ge.cugu.domain.user.ActivationCode;
import ge.cugu.domain.user.User;
import ge.cugu.port.model.requestmodel.user.CreateUserRequestModel;
import ge.cugu.port.model.responsemodel.user.UserResponseModel;
import ge.cugu.port.out.authentication.AuthUtilPort;
import ge.cugu.port.out.mail.MailPort;
import ge.cugu.port.out.user.ActivationCodePort;
import ge.cugu.port.out.user.UserPort;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class RegisterUserServiceTest {

    @Mock
    private UserPort userPort;
    @Mock
    private ActivationCodePort activationCodePort;
    @Mock
    private MailPort mailPort;
    @Mock
    private AuthUtilPort authUtilPort;

    private RegisterUserService registerUserService;

    public RegisterUserServiceTest() {
//        MockitoAnnotations.initMocks(this);
//        this.registerUserService = new RegisterUserService(userPort, activationCodePort, mailPort, authUtilPort);
    }
/*

    @Test
    public void registrationSuccess() throws Exception {
        CreateUserRequestModel createUserRequestModel = CreateUserRequestModel.builder()
                .mail("asd@asd.com")
                .username("test")
                .password("asd")
                .repeatPassword("asd")
                .build();

        User user = createUser();

        ActivationCode activationCode = createActivationCode(user);

        UserResponseModel responseModel = registerUserService.register(createUserRequestModel);

        Mockito.when(userPort.add(User.class)).thenReturn(dummyUser);


        Mockito.doReturn(new User())
                .when(userPort)
                .add();

        Mockito.doReturn(activationCode)
                .when(activationCodePort)
                .add(activationCode);

        Assert.assertNotNull(responseModel);
    }

    @Test
    public void activate() throws Exception {
        User user = createUser();
        ActivationCode activationCode = createActivationCode(user);

        Mockito.doReturn(activationCode)
                .when(activationCodePort)
                .findByCode("test");

        registerUserService.activate("test");

        Assert.assertTrue(user.isActive());

    }

    private ActivationCode createActivationCode(User user) {
        return ActivationCode.builder()
                    .id(2L)
                    .user(user)
                    .activationCode("test")
                    .build();
    }

    private User createUser(){
        return User.builder()
                .id(1L)
                .mail("asd@asd.com")
                .username("asd")
                .active(false)
                .build();
    }
*/

}