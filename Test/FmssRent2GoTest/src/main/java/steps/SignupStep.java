package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SignupPage;
import utils.DriverManager;

public class SignupStep {
    private AppiumDriver<MobileElement> driver;
    private SignupPage signupPage;
    public SignupStep() {
        this.driver = DriverManager.getDriver();
        this.signupPage = new SignupPage(driver);
    }

    @Given("User opens the app")
    public void userOpensTheApp() {
        driver.launchApp();
    }

    @When("user clicks the {string} button")
    public void userClicksTheButton(String button) {
        switch (button.toLowerCase()) {
            case "individual":
                signupPage.clickIndividualButton();
                break;
            case "corporate":
                signupPage.clickCorporateButton();
                break;
            case "signup":
                signupPage.clickSignupSubmitButton();
                break;
            case "next":
                signupPage.clickNextButton();
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + button);
        }
    }

    @When("user clicks the {string} button without filling any fields")
    public void userClicksTheButtonWithoutFillingAnyFields(String button) {
        switch (button.toLowerCase()) {
            case "signup":
                signupPage.clickSignupSubmitButton();
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + button);
        }
    }

    @And("user enters valid information in all fields")
    public void userEntersValidInformationInAllFields() {
        signupPage.enterIdentityNumber("12345678901");
        signupPage.enterFirstName("John");
        signupPage.enterLastName("Doe");
        signupPage.selectBirthdate("01/01/1990");
        signupPage.selectGender("Male");
        signupPage.enterEmail("johndoe@example.com");
        signupPage.enterPhoneNumber("+123456789");
        signupPage.enterPassword("Password123!");
        signupPage.confirmPassword("Password123!");
    }

    @And("user fills all fields correctly")
    public void userFillsAllFieldsCorrectly() {
        signupPage.enterTaxNumber("11111111111");
        signupPage.enterCompanyName("ABC Corp.");
        signupPage.enterContactName("John Doe");
        signupPage.enterEmail("corp@example.com");
        signupPage.enterPhoneNumber("+987654321");
        signupPage.enterPassword("Password456!");
        signupPage.confirmPassword("Password456!");
    }

    @And("user leaves the phone number field blank")
    public void userLeavesThePhoneNumberFieldBlank() {
        signupPage.enterPhoneNumber("");
    }

    @And("user enters {string} as identity number")
    public void userEntersAsIdentityNumber(String identityNumber) {
        signupPage.enterIdentityNumber(identityNumber);
    }

    @And("user enters {string} as first name")
    public void userEntersAsFirstName(String firstName) {
        signupPage.enterFirstName(firstName);
    }

    @And("user enters {string} as last name")
    public void userEntersAsLastName(String lastName) {
        signupPage.enterLastName(lastName);
    }

    @And("user selects {string} as birthdate")
    public void userSelectsAsBirthdate(String birthdate) {
        signupPage.selectBirthdate(birthdate);
    }

    @And("user selects {string} as gender")
    public void userSelectsAsGender(String gender) {
        signupPage.selectGender(gender);
    }

    @And("user enters {string} as email")
    public void userEntersAsEmail(String email) {
        signupPage.enterEmail(email);
    }

    @And("user enters {string} as phone number")
    public void userEntersAsPhoneNumber(String phoneNumber) {
        signupPage.enterPhoneNumber(phoneNumber);
    }

    @And("user enters {string} as password")
    public void userEntersAsPassword(String password) {
        signupPage.enterPassword(password);
    }

    @And("user confirms {string} as password")
    public void userConfirmsAsPassword(String confirmPassword) {
        signupPage.confirmPassword(confirmPassword);
    }

    @And("user enters {string} as tax number")
    public void userEntersAsTaxNumber(String taxNumber) {
        signupPage.enterTaxNumber(taxNumber);
    }

    @And("user enters {string} as company name")
    public void userEntersAsCompanyName(String companyName) {
        signupPage.enterCompanyName(companyName);
    }

    @And("user enters {string} as contact name")
    public void userEntersAsContactName(String contactName) {
        signupPage.enterContactName(contactName);
    }

    @And("user enters {string} as drivers license id")
    public void userEntersAsDriversLicenseId(String licenseId) {
        signupPage.enterLicenseId(licenseId);
    }

    @And("user enters {string} as place to purchase driving license")
    public void userEntersAsPlaceToPurchaseDrivingLicense(String place) {
        signupPage.enterPurchasePlace(place);
    }

    @And("user selects {string} as date of taking license")
    public void userSelectsAsDateOfTakingLicense(String date) {
        signupPage.selectLicenseDate(date);
    }

    @And("user selects {string} as driving license group")
    public void userSelectsAsDrivingLicenseGroup(String group) {
        signupPage.selectLicenseGroup(group);
    }

    @And("user agrees to the user agreement")
    public void userAgreesToTheUserAgreement() {
        signupPage.clickUserAgreementCheckbox();
    }

    @Then("user should be successfully registered")
    public void userShouldBeSuccessfullyRegistered() {
        assert signupPage.isRegistrationSuccessMessageDisplayed() : "User registration was not successful";
    }

    @Then("user should see validation errors for mandatory fields")
    public void userShouldSeeValidationErrorsForMandatoryFields() {
        assert signupPage.isErrorMessageDisplayed() : "Validation error for mandatory fields not displayed";
    }

    @Then("the error message should say {string}")
    public void userShouldSeeErrorMessage(String errorMessage) {
        assert signupPage.getErrorMessage().equals(errorMessage) : "Error message is incorrect";
    }

    @Then("user should see a password mismatch error")
    public void userShouldSeePasswordMismatchError() {
        assert signupPage.getErrorMessage().equals("Passwords do not match") : "Password mismatch error not displayed";
    }

    @Then("user should see an invalid email format error")
    public void userShouldSeeInvalidEmailFormatError() {
        assert signupPage.getErrorMessage().equals("Please enter a valid email address") : "Invalid email format error not displayed";
    }

    @Then("user should see a weak password error")
    public void userShouldSeeWeakPasswordError() {
        assert signupPage.getErrorMessage().equals("Password is too weak. Please use a stronger password") : "Weak password error not displayed";
    }

    @Then("user should see a phone number required error")
    public void userShouldSeePhoneNumberRequiredError() {
        assert signupPage.getErrorMessage().equals("Phone number is required") : "Phone number required error not displayed";
    }

    @Then("user should see an error message for user agreement")
    public void userShouldSeeErrorMessageForUserAgreement() {
        assert signupPage.getErrorMessage().equals("You must agree to the user agreement.") : "Error message for user agreement not displayed";
    }

}
