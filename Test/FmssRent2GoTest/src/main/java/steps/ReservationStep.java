package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ReservationPage;

public class ReservationStep {
    private ReservationPage reservationPage;

    public ReservationStep(ReservationPage reservationPage) {
        this.reservationPage = reservationPage;
    }

    @When("User navigates to the reservation page")
    public void userNavigatesToTheReservationPage() {
        reservationPage.navigateToReservationPage();
    }

    @And("User selects pickup and drop-off dates and location")
    public void userSelectsPickupAndDropOffDatesAndLocation() {
        reservationPage.selectPickupAndDropOffDates("2023-08-01", "2023-08-05");
        reservationPage.selectLocation("New York");
    }

    @And("User selects a vehicle")
    public void userSelectsAVehicle() {
        reservationPage.selectVehicle();
    }

    @And("navigate to payment page")
    public void navigateToPaymentPage() {
        reservationPage.navigateToPaymentPage();
    }

    @Then("User should see a reservation confirmation with details")
    public void userShouldSeeAReservationConfirmationWithDetails() {
        boolean isDisplayed = reservationPage.isReservationConfirmationDisplayed();
        assert isDisplayed : "Reservation confirmation is not displayed";
    }

    @When("Corporate user navigates to the reservation page")
    public void corporateUserNavigatesToTheReservationPage() {
        reservationPage.navigateToReservationPage();
    }

    @And("Corporate user selects pickup and drop-off dates and location")
    public void corporateUserSelectsPickupAndDropOffDatesAndLocation() {
        reservationPage.selectPickupAndDropOffDates("2023-08-01", "2023-08-05");
        reservationPage.selectLocation("San Francisco");
    }

    @And("Corporate user selects a vehicle and completes the payment")
    public void corporateUserSelectsAVehicleAndCompletesThePayment() {
        reservationPage.selectVehicleAndCompletePayment();
    }

    @Then("Corporate user should see a reservation confirmation with details")
    public void corporateUserShouldSeeAReservationConfirmationWithDetails() {
        boolean isDisplayed = reservationPage.isReservationConfirmationDisplayed();
        assert isDisplayed : "Corporate reservation confirmation is not displayed";
    }


    @When("User navigates to the reservation details page")
    public void userNavigatesToTheReservationDetailsPage() {
        reservationPage.navigateToReservationDetailsPage();
    }

    @Then("User should see a confirmation message {string}")
    public void userShouldSeeAConfirmationMessage(String expectedMessage) {
        String actualMessage = reservationPage.getConfirmationMessage();
        assert actualMessage.equals(expectedMessage) : "Confirmation message does not match";
    }
}
