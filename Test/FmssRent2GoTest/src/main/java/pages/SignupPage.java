package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class SignupPage {
    private AppiumDriver<MobileElement> driver;
    public SignupPage(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }


    private final By individualButton = By.id("individualButton_id");
    private final By corporateButton = By.id("corporateButton_id");

    private final By identityNumberField = By.id("identityNumberField_id");
    private final By firstNameField = By.id("firstNameField_id");
    private final By lastNameField = By.id("lastNameField_id");
    private final By birthdateField = By.id("birthdateField_id");
    private final By genderMaleRadioButton = By.id("genderMaleRadioButton_id");
    private final By genderFemaleRadioButton = By.id("genderFemaleRadioButton_id");

    private final By emailField = By.id("emailField_id");
    private final By phoneNumberField = By.id("phoneNumberField_id");
    private final By passwordField = By.id("passwordField_id");
    private final By confirmPasswordField = By.id("confirmPasswordField_id");


    private final By taxNumberField = By.id("taxNumberField_id");
    private final By companyNameField = By.id("companyNameField_id");
    private final By contactNameField = By.id("contactNameField_id");


    private final By licenseIdField = By.id("licenseIdField_id");
    private final By purchasePlaceField = By.id("purchasePlaceField_id");
    private final By licenseDateField = By.id("licenseDateField_id");
    private final By licenseGroupField = By.id("licenseGroupField_id");


    private final By userAgreementCheckbox = By.id("userAgreementCheckbox_id");
    private final By signupSubmitButton = By.id("signupSubmitButton_id");
    private final By nextButton = By.id("nextButton_id");


    private final By registrationSuccessMessage = By.id("registrationSuccessMessage_id");
    private final By errorMessage = By.id("errorMessage_id");




    public void clickIndividualButton() {
        driver.findElement(individualButton).click();
    }


    public void clickCorporateButton() {
        driver.findElement(corporateButton).click();
    }


    public void enterIdentityNumber(String identityNumber) {
        driver.findElement(identityNumberField).sendKeys(identityNumber);
    }


    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }


    public void selectBirthdate(String birthdate) {
        driver.findElement(birthdateField).sendKeys(birthdate);
    }


    public void selectGender(String gender) {
        if ("Male".equalsIgnoreCase(gender)) {
            driver.findElement(genderMaleRadioButton).click();
        } else if ("Female".equalsIgnoreCase(gender)) {
            driver.findElement(genderFemaleRadioButton).click();
        }
    }


    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }


    public void enterPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
    }


    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void confirmPassword(String confirmPassword) {
        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
    }


    public void enterTaxNumber(String taxNumber) {
        driver.findElement(taxNumberField).sendKeys(taxNumber);
    }

    public void enterCompanyName(String companyName) {
        driver.findElement(companyNameField).sendKeys(companyName);
    }

    public void enterContactName(String contactName) {
        driver.findElement(contactNameField).sendKeys(contactName);
    }


    public void enterLicenseId(String licenseId) {
        driver.findElement(licenseIdField).sendKeys(licenseId);
    }

    public void enterPurchasePlace(String place) {
        driver.findElement(purchasePlaceField).sendKeys(place);
    }

    public void selectLicenseDate(String date) {
        driver.findElement(licenseDateField).sendKeys(date);
    }

    public void selectLicenseGroup(String group) {
        driver.findElement(licenseGroupField).sendKeys(group);
    }


    public void clickUserAgreementCheckbox() {
        driver.findElement(userAgreementCheckbox).click();
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }


    public void clickSignupSubmitButton() {
        driver.findElement(signupSubmitButton).click();
    }


    public boolean isRegistrationSuccessMessageDisplayed() {
        return driver.findElement(registrationSuccessMessage).isDisplayed();
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElement(errorMessage).isDisplayed();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMessage).getText();
    }
}
