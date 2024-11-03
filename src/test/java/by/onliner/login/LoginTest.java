package by.onliner.login;

import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    @Test(testName ="Empty nick or email and password error")
    public void testEmptyNickOrEmailAndPassword() {
        loginPage.clickButtonSignIn();
        loginPage.clickButtonSubmit();
        Assert.assertEquals(LoginMessage.ENTER_A_NICKNAME_OR_EMAIL, loginPage.getEmptyNickOrEmailErrorMessageText());
        Assert.assertEquals(LoginMessage.ENTER_PASSWORD, loginPage.getEmptyPasswordErrorMessageText());
    }

    @Test(testName ="Empty password error")
    public void testEmptyPassword() {
        loginPage.clickButtonSignIn();
        loginPage.sendKeysInputNickOrEmail("test@test.com");
        loginPage.clickButtonSubmit();
        Assert.assertEquals(LoginMessage.ENTER_PASSWORD, loginPage.getEmptyPasswordErrorMessageText());
    }

    @Test(testName ="Empty nick or email error")
    public void testEmptyNickOrEmail() {
        loginPage.clickButtonSignIn();
        loginPage.sendKeysInputPassword("test");
        loginPage.clickButtonSubmit();
        Assert.assertEquals(LoginMessage.ENTER_A_NICKNAME_OR_EMAIL, loginPage.getEmptyNickOrEmailErrorMessageText());
    }

    @Test(testName ="Invalid credentials error")
    public void testInvalidCredentials() {
        loginPage.clickButtonSignIn();
        loginPage.sendKeysInputNickOrEmail("test@test.com");
        loginPage.sendKeysInputPassword("test");
        loginPage.clickButtonSubmit();
        Assert.assertEquals(LoginMessage.INVALID_LOGIN_OR_PASSWORD, loginPage.getInvalidCredentialsErrorMessageText());
    }
}
