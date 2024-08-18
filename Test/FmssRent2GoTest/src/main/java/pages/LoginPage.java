package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

public class LoginPage {


    private AppiumDriver<MobileElement> driver;

    public LoginPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private final By individualButton = By.id("individualButton_id");
    private final By corporateButton = By.id("corporateButton_id");
    private final By emailField = By.id("emailField_id");
    private final By passwordField = By.id("passwordField_id");
    private final By loginButton = By.id("loginButton_id");
    private final By forgotPasswordLink = By.id("forgotPasswordLink_id");
    private final By signUpButton = By.id("signUpButton_id");
    private final By guestUserButton = By.id("guestUserButton_id");
    private final By individualUserLabel = By.id("individualUserLabel_id");
    private final By corporateUserLabel = By.id("corporateUserLabel_id");
    private final By signUpForm = By.id("signUpForm_id");
    private final By guestAccessLabel = By.id("guestAccessLabel_id");
    private final By confirmationMessage = By.id("confirmationMessage_id");
    private final By errorMessage = By.id("errorMessage_id");



    public boolean isLoginScreenDisplayed() {
        try {
            return driver.findElement(loginButton).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickIndividualButton() {
        driver.findElement(individualButton).click();
    }

    public void clickCorporateButton() {
        driver.findElement(corporateButton).click();
    }

    public void fillEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void fillPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickForgotPasswordLink() {
        driver.findElement(forgotPasswordLink).click();
    }

    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }

    public void clickGuestUserButton() {
        driver.findElement(guestUserButton).click();
    }

    public boolean isIndividualUserLabelDisplayed() {
        return driver.findElement(individualUserLabel).isDisplayed();
    }

    public boolean isCorporateUserLabelDisplayed() {
        return driver.findElement(corporateUserLabel).isDisplayed();
    }

    public boolean isSignUpFormDisplayed() {
        return driver.findElement(signUpForm).isDisplayed();
    }

    public boolean isGuestAccessLabelDisplayed() {
        return driver.findElement(guestAccessLabel).isDisplayed();
    }

    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }


}

