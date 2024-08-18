package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DriverManager;

public class LoginStep {
    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;

    public LoginStep() {

        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
    }

    @Given("User opens the app")
    public void userOpensTheApp() {
        driver.launchApp();
    }

    @And("User clicks the {string} button")
    public void userClicksTheButton(String button) {
        switch (button) {
            case "Individual":
                loginPage.clickIndividualButton();
                break;
            case "Corporate":
                loginPage.clickCorporateButton();
                break;
            case "Sign Up":
                loginPage.clickSignUpButton();
                break;
            case "Guest User":
                loginPage.clickGuestUserButton();
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + button);
        }
    }

    @And("User fills email as {string}")
    public void userFillsEmailAs(String email) {
        loginPage.fillEmail(email);
    }

    @And("User fills password as {string}")
    public void userFillsPasswordAs(String password) {
        loginPage.fillPassword(password);
    }

    @And("User clicks the login button")
    public void userClicksTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("User should be logged in as an Individual customer")
    public void userShouldBeLoggedInAsAnIndividualCustomer() {
        assert loginPage.isIndividualUserLabelDisplayed() : "Individual user label is not displayed";
    }

    @Then("User should be logged in as a Corporate customer")
    public void userShouldBeLoggedInAsACorporateCustomer() {
        assert loginPage.isCorporateUserLabelDisplayed() : "Corporate user label is not displayed";
    }

    @When("User clicks the Sign Up button")
    public void userClicksTheSignUpButton() {
        loginPage.clickSignUpButton();
    }

    @Then("User should be on the Sign Up screen")
    public void userShouldBeOnTheSignUpScreen() {
        assert loginPage.isSignUpFormDisplayed() : "Sign Up form is not displayed";
    }

    @When("User clicks the Guest User button")
    public void userClicksTheGuestUserButton() {
        loginPage.clickGuestUserButton();
    }

    @Then("User should be able to use the app as a guest")
    public void userShouldBeAbleToUseTheAppAsAGuest() {
        assert loginPage.isGuestAccessLabelDisplayed() : "Guest access label is not displayed";
    }

    @When("User clicks the {string} link")
    public void userClicksTheLink(String link) {
        if ("Forgot Password".equals(link)) {
            loginPage.clickForgotPasswordLink();
        } else {
            throw new IllegalArgumentException("Unknown link: " + link);
        }
    }


    @Then("User should see {string} confirmation massage")
    public void userShouldSeeConfirmationMassage(String confirmationMessage) {
        assert loginPage.getConfirmationMessage().equals(confirmationMessage) : "Confirmation message is incorrect";

    }

    @Then("User should see {string} error meesage")
    public void userShouldSeeErrorMeesage(String errorMessage) {
        assert loginPage.getErrorMessage().equals(errorMessage) : "Error message is incorrect";
    }
}