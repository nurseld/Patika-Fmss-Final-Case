package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import pages.ProfilePage;
import utils.DriverManager;

public class LogoutStep {
    private AppiumDriver<MobileElement> driver;
    private LoginPage loginPage;
    private ProfilePage profilePage;

    public  LogoutStep(){

        this.driver = DriverManager.getDriver();
        this.loginPage = new LoginPage(driver);
        this.profilePage = new ProfilePage(driver);

    }

    @Given("User opens the app")
    public void userOpensTheApp() {
        driver.launchApp();
    }

    @Given("User should be logged in as an Individual customer")
    public void userShouldBeLoggedInAsAnIndividualCustomer() {
        loginPage.clickIndividualButton();
        loginPage.fillEmail("individualUser@example.com");
        loginPage.fillPassword("password123");
        loginPage.clickLoginButton();
        assert loginPage.isIndividualUserLabelDisplayed() : "Individual customer is not logged in.";
    }

    @Given("User should be logged in as a Corporate customer")
    public void userShouldBeLoggedInAsACorporateCustomer() {
        loginPage.clickCorporateButton();
        loginPage.fillEmail("corporateUser@example.com");
        loginPage.fillPassword("password123");
        loginPage.clickLoginButton();
        assert loginPage.isCorporateUserLabelDisplayed() : "Corporate customer is not logged in.";
    }

    @When("User clicks the {string} button")
    public void userClicksTheLogoutButton(String button) {
        profilePage.clickLogoutButton(button);
    }

    @Then("User should be redirected to the {string} screen")
    public void userShouldBeRedirectedToTheLoginScreen(String screen) {
        assert profilePage.isLoginScreenDisplayed(screen) : "User was not redirected to the login screen.";
    }
}
