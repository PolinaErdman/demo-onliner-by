package by.onliner;

import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.get("https://www.onliner.by/");
        loginPage = new LoginPage(driver);
    }

    @Test
    @DisplayName("Empty nick or email and password error")
    public void testEmptyNickOrEmailAndPassword() {
        loginPage.clickButtonSignIn();
        loginPage.clickButtonSubmit();
        Assertions.assertEquals(LoginMessage.ENTER_A_NICKNAME_OR_EMAIL, loginPage.getEmptyNickOrEmailErrorMessageText());
        Assertions.assertEquals(LoginMessage.ENTER_PASSWORD, loginPage.getEmptyPasswordErrorMessageText());
    }

    @Test
    @DisplayName("Empty password error")
    public void testEmptyPassword() {
        loginPage.clickButtonSignIn();
        loginPage.sendKeysInputNickOrEmail("test@test.com");
        loginPage.clickButtonSubmit();
        Assertions.assertEquals(LoginMessage.ENTER_PASSWORD, loginPage.getEmptyPasswordErrorMessageText());
    }

    @Test
    @DisplayName("Empty nick or email error")
    public void testEmptyNickOrEmail() {
        loginPage.clickButtonSignIn();
        loginPage.sendKeysInputPassword("test");
        loginPage.clickButtonSubmit();
        Assertions.assertEquals(LoginMessage.ENTER_A_NICKNAME_OR_EMAIL, loginPage.getEmptyNickOrEmailErrorMessageText());
    }

    @Test
    @DisplayName("Invalid credentials error")
    public void testInvalidCredentials() {
        loginPage.clickButtonSignIn();
        loginPage.sendKeysInputNickOrEmail("test@test.com");
        loginPage.sendKeysInputPassword("test");
        loginPage.clickButtonSubmit();
        Assertions.assertEquals(LoginMessage.INVALID_LOGIN_OR_PASSWORD, loginPage.getInvalidCredentialsErrorMessageText());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
