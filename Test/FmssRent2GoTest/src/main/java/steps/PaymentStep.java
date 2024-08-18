package steps;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PaymentPage;
import pages.ReservationPage;
import utils.DriverManager;

public class PaymentStep {
    private AppiumDriver<MobileElement> driver;
    private ReservationPage reservationPage;
    private PaymentPage paymentPage;


    public PaymentStep() {
        this.driver = DriverManager.getDriver();
        this.paymentPage = new PaymentPage(driver);
        this.reservationPage = new ReservationPage(driver);
    }
    @Given("User opens the app")
    public void userOpensTheApp() {
        driver.launchApp();
    }

    @Given("User has selected a vehicle and entered reservation details")
    public void userHasSelectedAVehicleAndEnteredReservationDetails() {
        reservationPage.navigateToReservationPage();


        reservationPage.selectPickupAndDropOffDates("2023-08-01", "2023-08-05"); // Sample dates
        reservationPage.selectLocation("New York"); // Sample location


        reservationPage.selectVehicle();
        boolean isConfirmationDisplayed = reservationPage.isReservationConfirmationDisplayed();
        if (isConfirmationDisplayed) {
            reservationPage.navigateToPaymentPage();
            throw new RuntimeException("Reservation was not completed successfully.");
        }
    }

    @When("User enters valid credit card information")
    public void userEntersValidCreditCardInformation() {
        paymentPage.enterCardDetails("4111111111111111", "123");
        paymentPage.completePayment();
    }

    @Then("User should see a payment confirmation message")
    public void userShouldSeeAPaymentConfirmationMessage() {
        boolean isConfirmationDisplayed = paymentPage.isPaymentConfirmationDisplayed();
        assert isConfirmationDisplayed : "Payment confirmation message is not displayed";
    }

    @When("User enters invalid credit card information")
    public void userEntersInvalidCreditCardInformation() {
        paymentPage.enterCardDetails("0000000000000000", "000");
        paymentPage.completePayment();
    }

    @Then("User should see an error message {string}")
    public void userShouldSeeAnErrorMessage(String expectedErrorMessage) {
        String actualErrorMessage = paymentPage.getPaymentErrorMessage();
        assert actualErrorMessage.equals(expectedErrorMessage) :
                "Expected error message: " + expectedErrorMessage + " but got: " + actualErrorMessage;
    }
}
