package by.onliner.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButtonSignIn() {
        By buttonSignInBy = By.xpath(LoginXpath.BUTTON_SIGN_IN_LOCATOR);
        WebElement buttonSignInWebElement = driver.findElement(buttonSignInBy);
        buttonSignInWebElement.click();
    }

    public void sendKeysInputNickOrEmail(String NickOrEmail) {
        By inputNickOrEmailBy = By.xpath(LoginXpath.INPUT_NICK_OR_EMAIL_LOCATOR);
        WebElement inputNickOrEmailWebElement = driver.findElement(inputNickOrEmailBy);
        inputNickOrEmailWebElement.sendKeys(NickOrEmail);
    }

    public void sendKeysInputPassword(String password) {
        By inputPasswordBy = By.xpath(LoginXpath.INPUT_PASSWORD_LOCATOR);
        WebElement inputPasswordWebElement = driver.findElement(inputPasswordBy);
        inputPasswordWebElement.sendKeys(password);
    }

    public void clickButtonSubmit() {
        By buttonSubmitBy = By.xpath(LoginXpath.BUTTON_SUBMIT_LOCATOR);
        WebElement buttonSubmitWebElement = driver.findElement(buttonSubmitBy);
        buttonSubmitWebElement.click();
    }

    public String getEmptyNickOrEmailErrorMessageText() {
        By textEmptyNickOrEmailErrorMessageBy = By.xpath(LoginXpath.EMPTY_NICK_OR_EMAIL_ERROR_MESSAGE_LOCATOR);
        WebElement textEmptyNickOrEmailErrorMessageWebElement = driver.findElement(textEmptyNickOrEmailErrorMessageBy);
        return textEmptyNickOrEmailErrorMessageWebElement.getText();
    }

    public String getEmptyPasswordErrorMessageText() {
        By textEmptyPasswordErrorMessageBy = By.xpath(LoginXpath.EMPTY_PASSWORD_ERROR_MESSAGE_LOCATOR);
        WebElement textEmptyPasswordErrorMessageWebElement = driver.findElement(textEmptyPasswordErrorMessageBy);
        return textEmptyPasswordErrorMessageWebElement.getText();
    }

    public String getInvalidCredentialsErrorMessageText() {
        By textInvalidCredentialsErrorMessageBy = By.xpath(LoginXpath.INVALID_CREDENTIALS_ERROR_MESSAGE_LOCATOR);
        WebElement textInvalidCredentialsErrorMessageWebElement = driver.findElement(textInvalidCredentialsErrorMessageBy);
        return textInvalidCredentialsErrorMessageWebElement.getText();
    }
}
