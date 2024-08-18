package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ProfilePage;

public class InvoiceStep {


    private ProfilePage profilePage;

    public InvoiceStep(ProfilePage profilePage) {
        this.profilePage = profilePage;
    }


    @Given("User has completed a reservation")
    public void userHasCompletedAReservation() {

        boolean hasCompleted = profilePage.hasCompletedReservation();
        assert hasCompleted : "User has not completed any reservation";
    }

    @And("User selects the reservation for which the invoice is needed")
    public void userSelectsTheReservationForWhichTheInvoiceIsNeeded() {
        profilePage.navigateToInvoicesSection();
        profilePage.selectReservation("reservation_id_example");
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

    @Given("Corporate user has completed a reservation")
    public void corporateUserHasCompletedAReservation() {

        boolean hasCompleted = profilePage.hasCompletedReservation();
        assert hasCompleted : "Corporate user has not completed any reservation";
    }

    @And("Corporate user selects the reservation for which the invoice is needed")
    public void corporateUserSelectsTheReservationForWhichTheInvoiceIsNeeded() {
        profilePage.navigateToInvoicesSection();
        profilePage.selectReservation("corporate_reservation_id_example");
    }

    @Then("Corporate user should be able to view the invoice with details")
    public void corporateUserShouldBeAbleToViewTheInvoiceWithDetails() {
        boolean isDisplayed = profilePage.isInvoiceDetailsDisplayed();
        assert isDisplayed : "Corporate invoice details are not displayed";
    }

    @And("Corporate user should be able to download the invoice as a PDF")
    public void corporateUserShouldBeAbleToDownloadTheInvoiceAsAPDF() {
        profilePage.downloadInvoiceAsPDF();
    }
}
