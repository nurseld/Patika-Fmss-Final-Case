package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProfilePage;
import utils.DriverManager;

public class ProfileStep {

    private AppiumDriver<MobileElement> driver;
    private ProfilePage profilePage;


    public ProfileStep() {
        this.driver = DriverManager.getDriver();
        this.profilePage = new ProfilePage(driver);
    }

    @Given("User opens the app")
    public void userOpensTheApp() {
        driver.launchApp();
    }

    @When("User navigates to the {string} page")
    public void userNavigatesToThePage(String pageName) {
        switch (pageName) {
            case "Profile Settings":
                profilePage.clickProfileSettings();
                break;
            case "Complaints":
                profilePage.clickComplaints();
                break;
            case "Branch List":
                profilePage.clickBranchList();
                break;
            case "Notification Settings":
                profilePage.clickNotificationSettings();
                break;
            case "Contact":
                profilePage.clickContact();
                break;
            case "Terms of Use":
                profilePage.clickTermsOfUse();
                break;
            case "Corporation Rental List":
                profilePage.clickCorporationRentalList();
                break;
            default:
                throw new IllegalArgumentException("Unknown page: " + pageName);
        }
    }

    @Then("User should see their personal details")
    public void userShouldSeeTheirPersonalDetails() {
        assert profilePage.isWelcomeMessageDisplayed() : "Personal details not displayed";
    }

    @And("User updates their phone number to {string}")
    public void userUpdatesTheirPhoneNumberTo(String phoneNumber) {
        profilePage.updatePhoneNumber(phoneNumber);
    }

    @Then("User should see a message {string}")
    public void userShouldSeeAMessage(String expectedMessage) {
         String actualMessage = profilePage.getConfirmationMessage();
         assert actualMessage.equals(expectedMessage) : "Message did not match!";
    }

    @When("Corporate user navigates to the {string} page")
    public void corporateUserNavigatesToThePage(String pageName) {
        userNavigatesToThePage(pageName);
    }

    @Then("Corporate user should see their company details")
    public void corporateUserShouldSeeTheirCompanyDetails() {

    }

    @And("Corporate user updates the company contact name to {string}")
    public void corporateUserUpdatesTheCompanyContactNameTo(String contactName) {
        profilePage.updateCompanyContactName(contactName);
    }

    @And("Corporate user clicks the {string} button")
    public void corporateUserClicksTheButton(String buttonName) {

        switch (buttonName) {
            case "Save":
                profilePage.clickSaveButton();
                break;
            case "Cancel":
                profilePage.clickCancelButton();
                break;
            default:
                throw new IllegalArgumentException("Unknown button: " + buttonName);
        }
    }

    @Then("Corporate user should see a message {string}")
    public void corporateUserShouldSeeAMessage(String expectedMessage) {
        userShouldSeeAMessage(expectedMessage);
    }

    @When("User navigates to the {string} section in their profile")
    public void userNavigatesToTheSectionInTheirProfile(String sectionName) {
        if (sectionName.equals("Invoices")) {
            profilePage.navigateToInvoicesSection();
        }
        userNavigatesToThePage(sectionName);
    }

    @Then("User should see a list of their previous reservations")
    public void userShouldSeeAListOfTheirPreviousReservations() {
        profilePage.isPreviousReservationsListDisplayed();
        assert profilePage.isPreviousReservationsListDisplayed() : "No previous reservations found";
    }

    @When("Corporate user navigates to the {string} section in their profile")
    public void corporateUserNavigatesToTheSectionInTheirProfile(String sectionName) {
        userNavigatesToTheSectionInTheirProfile(sectionName);
    }

    @Then("Corporate user should see a list of their previous reservations")
    public void corporateUserShouldSeeAListOfTheirPreviousReservations() {
        userShouldSeeAListOfTheirPreviousReservations();
    }


    @And("User selects the reservation for which the invoice is needed")
    public void userSelectsTheReservationForWhichTheInvoiceIsNeeded() {
        profilePage.selectReservation("reservation123"); // Sample reservation id
    }
    @Then("User should be able to view the invoice with details")
    public void userShouldBeAbleToViewTheInvoiceWithDetails() {
        boolean isDisplayed = profilePage.isInvoiceDetailsDisplayed();
        assert isDisplayed : "Invoice details are not displayed";
    }

    @And("User should be able to download the invoice as a PDF")
    public void userShouldBeAbleToDownloadTheInvoiceAsAPDF() {
        profilePage.downloadInvoiceAsPDF();
    }


}
